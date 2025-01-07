package cn.lanqiao.finalTest.controller;


import cn.hutool.core.util.IdUtil;
import cn.lanqiao.finalTest.dao.Admin;
import cn.lanqiao.finalTest.model.dto.admin.AdminAdd;
import cn.lanqiao.finalTest.model.dto.admin.AdminQuery;
import cn.lanqiao.finalTest.model.vo.AdminVO;
import cn.lanqiao.finalTest.service.AdminService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.lanqiao.finalTest.utils.ResponseUtils;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;


@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 注册功能
     */
    @RequestMapping("/register")
    //因为 @RequestBody是会将一个属性 变成一个对象
    public ResponseUtils<Admin> register(@RequestBody AdminAdd adminAdd, HttpServletRequest request){
        try {
            // 1. 基础参数验证
            if (adminAdd == null || adminAdd.getUsername() == null || adminAdd.getPassword() == null) {
                return new ResponseUtils<>(301, "用户名和密码不能为空");
            }

            // 2. 检查用户名是否已存在
            Admin existingAdmin = adminService.findByUsername(adminAdd.getUsername());
            if (existingAdmin != null) {
                return new ResponseUtils<>(303, "该用户名已存在");
            }

            // 3. 验证密码格式
            if (!isValidPassword(adminAdd.getPassword())) {
                return new ResponseUtils<>(302, "密码必须为6-10位英文和数字的组合");
            }

            // 4. 执行注册
            int result = adminService.register(adminAdd);
            return result == 1 
                ? new ResponseUtils<>(200, "注册成功")
                : new ResponseUtils<>(304, "注册失败");

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils<>(500, "注册异常：" + e.getMessage());
        }
    }
    // 添加密码验证的辅助方法
    private boolean isValidPassword(String password) {
        // 密码必须包含英文和数字，长度在6-10位之间
        String regex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,10}$";
        return password.matches(regex);
    }

    /**
     * 登录页面
     */

    @RequestMapping("/login")
    public ResponseUtils login(@RequestBody AdminQuery adminQuery, HttpServletResponse response, HttpServletRequest request){
        try {
            Admin userLogin = adminService.login(adminQuery);
            if (userLogin != null) {
                // 登录成功
                if (adminQuery.isRememberMe()) {  // 修改这里，使用与 AdminQuery 类一致的属性名
                    // 勾选记住我
                    Cookie cookie1 = new Cookie("username", URLEncoder.encode(adminQuery.getUsername(), "UTF-8"));
                    Cookie cookie2 = new Cookie("password", URLEncoder.encode(adminQuery.getPassword(), "UTF-8"));

                    cookie1.setMaxAge(60 * 60 * 24 * 7);
                    cookie2.setMaxAge(60 * 60 * 24 * 7);

                    cookie1.setPath("/");
                    cookie2.setPath("/");

                    response.addCookie(cookie1);
                    response.addCookie(cookie2);
                }

                // 生成token
                String token = IdUtil.fastSimpleUUID();
                stringRedisTemplate.opsForValue().set("lanqiao:token" + userLogin.getUsername(), token, 30, TimeUnit.MINUTES);

                // 存储用户信息到Redis
                String strUserLogin = objectMapper.writeValueAsString(userLogin);
                stringRedisTemplate.opsForValue().set("lanqiao:userLogin:" + userLogin.getUsername(), strUserLogin, 30, TimeUnit.MINUTES);

                // 返回登录信息
                AdminVO adminVO = new AdminVO();
                adminVO.setUsername(userLogin.getUsername());
                adminVO.setPassword(userLogin.getPassword());
                adminVO.setToken(token);
                return new ResponseUtils(200, "登录成功", adminVO);
            } else {
                return new ResponseUtils<>(500, "用户名或密码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils<>(500, "登录失败：" + e.getMessage());  // 返回具体错误信息
        }
    }

}

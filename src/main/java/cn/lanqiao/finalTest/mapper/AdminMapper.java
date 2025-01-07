package cn.lanqiao.finalTest.mapper;


import cn.lanqiao.finalTest.dao.Admin;
import cn.lanqiao.finalTest.model.dto.admin.AdminAdd;
import cn.lanqiao.finalTest.model.dto.admin.AdminQuery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {
    /**
     * 注册功能
     */
    @Insert("insert into admin values (#{username}, #{password}, 0)")
    int register(AdminAdd admin);

    /**
     * 检查用户名是否存在
     * @param username
     * @return
     */
    @Select("SELECT * FROM admin WHERE username = #{username}")
    Admin findByUsername(String username);
    /**
     * 登录功能
     */
    @Select("select * from admin where username = #{username} and password = #{password} and is_delete = 0")
    Admin login(AdminQuery adminQuery);
}

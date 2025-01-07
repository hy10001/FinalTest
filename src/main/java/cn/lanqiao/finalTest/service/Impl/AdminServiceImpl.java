package cn.lanqiao.finalTest.service.Impl;

import cn.lanqiao.finalTest.dao.Admin;
import cn.lanqiao.finalTest.mapper.AdminMapper;
import cn.lanqiao.finalTest.model.dto.admin.AdminAdd;
import cn.lanqiao.finalTest.model.dto.admin.AdminQuery;
import cn.lanqiao.finalTest.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public int register(AdminAdd admin) {
        try {
            int result = adminMapper.register(admin);
            if(result > 0){
                //注册成功
                return 1;
            }else {
                //注册失败
                return 0;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Admin findByUsername(String username) {
        return adminMapper.findByUsername(username);
    }

    @Override
    public Admin login(AdminQuery adminQuery) {
        Admin result = adminMapper.login(adminQuery);
        if(result != null){
            return result;
        }else {
            return null;
        }
    }
}

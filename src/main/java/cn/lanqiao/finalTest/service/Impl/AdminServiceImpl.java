package cn.lanqiao.finalTest.service.Impl;

import cn.lanqiao.finalTest.dao.Admin;
import cn.lanqiao.finalTest.mapper.AdminMapper;
import cn.lanqiao.finalTest.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(Admin admin) {
        Admin result = AdminMapper.login(admin);
        if(result != null){
            return result;
        }else {
            return null;
        }
    }

}

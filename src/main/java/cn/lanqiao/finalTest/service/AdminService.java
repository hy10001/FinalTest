package cn.lanqiao.finalTest.service;

import cn.lanqiao.finalTest.dao.Admin;
import cn.lanqiao.finalTest.model.dto.admin.AdminAdd;
import cn.lanqiao.finalTest.model.dto.admin.AdminQuery;

public interface AdminService {
    /**
     * 注册功能
     */
    int register(AdminAdd admin);

    /**
     * 检查是否有用户名
     */
    Admin findByUsername(String username);

    /**
     * 登录功能
     */
    Admin login(AdminQuery adminQuery);
 }

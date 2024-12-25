package cn.lanqiao.finalTest.mapper;


import cn.lanqiao.finalTest.dao.Admin;
import org.apache.ibatis.annotations.Select;

public interface AdminMapper {
    /**
     * 登录功能
     */
    @Select("select * from admin where username = #{username} and password = #{password} and is_delete = 0")
    Admin login(Admin admin);
}

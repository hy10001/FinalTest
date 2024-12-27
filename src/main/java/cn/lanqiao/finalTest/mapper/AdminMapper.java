//package cn.lanqiao.finalTest.mapper;
//
//
//import cn.lanqiao.finalTest.dao.Admin;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Select;
//
//@Mapper
//public interface AdminMapper {
//    /**
//     * 登录功能
//     */
//    @Select("select * from admin where username = #{username} and password = #{password} and is_delete = 0")
//    static Admin login(Admin admin);
//}

package cn.lanqiao.finalTest.mapper;




import cn.lanqiao.finalTest.model.pojo.Dish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DishMapper {

    @Select("SELECT * FROM dish WHERE id = #{id}")
    Dish findById(@Param("id") Long id);

    // 可以根据需要添加其他方法
}
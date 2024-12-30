package cn.lanqiao.finalTest.mapper;




import cn.lanqiao.finalTest.model.pojo.CartItem;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CartMapper {

    @Select("SELECT * FROM cart_items WHERE user_id = #{userId} AND dish_id = #{dishId}")
    CartItem findByUserIdAndDishId(@Param("userId") Long userId, @Param("dishId") Long dishId);

    @Insert("INSERT INTO cart_items (user_id, dish_id, dish_name, price, quantity, subtotal) " +
            "VALUES (#{userId}, #{dishId}, #{dishName}, #{price}, #{quantity}, #{subtotal})")
    void insertCartItem(CartItem cartItem);

    @Update("UPDATE cart_items SET quantity = #{quantity}, subtotal = #{subtotal} " +
            "WHERE user_id = #{userId} AND dish_id = #{dishId}")
    void updateCartItem(CartItem cartItem);

    @Delete("DELETE FROM cart_items WHERE user_id = #{userId} AND dish_id = #{dishId}")
    void deleteCartItem(@Param("userId") Long userId, @Param("dishId") Long dishId);

    @Select("SELECT * FROM cart_items WHERE user_id = #{userId}")
    List<CartItem> findByUserId(Long userId);

    @Delete("DELETE FROM cart_items WHERE user_id = #{userId}")
    void deleteByUserId(Long userId);

    @Select("SELECT SUM(subtotal) FROM cart_items WHERE user_id = #{userId}")
    Double calculateTotal(Long userId);
}
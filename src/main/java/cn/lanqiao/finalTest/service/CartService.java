package cn.lanqiao.finalTest.service;




import cn.lanqiao.finalTest.model.pojo.CartItem;

import java.util.List;

public interface CartService {
    // 添加商品到购物车
    void addToCart(Long userId, Long dishId, Integer quantity);

    // 从购物车移除商品
    void removeFromCart(Long userId, Long dishId);

    // 更新购物车商品数量
    void updateQuantity(Long userId, Long dishId, Integer quantity);

    // 获取用户的购物车列表
    List<CartItem> getCartItems(Long userId);

    // 清空购物车
    void clearCart(Long userId);

    // 获取购物车总金额
    Double getCartTotal(Long userId);
}
package cn.lanqiao.finalTest.service.Impl;




import cn.lanqiao.finalTest.mapper.CartMapper;
import cn.lanqiao.finalTest.mapper.DishMapper;
import cn.lanqiao.finalTest.model.pojo.CartItem;
import cn.lanqiao.finalTest.model.pojo.Dish;
import cn.lanqiao.finalTest.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private DishMapper dishMapper;

    @Override
    @Transactional
    public void addToCart(Long userId, Long dishId, Integer quantity) {
        // 检查购物车是否已存在该商品
        CartItem existingItem = cartMapper.findByUserIdAndDishId(userId, dishId);

        if (existingItem != null) {
            // 如果已存在，更新数量
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
            existingItem.setSubtotal(existingItem.getPrice() * existingItem.getQuantity());
            cartMapper.updateCartItem(existingItem);
        } else {
            // 如果不存在，新增购物车项
            Dish dish = dishMapper.findById(dishId);
            CartItem newItem = new CartItem();
            newItem.setUserId(userId);
            newItem.setDishId(dishId);
            newItem.setDishName(dish.getName());
            newItem.setPrice(dish.getPrice());
            newItem.setQuantity(quantity);
            newItem.setSubtotal(dish.getPrice() * quantity);
            cartMapper.insertCartItem(newItem);
        }
    }

    @Override
    public void removeFromCart(Long userId, Long dishId) {
        cartMapper.deleteCartItem(userId, dishId);
    }

    @Override
    @Transactional
    public void updateQuantity(Long userId, Long dishId, Integer quantity) {
        CartItem item = cartMapper.findByUserIdAndDishId(userId, dishId);
        if (item != null) {
            item.setQuantity(quantity);
            item.setSubtotal(item.getPrice() * quantity);
            cartMapper.updateCartItem(item);
        }
    }

    @Override
    public List<CartItem> getCartItems(Long userId) {
        return cartMapper.findByUserId(userId);
    }

    @Override
    public void clearCart(Long userId) {
        cartMapper.deleteByUserId(userId);
    }

    @Override
    public Double getCartTotal(Long userId) {
        return cartMapper.calculateTotal(userId);
    }
}
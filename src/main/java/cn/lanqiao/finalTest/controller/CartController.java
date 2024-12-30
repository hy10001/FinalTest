package cn.lanqiao.finalTest.controller;



import cn.lanqiao.finalTest.model.pojo.CartItem;
import cn.lanqiao.finalTest.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<?> addToCart(
            @RequestParam Long userId,
            @RequestParam Long dishId,
            @RequestParam Integer quantity) {
        cartService.addToCart(userId, dishId, quantity);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> removeFromCart(
            @RequestParam Long userId,
            @RequestParam Long dishId) {
        cartService.removeFromCart(userId, dishId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateQuantity(
            @RequestParam Long userId,
            @RequestParam Long dishId,
            @RequestParam Integer quantity) {
        cartService.updateQuantity(userId, dishId, quantity);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/items")
    public ResponseEntity<List<CartItem>> getCartItems(@RequestParam Long userId) {
        List<CartItem> items = cartService.getCartItems(userId);
        return ResponseEntity.ok(items);
    }

    @GetMapping("/total")
    public ResponseEntity<Double> getCartTotal(@RequestParam Long userId) {
        Double total = cartService.getCartTotal(userId);
        return ResponseEntity.ok(total);
    }

    @DeleteMapping("/clear")
    public ResponseEntity<?> clearCart(@RequestParam Long userId) {
        cartService.clearCart(userId);
        return ResponseEntity.ok().build();
    }
}
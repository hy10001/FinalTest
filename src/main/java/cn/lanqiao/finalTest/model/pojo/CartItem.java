package cn.lanqiao.finalTest.model.pojo;



import lombok.Data;

@Data
public class CartItem {
    private Long id;
    private Long userId;    // 用户ID
    private Long dishId;    // 菜品ID
    private String dishName; // 菜品名称
    private Double price;   // 价格
    private Integer quantity; // 数量
    private Double subtotal; // 小计金额
}
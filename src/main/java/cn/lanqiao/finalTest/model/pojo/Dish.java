package cn.lanqiao.finalTest.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    private Long id;
    private String name;    // 菜品名称
    private Double price;   // 价格
    private String category; // 分类（热菜、凉菜、主食、汤类）
    private String image;   // 图片路径
    private String description; // 描述
    private Integer status; // 状态（1：在售，0：下架）
}
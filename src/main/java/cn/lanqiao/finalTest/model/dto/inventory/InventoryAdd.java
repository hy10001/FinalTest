package cn.lanqiao.finalTest.model.dto.inventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryAdd {
  private long inventoryId; //物品个数
  private String itemName; //物品名称
  private String category; //分类
  private double quantity; //当前库存
  private String status; //库存状态
  private String unit; //单价
  private java.sql.Timestamp lastUpdated; //最近入库
  private String code;

}

package cn.lanqiao.finalTest.model.dto.inventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryEdit {
    private String itemName; //物品名称
    private double quantity; //当前库存
    private String unit; //单价
    private java.sql.Timestamp lastUpdated; //最近入库
}

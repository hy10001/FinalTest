package cn.lanqiao.finalTest.service;

import cn.lanqiao.finalTest.model.dto.inventory.InventoryAdd;
import cn.lanqiao.finalTest.model.dto.inventory.InventoryEdit;
import org.apache.ibatis.annotations.Update;

public interface InventoryService {
    /**
     * 入库登记
     */
    int add_stock(InventoryAdd inventoryAdd);
    /**
     * 入库
     */
    int update_stock(InventoryEdit inventoryEdit);
    /**
     * 出库
     */
    int delete_stock(String itemName);
}

package cn.lanqiao.finalTest.service;

import cn.lanqiao.finalTest.model.dto.inventory.InventoryAdd;

public interface InventoryService {
    /**
     * 入库登记
     */
    int add_stock(InventoryAdd inventoryAdd);
}

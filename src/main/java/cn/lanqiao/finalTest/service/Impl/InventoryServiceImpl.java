package cn.lanqiao.finalTest.service.Impl;

import cn.lanqiao.finalTest.mapper.InventoryMapper;
import cn.lanqiao.finalTest.model.dto.inventory.InventoryAdd;
import cn.lanqiao.finalTest.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryMapper inventoryMapper;

    public int add_stock(InventoryAdd inventoryAdd) {
        int result = inventoryMapper.add_stock(inventoryAdd);
        if (result > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}

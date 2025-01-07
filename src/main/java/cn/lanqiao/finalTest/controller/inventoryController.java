package cn.lanqiao.finalTest.controller;

import cn.lanqiao.finalTest.model.dto.inventory.InventoryAdd;
import cn.lanqiao.finalTest.model.dto.inventory.InventoryEdit;
import cn.lanqiao.finalTest.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class inventoryController {
    @Autowired
    private InventoryService inventoryService;

    @RequestMapping("/add_stock")
    public cn.lanqiao.finalTest.utils.ResponseUtils add_stock(@RequestBody InventoryAdd inventoryAdd){
        try {
            int result = inventoryService.add_stock(inventoryAdd);
            if (result == 1) {
                return new cn.lanqiao.finalTest.utils.ResponseUtils(200, "入库登记成功");
            } else {
                return new cn.lanqiao.finalTest.utils.ResponseUtils(300, "入库登记失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/update_stock")
    public cn.lanqiao.finalTest.utils.ResponseUtils update_stock(@RequestBody InventoryEdit inventoryEdit){
        try {
            int result = inventoryService.update_stock(inventoryEdit);
            if (result == 1) {
                return new cn.lanqiao.finalTest.utils.ResponseUtils(200, "入库成功");
            } else {
                return new cn.lanqiao.finalTest.utils.ResponseUtils(300, "入库失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    @RequestMapping("/delete_stock")
    public cn.lanqiao.finalTest.utils.ResponseUtils delete_stock(@RequestBody InventoryAdd inventoryAdd){
        try {
            int result = inventoryService.delete_stock(inventoryAdd.getItemName());
            if (result == 1) {
                return new cn.lanqiao.finalTest.utils.ResponseUtils(200, "出库成功");
            } else {
                return new cn.lanqiao.finalTest.utils.ResponseUtils(300, "出库失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

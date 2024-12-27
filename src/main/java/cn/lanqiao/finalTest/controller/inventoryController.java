package cn.lanqiao.finalTest.controller;

import cn.lanqiao.finalTest.model.dto.inventory.InventoryAdd;
import cn.lanqiao.finalTest.service.InventoryService;
import cn.lanqiao.finalTest.utils.ResponseUtils;
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
    public ResponseUtils add_stock(@RequestBody InventoryAdd inventoryAdd){
        try {
            int result = inventoryService.add_stock(inventoryAdd);
            if (result == 1) {
                return new ResponseUtils(200, "入库成功");
            } else {
                return new ResponseUtils(300, "入库失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}

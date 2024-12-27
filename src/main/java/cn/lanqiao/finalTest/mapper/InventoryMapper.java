package cn.lanqiao.finalTest.mapper;

import cn.lanqiao.finalTest.model.dto.inventory.InventoryAdd;
import org.apache.ibatis.annotations.Insert;

public interface InventoryMapper {
    /**
     * 入库登记
     */
    @Insert("insert into i_nventory values(null,#{itemName},#{category},#{quantity},#{unit},#{status})")
    int add_stock(InventoryAdd inventoryAdd) ;
}

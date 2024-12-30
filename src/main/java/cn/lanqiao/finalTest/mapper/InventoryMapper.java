package cn.lanqiao.finalTest.mapper;

import cn.lanqiao.finalTest.model.dto.inventory.InventoryAdd;
import cn.lanqiao.finalTest.model.dto.inventory.InventoryEdit;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface InventoryMapper {
    /**
     * 入库登记
     */
    @Insert("insert into i_nventory values(null,#{itemName},#{category},#{quantity},#{status},#{unit},0)")
    int add_stock(InventoryAdd inventoryAdd) ;
    /**
     * 入库
     */
    @Update("update i_nventory set quantity = #{quantity} ,unit = #{unit},status = #{status} ,lastUpdated = #{lastUpdated} where itemName = #{itemName}")
    int update_stock(InventoryEdit inventoryEdit);
    /**
     * 出库
     */
    @Update("update i_nventory set is_delete = 1 where itemName = #{itemName}")
    int delete_stock(String itemName);
}

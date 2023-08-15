package com.ruoyi.mapper;

import java.util.List;
import com.ruoyi.domain.Inventory;

/**
 * 库存列Mapper接口
 * 
 * @author ruoyi
 * @date 2023-05-10
 */
public interface InventoryMapper 
{
    /**
     * 查询库存列
     * 
     * @param inventoryId 库存列主键
     * @return 库存列
     */
    public Inventory selectInventoryByInventoryId(Long inventoryId);

    /**
     * 查询库存列列表
     * 
     * @param inventory 库存列
     * @return 库存列集合
     */
    public List<Inventory> selectInventoryList(Inventory inventory);

    /**
     * 新增库存列
     * 
     * @param inventory 库存列
     * @return 结果
     */
    public int insertInventory(Inventory inventory);

    /**
     * 修改库存列
     * 
     * @param inventory 库存列
     * @return 结果
     */
    public int updateInventory(Inventory inventory);

    /**
     * 删除库存列
     * 
     * @param inventoryId 库存列主键
     * @return 结果
     */
    public int deleteInventoryByInventoryId(Long inventoryId);

    /**
     * 批量删除库存列
     * 
     * @param inventoryIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteInventoryByInventoryIds(Long[] inventoryIds);
}

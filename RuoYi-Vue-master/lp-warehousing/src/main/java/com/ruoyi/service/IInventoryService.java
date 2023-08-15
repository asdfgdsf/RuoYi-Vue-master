package com.ruoyi.service;

import java.util.List;
import com.ruoyi.domain.Inventory;

/**
 * 库存列Service接口
 * 
 * @author ruoyi
 * @date 2023-05-10
 */
public interface IInventoryService 
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
     * 批量删除库存列
     * 
     * @param inventoryIds 需要删除的库存列主键集合
     * @return 结果
     */
    public int deleteInventoryByInventoryIds(Long[] inventoryIds);

    /**
     * 删除库存列信息
     * 
     * @param inventoryId 库存列主键
     * @return 结果
     */
    public int deleteInventoryByInventoryId(Long inventoryId);
}

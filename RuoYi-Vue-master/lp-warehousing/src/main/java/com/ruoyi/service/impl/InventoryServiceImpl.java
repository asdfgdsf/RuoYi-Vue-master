package com.ruoyi.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.InventoryMapper;
import com.ruoyi.domain.Inventory;
import com.ruoyi.service.IInventoryService;

/**
 * 库存列Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-10
 */
@Service
public class InventoryServiceImpl implements IInventoryService 
{
    @Autowired
    private InventoryMapper inventoryMapper;

    /**
     * 查询库存列
     * 
     * @param inventoryId 库存列主键
     * @return 库存列
     */
    @Override
    public Inventory selectInventoryByInventoryId(Long inventoryId)
    {
        return inventoryMapper.selectInventoryByInventoryId(inventoryId);
    }

    /**
     * 查询库存列列表
     * 
     * @param inventory 库存列
     * @return 库存列
     */
    @Override
    public List<Inventory> selectInventoryList(Inventory inventory)
    {
        return inventoryMapper.selectInventoryList(inventory);
    }

    /**
     * 新增库存列
     * 
     * @param inventory 库存列
     * @return 结果
     */
    @Override
    public int insertInventory(Inventory inventory)
    {
        inventory.setCreateTime(DateUtils.getNowDate());
        return inventoryMapper.insertInventory(inventory);
    }

    /**
     * 修改库存列
     * 
     * @param inventory 库存列
     * @return 结果
     */
    @Override
    public int updateInventory(Inventory inventory)
    {
        inventory.setUpdateTime(DateUtils.getNowDate());
        return inventoryMapper.updateInventory(inventory);
    }

    /**
     * 批量删除库存列
     * 
     * @param inventoryIds 需要删除的库存列主键
     * @return 结果
     */
    @Override
    public int deleteInventoryByInventoryIds(Long[] inventoryIds)
    {
        return inventoryMapper.deleteInventoryByInventoryIds(inventoryIds);
    }

    /**
     * 删除库存列信息
     * 
     * @param inventoryId 库存列主键
     * @return 结果
     */
    @Override
    public int deleteInventoryByInventoryId(Long inventoryId)
    {
        return inventoryMapper.deleteInventoryByInventoryId(inventoryId);
    }
}

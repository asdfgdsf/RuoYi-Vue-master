package com.ruoyi.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.WarehouseMapper;
import com.ruoyi.domain.Warehouse;
import com.ruoyi.service.IWarehouseService;

/**
 * 库房列Service业务层处理
 * 
 * @author zjj
 * @date 2023-05-10
 */
@Service
public class WarehouseServiceImpl implements IWarehouseService 
{
    @Autowired
    private WarehouseMapper warehouseMapper;

    /**
     * 查询库房列
     * 
     * @param warehouseId 库房列主键
     * @return 库房列
     */
    @Override
    public Warehouse selectWarehouseByWarehouseId(Long warehouseId)
    {
        return warehouseMapper.selectWarehouseByWarehouseId(warehouseId);
    }

    /**
     * 查询库房列列表
     * 
     * @param warehouse 库房列
     * @return 库房列
     */
    @Override
    public List<Warehouse> selectWarehouseList(Warehouse warehouse)
    {
        return warehouseMapper.selectWarehouseList(warehouse);
    }

    /**
     * 新增库房列
     * 
     * @param warehouse 库房列
     * @return 结果
     */
    @Override
    public int insertWarehouse(Warehouse warehouse)
    {
        warehouse.setCreateTime(DateUtils.getNowDate());
        return warehouseMapper.insertWarehouse(warehouse);
    }

    /**
     * 修改库房列
     * 
     * @param warehouse 库房列
     * @return 结果
     */
    @Override
    public int updateWarehouse(Warehouse warehouse)
    {
        warehouse.setUpdateTime(DateUtils.getNowDate());
        return warehouseMapper.updateWarehouse(warehouse);
    }

    /**
     * 批量删除库房列
     * 
     * @param warehouseIds 需要删除的库房列主键
     * @return 结果
     */
    @Override
    public int deleteWarehouseByWarehouseIds(Long[] warehouseIds)
    {
        return warehouseMapper.deleteWarehouseByWarehouseIds(warehouseIds);
    }

    /**
     * 删除库房列信息
     * 
     * @param warehouseId 库房列主键
     * @return 结果
     */
    @Override
    public int deleteWarehouseByWarehouseId(Long warehouseId)
    {
        return warehouseMapper.deleteWarehouseByWarehouseId(warehouseId);
    }
}

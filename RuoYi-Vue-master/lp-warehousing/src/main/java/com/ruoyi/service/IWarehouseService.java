package com.ruoyi.service;

import java.util.List;
import com.ruoyi.domain.Warehouse;

/**
 * 库房列Service接口
 * 
 * @author zjj
 * @date 2023-05-10
 */
public interface IWarehouseService 
{
    /**
     * 查询库房列
     * 
     * @param warehouseId 库房列主键
     * @return 库房列
     */
    public Warehouse selectWarehouseByWarehouseId(Long warehouseId);

    /**
     * 查询库房列列表
     * 
     * @param warehouse 库房列
     * @return 库房列集合
     */
    public List<Warehouse> selectWarehouseList(Warehouse warehouse);

    /**
     * 新增库房列
     * 
     * @param warehouse 库房列
     * @return 结果
     */
    public int insertWarehouse(Warehouse warehouse);

    /**
     * 修改库房列
     * 
     * @param warehouse 库房列
     * @return 结果
     */
    public int updateWarehouse(Warehouse warehouse);

    /**
     * 批量删除库房列
     * 
     * @param warehouseIds 需要删除的库房列主键集合
     * @return 结果
     */
    public int deleteWarehouseByWarehouseIds(Long[] warehouseIds);

    /**
     * 删除库房列信息
     * 
     * @param warehouseId 库房列主键
     * @return 结果
     */
    public int deleteWarehouseByWarehouseId(Long warehouseId);
}

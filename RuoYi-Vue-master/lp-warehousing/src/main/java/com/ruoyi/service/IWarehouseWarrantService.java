package com.ruoyi.service;

import java.util.List;

import com.ruoyi.Vo.WarehouseWarrantVo;
import com.ruoyi.domain.WarehouseWarrant;

/**
 * 入库列Service接口
 *
 * @author zjj
 * @date 2023-05-10
 */
public interface IWarehouseWarrantService
{
    /**
     * 查询入库列
     *
     * @param warehouseWarrantId 入库列主键
     * @return 入库列
     */
    public WarehouseWarrant selectWarehouseWarrantByWarehouseWarrantId(Long warehouseWarrantId);

    /**
     * 查询入库列列表
     *
     * @param warehouseWarrant 入库列
     * @return 入库列集合
     */
    public List<WarehouseWarrant> selectWarehouseWarrantList(WarehouseWarrant warehouseWarrant);

    /**
     * 新增入库列
     *
     * @param warehouseWarrant 入库列
     * @return 结果
     */
    public int insertWarehouseWarrant(WarehouseWarrant warehouseWarrant);

    /**
     * 修改入库列
     *
     * @param warehouseWarrant 入库列
     * @return 结果
     */
    public int updateWarehouseWarrant(WarehouseWarrant warehouseWarrant);

    /**
     * 批量删除入库列
     *
     * @param warehouseWarrantIds 需要删除的入库列主键集合
     * @return 结果
     */
    public int deleteWarehouseWarrantByWarehouseWarrantIds(Long[] warehouseWarrantIds);

    /**
     * 删除入库列信息
     *
     * @param warehouseWarrantId 入库列主键
     * @return 结果
     */
    public int deleteWarehouseWarrantByWarehouseWarrantId(Long warehouseWarrantId);
    public int auditWarehouseWarrant(WarehouseWarrantVo warehouseWarrantVo);

    public int approverWarehouseWarrant(WarehouseWarrantVo warehouseWarrantVo);
}

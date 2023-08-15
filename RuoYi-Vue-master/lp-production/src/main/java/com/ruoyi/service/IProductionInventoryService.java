package com.ruoyi.service;

import java.util.List;

import com.ruoyi.Vo.ProductionInventoryVo;
import com.ruoyi.domain.ProductionInventory;

/**
 * 生产耗材Service接口
 *
 * @author ruoyi
 * @date 2023-05-11
 */
public interface IProductionInventoryService
{
    /**
     * 查询生产耗材
     *
     * @param productionInventoryId 生产耗材主键
     * @return 生产耗材
     */
    public ProductionInventory selectProductionInventoryByProductionInventoryId(Long productionInventoryId);

    /**
     * 查询生产耗材列表
     *
     * @param productionInventory 生产耗材
     * @return 生产耗材集合
     */
    public List<ProductionInventory> selectProductionInventoryList(ProductionInventory productionInventory);

    /**
     * 新增生产耗材
     *
     * @param productionInventory 生产耗材
     * @return 结果
     */
    public int insertProductionInventory(ProductionInventory productionInventory);

    /**
     * 修改生产耗材
     *
     * @param productionInventory 生产耗材
     * @return 结果
     */
    public int updateProductionInventory(ProductionInventoryVo productionInventoryVo);

    /**
     * 批量删除生产耗材
     *
     * @param productionInventoryIds 需要删除的生产耗材主键集合
     * @return 结果
     */
    public int deleteProductionInventoryByProductionInventoryIds(Long[] productionInventoryIds);

    /**
     * 删除生产耗材信息
     *
     * @param productionInventoryId 生产耗材主键
     * @return 结果
     */
    public int deleteProductionInventoryByProductionInventoryId(Long productionInventoryId);
    public int auditProductionInventory(ProductionInventoryVo productionInventoryVo);

    public int approverProductionInventory(ProductionInventoryVo productionInventoryVo);
}

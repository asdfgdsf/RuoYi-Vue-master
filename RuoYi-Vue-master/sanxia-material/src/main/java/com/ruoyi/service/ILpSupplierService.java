package com.ruoyi.service;

import java.util.List;

import com.ruoyi.Vo.SupplierVo;
import com.ruoyi.domain.LpSupplier;

/**
 * 供应商Service接口
 *
 * @author zjj
 * @date 2023-05-06
 */
public interface ILpSupplierService
{
    /**
     * 查询供应商
     *
     * @param supplierId 供应商主键
     * @return 供应商
     */
    public LpSupplier selectLpSupplierBySupplierId(Long supplierId);

    /**
     * 查询供应商列表
     *
     * @param lpSupplier 供应商
     * @return 供应商集合
     */
    public List<LpSupplier> selectLpSupplierList(LpSupplier lpSupplier);

    /**
     * 新增供应商
     *
     * @param lpSupplier 供应商
     * @return 结果
     */
    public int insertLpSupplier(LpSupplier lpSupplier);

    /**
     * 修改供应商
     *
     * @param lpSupplier 供应商
     * @return 结果
     */
    public int updateLpSupplier(LpSupplier lpSupplier);

    /**
     * 批量删除供应商
     *
     * @param supplierIds 需要删除的供应商主键集合
     * @return 结果
     */
    public int deleteLpSupplierBySupplierIds(Long[] supplierIds);

    /**
     * 删除供应商信息
     *
     * @param supplierId 供应商主键
     * @return 结果
     */
    public int deleteLpSupplierBySupplierId(Long supplierId);
    public int auditSupplier(SupplierVo suppliervo);

    public int approverSupplier(SupplierVo suppliervo);
}

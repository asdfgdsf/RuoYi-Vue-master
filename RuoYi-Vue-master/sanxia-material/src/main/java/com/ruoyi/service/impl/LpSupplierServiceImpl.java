package com.ruoyi.service.impl;

import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

import com.ruoyi.Vo.SupplierVo;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.LpSupplierMapper;
import com.ruoyi.domain.LpSupplier;
import com.ruoyi.service.ILpSupplierService;

/**
 * 供应商Service业务层处理
 *
 * @author zjj
 * @date 2023-05-06
 */
@Service
public class LpSupplierServiceImpl implements ILpSupplierService
{
    @Autowired(required = false)
    private LpSupplierMapper lpSupplierMapper;

    /**
     * 查询供应商
     *
     * @param supplierId 供应商主键
     * @return 供应商
     */
    @Override
    public LpSupplier selectLpSupplierBySupplierId(Long supplierId)
    {
        return lpSupplierMapper.selectLpSupplierBySupplierId(supplierId);
    }

    /**
     * 查询供应商列表
     *
     * @param lpSupplier 供应商
     * @return 供应商
     */
    @Override
    public List<LpSupplier> selectLpSupplierList(LpSupplier lpSupplier)
    {
        return lpSupplierMapper.selectLpSupplierList(lpSupplier);
    }

    /**
     * 新增供应商
     *
     * @param lpSupplier 供应商
     * @return 结果
     */
    @Override
    public int insertLpSupplier(LpSupplier lpSupplier)
    {
        lpSupplier.setCreateTime(DateUtils.getNowDate());
        return lpSupplierMapper.insertLpSupplier(lpSupplier);
    }

    /**
     * 修改供应商
     *
     * @param lpSupplier 供应商
     * @return 结果
     */
    @Override
    public int updateLpSupplier(LpSupplier lpSupplier)
    {
        lpSupplier.setUpdateTime(DateUtils.getNowDate());
        return lpSupplierMapper.updateLpSupplier(lpSupplier);
    }

    /**
     * 批量删除供应商
     *
     * @param supplierIds 需要删除的供应商主键
     * @return 结果
     */
    @Override
    public int deleteLpSupplierBySupplierIds(Long[] supplierIds)
    {
        return lpSupplierMapper.deleteLpSupplierBySupplierIds(supplierIds);
    }

    /**
     * 删除供应商信息
     *
     * @param supplierId 供应商主键
     * @return 结果
     */
    @Override
    public int deleteLpSupplierBySupplierId(Long supplierId)
    {
        return lpSupplierMapper.deleteLpSupplierBySupplierId(supplierId);
    }
    @Override
    public int auditSupplier(SupplierVo suppliervo) {
        LpSupplier supplier = new LpSupplier();
        supplier.setSupplierId(suppliervo.getSupplierId());
        supplier.setAuditStatus((long) Integer.parseInt(suppliervo.getAuditStatus()));
        supplier.setApproverOpinion(suppliervo.getApproverOpinion());
        supplier.setApproverTime(new Date());
        supplier.setApproverPerson(SecurityUtils.getUsername());
        return lpSupplierMapper.updateLpSupplier(supplier);
    }

    @Override
    public int approverSupplier(SupplierVo suppliervo) {
        LpSupplier supplier = new LpSupplier();
        supplier.setSupplierId(suppliervo.getSupplierId());
        supplier.setAuditStatus((long) Integer.parseInt(suppliervo.getAuditStatus()));
        supplier.setApproverOpinion(suppliervo.getApproverOpinion());
        supplier.setApproverTime(new Date());
        supplier.setApproverPerson(SecurityUtils.getUsername());
        return lpSupplierMapper.updateLpSupplier(supplier);
    }
}

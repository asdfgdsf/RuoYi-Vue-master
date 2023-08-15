package com.ruoyi.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.Vo.EquipmentVo;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.domain.LpFinance;
import com.ruoyi.mapper.LpFinanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.LpEquipmentMapper;
import com.ruoyi.domain.LpEquipment;
import com.ruoyi.service.ILpEquipmentService;

/**
 * 设备列Service业务层处理
 *
 * @author zjj
 * @date 2023-05-08
 */
@Service
public class LpEquipmentServiceImpl implements ILpEquipmentService
{
    @Autowired(required = false)
    private LpEquipmentMapper lpEquipmentMapper;
    @Autowired(required = false)
    private LpFinanceMapper lpFinanceMapper;

    /**
     * 查询设备列
     *
     * @param equipmentId 设备列主键
     * @return 设备列
     */
    @Override
    public LpEquipment selectLpEquipmentByEquipmentId(Long equipmentId)
    {
        return lpEquipmentMapper.selectLpEquipmentByEquipmentId(equipmentId);
    }

    /**
     * 查询设备列列表
     *
     * @param lpEquipment 设备列
     * @return 设备列
     */
    @Override
    public List<LpEquipment> selectLpEquipmentList(LpEquipment lpEquipment)
    {
        return lpEquipmentMapper.selectLpEquipmentList(lpEquipment);
    }

    /**
     * 新增设备列
     *
     * @param lpEquipment 设备列
     * @return 结果
     */
    @Override
    public int insertLpEquipment(LpEquipment lpEquipment)
    {
        lpEquipment.setCreateTime(DateUtils.getNowDate());
        return lpEquipmentMapper.insertLpEquipment(lpEquipment);
    }

    /**
     * 修改设备列
     *
     * @param lpEquipment 设备列
     * @return 结果
     */
    @Override
    public int updateLpEquipment(LpEquipment lpEquipment)
    {
        lpEquipment.setUpdateTime(DateUtils.getNowDate());
        return lpEquipmentMapper.updateLpEquipment(lpEquipment);
    }

    /**
     * 批量删除设备列
     *
     * @param equipmentIds 需要删除的设备列主键
     * @return 结果
     */
    @Override
    public int deleteLpEquipmentByEquipmentIds(Long[] equipmentIds)
    {
        return lpEquipmentMapper.deleteLpEquipmentByEquipmentIds(equipmentIds);
    }

    /**
     * 删除设备列信息
     *
     * @param equipmentId 设备列主键
     * @return 结果
     */
    @Override
    public int deleteLpEquipmentByEquipmentId(Long equipmentId)
    {
        return lpEquipmentMapper.deleteLpEquipmentByEquipmentId(equipmentId);
    }
    @Override
    public int maintainEquipment(LpEquipment lpEquipment) {
        return lpEquipmentMapper.updateLpEquipment(lpEquipment);
    }
    @Override
    public int auditEquipment(EquipmentVo equipmentVo) {

        LpEquipment equipment = new LpEquipment();
        equipment.setEquipmentId(equipmentVo.getEquipmentId());
        equipment.setAuditStatus(equipmentVo.getAuditStatus());
        equipment.setAuditPerson(SecurityUtils.getUsername());
        equipment.setAuditOpinion(equipmentVo.getAuditOpinion());
        equipment.setAuditTime(new Date());
        return lpEquipmentMapper.updateLpEquipment(equipment);
    }

    @Override
    public int approverEquipment(EquipmentVo equipmentVo) {
        LpEquipment equipment = new LpEquipment();
        equipment.setEquipmentId(equipmentVo.getEquipmentId());
        equipment.setAuditStatus(equipmentVo.getAuditStatus());
        equipment.setApproverOpinion(equipmentVo.getApproverOpinion());
        equipment.setApproverTime(new Date());
        equipment.setApproverPerson(SecurityUtils.getUsername());
        int num= lpEquipmentMapper.updateLpEquipment(equipment);
        if(num > 0){
            LpEquipment equipment1 = lpEquipmentMapper.selectLpEquipmentByEquipmentId(equipmentVo.getEquipmentId());
            LpFinance money = lpFinanceMapper.selectfinanceBalance();
            if(equipment1.getAuditStatus().intValue() == 2){
                LpFinance finance = new LpFinance();
                finance.setFinanceName("购买"+equipment1.getEquipmentName());
                finance.setFinanceMoney(equipment1.getPrice());
                finance.setSupplierId(equipment1.getSupplierId());
                finance.setFinanceStatus(0L);
                finance.setAuditStatus(0L);
                finance.setCreateTime(new Date());
                finance.setCreateBy(SecurityUtils.getUsername());
                System.out.println("money======"+money.getFinanceBalance());
                finance.setFinanceBalance(money.getFinanceBalance());
                return lpFinanceMapper.insertLpFinance(finance);
            }

        }
        return 1;
    }
}

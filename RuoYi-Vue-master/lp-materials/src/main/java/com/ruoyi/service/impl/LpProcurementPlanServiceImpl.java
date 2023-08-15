package com.ruoyi.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.Vo.ProcurementPlanVo;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.domain.LpMaterials;
import com.ruoyi.mapper.LpMaterialsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.LpProcurementPlanMapper;
import com.ruoyi.domain.LpProcurementPlan;
import com.ruoyi.service.ILpProcurementPlanService;

/**
 * 采购计划Service业务层处理
 *
 * @author zjj
 * @date 2023-05-10
 */
@Service
public class LpProcurementPlanServiceImpl implements ILpProcurementPlanService
{
    @Autowired(required = false)
    private LpProcurementPlanMapper lpProcurementPlanMapper;
    @Autowired(required = false)
    private LpMaterialsMapper lpMaterialsMapper;

    /**
     * 查询采购计划
     *
     * @param procurementPlanId 采购计划主键
     * @return 采购计划
     */
    @Override
    public LpProcurementPlan selectLpProcurementPlanByProcurementPlanId(Long procurementPlanId)
    {
        return lpProcurementPlanMapper.selectLpProcurementPlanByProcurementPlanId(procurementPlanId);
    }

    /**
     * 查询采购计划列表
     *
     * @param lpProcurementPlan 采购计划
     * @return 采购计划
     */
    @Override
    public List<LpProcurementPlan> selectLpProcurementPlanList(LpProcurementPlan lpProcurementPlan)
    {
        return lpProcurementPlanMapper.selectLpProcurementPlanList(lpProcurementPlan);
    }

    /**
     * 新增采购计划
     *
     * @param lpProcurementPlan 采购计划
     * @return 结果
     */
    @Override
    public int insertLpProcurementPlan(LpProcurementPlan lpProcurementPlan)
    {
        lpProcurementPlan.setCreateTime(DateUtils.getNowDate());
        return lpProcurementPlanMapper.insertLpProcurementPlan(lpProcurementPlan);
    }

    /**
     * 修改采购计划
     *
     * @param lpProcurementPlan 采购计划
     * @return 结果
     */
    @Override
    public int updateLpProcurementPlan(LpProcurementPlan lpProcurementPlan)
    {
        lpProcurementPlan.setUpdateTime(DateUtils.getNowDate());
        return lpProcurementPlanMapper.updateLpProcurementPlan(lpProcurementPlan);
    }

    /**
     * 批量删除采购计划
     *
     * @param procurementPlanIds 需要删除的采购计划主键
     * @return 结果
     */
    @Override
    public int deleteLpProcurementPlanByProcurementPlanIds(Long[] procurementPlanIds)
    {
        return lpProcurementPlanMapper.deleteLpProcurementPlanByProcurementPlanIds(procurementPlanIds);
    }

    /**
     * 删除采购计划信息
     *
     * @param procurementPlanId 采购计划主键
     * @return 结果
     */
    @Override
    public int deleteLpProcurementPlanByProcurementPlanId(Long procurementPlanId)
    {
        return lpProcurementPlanMapper.deleteLpProcurementPlanByProcurementPlanId(procurementPlanId);
    }

    @Override
    public int auditProcurementPlan(ProcurementPlanVo procurementPlanVo) {
        LpProcurementPlan procurementPlan = new LpProcurementPlan();
        procurementPlan.setProcurementPlanId(procurementPlanVo.getProcurementPlanId());
        procurementPlan.setAuditStatus(procurementPlanVo.getAuditStatus());
        procurementPlan.setAuditOpinion(procurementPlanVo.getAuditOpinion());
        procurementPlan.setAuditTime(new Date());
        procurementPlan.setAuditPerson(SecurityUtils.getUsername());

        return lpProcurementPlanMapper.updateLpProcurementPlan(procurementPlan);
    }

    @Override
    public int approverProcurementPlan(ProcurementPlanVo procurementPlanVo) {
        LpProcurementPlan procurementPlan = new LpProcurementPlan();
        procurementPlan.setProcurementPlanId(procurementPlanVo.getProcurementPlanId());
        procurementPlan.setAuditStatus(procurementPlanVo.getAuditStatus());
        procurementPlan.setApproverOpinion(procurementPlanVo.getApproverOpinion());
        procurementPlan.setApproverTime(new Date());
        procurementPlan.setApproverPerson(SecurityUtils.getUsername());

        lpProcurementPlanMapper.updateLpProcurementPlan(procurementPlan);

        LpProcurementPlan plan = lpProcurementPlanMapper.selectLpProcurementPlanByProcurementPlanId((long) procurementPlanVo.getProcurementPlanId().intValue());

        if(plan.getAuditStatus().intValue() == 2){

            LpMaterials materials = new LpMaterials();
            materials.setMaterialsName(plan.getProcurementPlanName());
            materials.setMaterialsNum(plan.getProcurementPlanNum());
            materials.setMaterialsPrice(plan.getProcurementPlanPrice());
            materials.setUnit(plan.getUnit());
            materials.setRemark(plan.getRemark());
            materials.setCreateTime(new Date());
            materials.setCreateBy("系统创建");
            return lpMaterialsMapper.insertLpMaterials(materials);
        }
        return 1;
    }
}

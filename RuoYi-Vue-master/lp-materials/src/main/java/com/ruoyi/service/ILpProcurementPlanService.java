package com.ruoyi.service;

import java.util.List;

import com.ruoyi.Vo.ProcurementPlanVo;
import com.ruoyi.domain.LpProcurementPlan;

/**
 * 采购计划Service接口
 *
 * @author zjj
 * @date 2023-05-10
 */
public interface ILpProcurementPlanService
{
    /**
     * 查询采购计划
     *
     * @param procurementPlanId 采购计划主键
     * @return 采购计划
     */
    public LpProcurementPlan selectLpProcurementPlanByProcurementPlanId(Long procurementPlanId);

    /**
     * 查询采购计划列表
     *
     * @param lpProcurementPlan 采购计划
     * @return 采购计划集合
     */
    public List<LpProcurementPlan> selectLpProcurementPlanList(LpProcurementPlan lpProcurementPlan);

    /**
     * 新增采购计划
     *
     * @param lpProcurementPlan 采购计划
     * @return 结果
     */
    public int insertLpProcurementPlan(LpProcurementPlan lpProcurementPlan);

    /**
     * 修改采购计划
     *
     * @param lpProcurementPlan 采购计划
     * @return 结果
     */
    public int updateLpProcurementPlan(LpProcurementPlan lpProcurementPlan);

    /**
     * 批量删除采购计划
     *
     * @param procurementPlanIds 需要删除的采购计划主键集合
     * @return 结果
     */
    public int deleteLpProcurementPlanByProcurementPlanIds(Long[] procurementPlanIds);

    /**
     * 删除采购计划信息
     *
     * @param procurementPlanId 采购计划主键
     * @return 结果
     */
    public int deleteLpProcurementPlanByProcurementPlanId(Long procurementPlanId);
    public int auditProcurementPlan(ProcurementPlanVo procurementPlanVo);

    public int approverProcurementPlan(ProcurementPlanVo procurementPlanVo);
}

package com.ruoyi.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.Vo.ProcurementPlanVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.domain.LpProcurementPlan;
import com.ruoyi.service.ILpProcurementPlanService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 采购计划Controller
 *
 * @author zjj
 * @date 2023-05-10
 */
@RestController
@RequestMapping("/plan/plan")
public class LpProcurementPlanController extends BaseController
{
    @Autowired
    private ILpProcurementPlanService lpProcurementPlanService;
    /**
     * 审核采购计划
     */
    @PreAuthorize("@ss.hasPermi('procurementPlan:procurementPlan:approver')")
    @Log(title = "采购计划", businessType = BusinessType.UPDATE)
    @PutMapping("/approver")
    public AjaxResult approverProcurementPlan(@RequestBody ProcurementPlanVo procurementPlanVo)
    {
        return toAjax(lpProcurementPlanService.approverProcurementPlan(procurementPlanVo));
    }

    /**
     * 审核采购计划
     */
    @PreAuthorize("@ss.hasPermi('procurementPlan:procurementPlan:audit')")
    @Log(title = "采购计划", businessType = BusinessType.UPDATE)
    @PutMapping("/audit")
    public AjaxResult auditProcurementPlan(@RequestBody ProcurementPlanVo procurementPlanVo)
    {
        return toAjax(lpProcurementPlanService.auditProcurementPlan(procurementPlanVo));
    }


    /**
     * 查询采购计划列表
     */
    @PreAuthorize("@ss.hasPermi('plan:plan:list')")
    @GetMapping("/list")
    public TableDataInfo list(LpProcurementPlan lpProcurementPlan)
    {
        startPage();
        List<LpProcurementPlan> list = lpProcurementPlanService.selectLpProcurementPlanList(lpProcurementPlan);
        return getDataTable(list);
    }

    /**
     * 导出采购计划列表
     */
    @PreAuthorize("@ss.hasPermi('plan:plan:export')")
    @Log(title = "采购计划", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LpProcurementPlan lpProcurementPlan)
    {
        List<LpProcurementPlan> list = lpProcurementPlanService.selectLpProcurementPlanList(lpProcurementPlan);
        ExcelUtil<LpProcurementPlan> util = new ExcelUtil<LpProcurementPlan>(LpProcurementPlan.class);
        util.exportExcel(response, list, "采购计划数据");
    }

    /**
     * 获取采购计划详细信息
     */
    @PreAuthorize("@ss.hasPermi('plan:plan:query')")
    @GetMapping(value = "/{procurementPlanId}")
    public AjaxResult getInfo(@PathVariable("procurementPlanId") Long procurementPlanId)
    {
        return success(lpProcurementPlanService.selectLpProcurementPlanByProcurementPlanId(procurementPlanId));
    }

    /**
     * 新增采购计划
     */
    @PreAuthorize("@ss.hasPermi('plan:plan:add')")
    @Log(title = "采购计划", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LpProcurementPlan lpProcurementPlan)
    {
        return toAjax(lpProcurementPlanService.insertLpProcurementPlan(lpProcurementPlan));
    }

    /**
     * 修改采购计划
     */
    @PreAuthorize("@ss.hasPermi('plan:plan:edit')")
    @Log(title = "采购计划", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LpProcurementPlan lpProcurementPlan)
    {
        return toAjax(lpProcurementPlanService.updateLpProcurementPlan(lpProcurementPlan));
    }

    /**
     * 删除采购计划
     */
    @PreAuthorize("@ss.hasPermi('plan:plan:remove')")
    @Log(title = "采购计划", businessType = BusinessType.DELETE)
	@DeleteMapping("/{procurementPlanIds}")
    public AjaxResult remove(@PathVariable Long[] procurementPlanIds)
    {
        return toAjax(lpProcurementPlanService.deleteLpProcurementPlanByProcurementPlanIds(procurementPlanIds));
    }
}

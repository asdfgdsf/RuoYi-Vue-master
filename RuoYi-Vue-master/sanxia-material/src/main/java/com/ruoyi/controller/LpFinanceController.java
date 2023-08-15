package com.ruoyi.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.Vo.FinanceVo;
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
import com.ruoyi.domain.LpFinance;
import com.ruoyi.service.ILpFinanceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 财务数据Controller
 *
 * @author zjj
 * @date 2023-05-09
 */
@RestController
@RequestMapping("/finance/finance")
public class LpFinanceController extends BaseController
{
    @Autowired
    private ILpFinanceService lpFinanceService;
    /**
     * 审核财务数据
     */
    @PreAuthorize("@ss.hasPermi('finance:finance:approver')")
    @Log(title = "财务数据", businessType = BusinessType.UPDATE)
    @PutMapping("/approver")
    public AjaxResult approverFinance(@RequestBody FinanceVo financeVo)
    {
        return toAjax(lpFinanceService.approverFinance(financeVo));
    }

    /**
     * 审核财务数据
     */
    @PreAuthorize("@ss.hasPermi('finance:finance:audit')")
    @Log(title = "财务数据", businessType = BusinessType.UPDATE)
    @PutMapping("/audit")
    public AjaxResult auditFinance(@RequestBody FinanceVo financeVo)
    {
        return toAjax(lpFinanceService.auditFinance(financeVo));
    }


    /**
     * 查询财务数据列表
     */
    @PreAuthorize("@ss.hasPermi('finance:finance:list')")
    @GetMapping("/list")
    public TableDataInfo list(LpFinance lpFinance)
    {
        startPage();
        List<LpFinance> list = lpFinanceService.selectLpFinanceList(lpFinance);
        return getDataTable(list);
    }

    /**
     * 导出财务数据列表
     */
    @PreAuthorize("@ss.hasPermi('finance:finance:export')")
    @Log(title = "财务数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LpFinance lpFinance)
    {
        List<LpFinance> list = lpFinanceService.selectLpFinanceList(lpFinance);
        ExcelUtil<LpFinance> util = new ExcelUtil<LpFinance>(LpFinance.class);
        util.exportExcel(response, list, "财务数据数据");
    }

    /**
     * 获取财务数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('finance:finance:query')")
    @GetMapping(value = "/{financeId}")
    public AjaxResult getInfo(@PathVariable("financeId") Long financeId)
    {
        return success(lpFinanceService.selectLpFinanceByFinanceId(financeId));
    }

    /**
     * 新增财务数据
     */
    @PreAuthorize("@ss.hasPermi('finance:finance:add')")
    @Log(title = "财务数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LpFinance lpFinance)
    {
        return toAjax(lpFinanceService.insertLpFinance(lpFinance));
    }

    /**
     * 修改财务数据
     */
    @PreAuthorize("@ss.hasPermi('finance:finance:edit')")
    @Log(title = "财务数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LpFinance lpFinance)
    {
        return toAjax(lpFinanceService.updateLpFinance(lpFinance));
    }

    /**
     * 删除财务数据
     */
    @PreAuthorize("@ss.hasPermi('finance:finance:remove')")
    @Log(title = "财务数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{financeIds}")
    public AjaxResult remove(@PathVariable Long[] financeIds)
    {
        return toAjax(lpFinanceService.deleteLpFinanceByFinanceIds(financeIds));
    }
}

package com.ruoyi.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.Vo.SupplierVo;
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
import com.ruoyi.domain.LpSupplier;
import com.ruoyi.service.ILpSupplierService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 供应商Controller
 *
 * @author zjj
 * @date 2023-05-06
 */
@RestController
@RequestMapping("/supplier/supplier")
public class LpSupplierController extends BaseController
{
    @Autowired
    private ILpSupplierService lpSupplierService;
    //供应商审批
    @PreAuthorize("@ss.hasPermi('supplier:supplier:approver')")
    @Log(title = "供应商", businessType = BusinessType.UPDATE)
    @PutMapping("/approver")
    public AjaxResult approver(@RequestBody SupplierVo suppliervo)
    {
        return toAjax(lpSupplierService.approverSupplier(suppliervo));
    }
    //供应商审核
    @PreAuthorize("@ss.hasPermi('supplier:supplier:audit')")
    @Log(title = "供应商", businessType = BusinessType.UPDATE)
    @PutMapping("/audit")
    public AjaxResult audit(@RequestBody SupplierVo suppliervo)
    {
        return toAjax(lpSupplierService.auditSupplier(suppliervo));
    }


    /**
     * 查询供应商列表
     */
    @PreAuthorize("@ss.hasPermi('supplier:supplier:list')")
    @GetMapping("/list")
    public TableDataInfo list(LpSupplier lpSupplier)
    {
        startPage();
        List<LpSupplier> list = lpSupplierService.selectLpSupplierList(lpSupplier);
        return getDataTable(list);
    }

    /**
     * 导出供应商列表
     */
    @PreAuthorize("@ss.hasPermi('supplier:supplier:export')")
    @Log(title = "供应商", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LpSupplier lpSupplier)
    {
        List<LpSupplier> list = lpSupplierService.selectLpSupplierList(lpSupplier);
        ExcelUtil<LpSupplier> util = new ExcelUtil<LpSupplier>(LpSupplier.class);
        util.exportExcel(response, list, "供应商数据");
    }

    /**
     * 获取供应商详细信息
     */
    @PreAuthorize("@ss.hasPermi('supplier:supplier:query')")
    @GetMapping(value = "/{supplierId}")
    public AjaxResult getInfo(@PathVariable("supplierId") Long supplierId)
    {
        return success(lpSupplierService.selectLpSupplierBySupplierId(supplierId));
    }

    /**
     * 新增供应商
     */
    @PreAuthorize("@ss.hasPermi('supplier:supplier:add')")
    @Log(title = "供应商", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LpSupplier lpSupplier)
    {
        return toAjax(lpSupplierService.insertLpSupplier(lpSupplier));
    }

    /**
     * 修改供应商
     */
    @PreAuthorize("@ss.hasPermi('supplier:supplier:edit')")
    @Log(title = "供应商", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LpSupplier lpSupplier)
    {
        return toAjax(lpSupplierService.updateLpSupplier(lpSupplier));
    }

    /**
     * 删除供应商
     */
    @PreAuthorize("@ss.hasPermi('supplier:supplier:remove')")
    @Log(title = "供应商", businessType = BusinessType.DELETE)
	@DeleteMapping("/{supplierIds}")
    public AjaxResult remove(@PathVariable Long[] supplierIds)
    {
        return toAjax(lpSupplierService.deleteLpSupplierBySupplierIds(supplierIds));
    }
}

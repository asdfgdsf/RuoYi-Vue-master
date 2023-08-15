package com.ruoyi.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.domain.LpClassification;
import com.ruoyi.service.ILpClassificationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备分类Controller
 * 
 * @author zjj
 * @date 2023-05-08
 */
@RestController
@RequestMapping("/system/classification")
public class LpClassificationController extends BaseController
{
    @Autowired
    private ILpClassificationService lpClassificationService;

    /**
     * 查询设备分类列表
     */
    @PreAuthorize("@ss.hasPermi('system:classification:list')")
    @GetMapping("/list")
    public TableDataInfo list(LpClassification lpClassification)
    {
        startPage();
        List<LpClassification> list = lpClassificationService.selectLpClassificationList(lpClassification);
        return getDataTable(list);
    }

    /**
     * 导出设备分类列表
     */
    @PreAuthorize("@ss.hasPermi('system:classification:export')")
    @Log(title = "设备分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LpClassification lpClassification)
    {
        List<LpClassification> list = lpClassificationService.selectLpClassificationList(lpClassification);
        ExcelUtil<LpClassification> util = new ExcelUtil<LpClassification>(LpClassification.class);
        util.exportExcel(response, list, "设备分类数据");
    }

    /**
     * 获取设备分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:classification:query')")
    @GetMapping(value = "/{classificationId}")
    public AjaxResult getInfo(@PathVariable("classificationId") Long classificationId)
    {
        return success(lpClassificationService.selectLpClassificationByClassificationId(classificationId));
    }

    /**
     * 新增设备分类
     */
    @PreAuthorize("@ss.hasPermi('system:classification:add')")
    @Log(title = "设备分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LpClassification lpClassification)
    {
        return toAjax(lpClassificationService.insertLpClassification(lpClassification));
    }

    /**
     * 修改设备分类
     */
    @PreAuthorize("@ss.hasPermi('system:classification:edit')")
    @Log(title = "设备分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LpClassification lpClassification)
    {
        return toAjax(lpClassificationService.updateLpClassification(lpClassification));
    }

    /**
     * 删除设备分类
     */
    @PreAuthorize("@ss.hasPermi('system:classification:remove')")
    @Log(title = "设备分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{classificationIds}")
    public AjaxResult remove(@PathVariable Long[] classificationIds)
    {
        return toAjax(lpClassificationService.deleteLpClassificationByClassificationIds(classificationIds));
    }
}

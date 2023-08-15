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
import com.ruoyi.domain.LpMaterials;
import com.ruoyi.service.ILpMaterialsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 原料列Controller
 * 
 * @author zjj
 * @date 2023-05-10
 */
@RestController
@RequestMapping("/materials/materials")
public class LpMaterialsController extends BaseController
{
    @Autowired
    private ILpMaterialsService lpMaterialsService;

    /**
     * 查询原料列列表
     */
    @PreAuthorize("@ss.hasPermi('materials:materials:list')")
    @GetMapping("/list")
    public TableDataInfo list(LpMaterials lpMaterials)
    {
        startPage();
        List<LpMaterials> list = lpMaterialsService.selectLpMaterialsList(lpMaterials);
        return getDataTable(list);
    }

    /**
     * 导出原料列列表
     */
    @PreAuthorize("@ss.hasPermi('materials:materials:export')")
    @Log(title = "原料列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LpMaterials lpMaterials)
    {
        List<LpMaterials> list = lpMaterialsService.selectLpMaterialsList(lpMaterials);
        ExcelUtil<LpMaterials> util = new ExcelUtil<LpMaterials>(LpMaterials.class);
        util.exportExcel(response, list, "原料列数据");
    }

    /**
     * 获取原料列详细信息
     */
    @PreAuthorize("@ss.hasPermi('materials:materials:query')")
    @GetMapping(value = "/{lpMaterialsId}")
    public AjaxResult getInfo(@PathVariable("lpMaterialsId") Long lpMaterialsId)
    {
        return success(lpMaterialsService.selectLpMaterialsByLpMaterialsId(lpMaterialsId));
    }

    /**
     * 新增原料列
     */
    @PreAuthorize("@ss.hasPermi('materials:materials:add')")
    @Log(title = "原料列", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LpMaterials lpMaterials)
    {
        return toAjax(lpMaterialsService.insertLpMaterials(lpMaterials));
    }

    /**
     * 修改原料列
     */
    @PreAuthorize("@ss.hasPermi('materials:materials:edit')")
    @Log(title = "原料列", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LpMaterials lpMaterials)
    {
        return toAjax(lpMaterialsService.updateLpMaterials(lpMaterials));
    }

    /**
     * 删除原料列
     */
    @PreAuthorize("@ss.hasPermi('materials:materials:remove')")
    @Log(title = "原料列", businessType = BusinessType.DELETE)
	@DeleteMapping("/{lpMaterialsIds}")
    public AjaxResult remove(@PathVariable Long[] lpMaterialsIds)
    {
        return toAjax(lpMaterialsService.deleteLpMaterialsByLpMaterialsIds(lpMaterialsIds));
    }
}

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
import com.ruoyi.domain.LpMaterialsClassify;
import com.ruoyi.service.ILpMaterialsClassifyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 原材料分类Controller
 * 
 * @author zjj
 * @date 2023-05-10
 */
@RestController
@RequestMapping("/mclassify/mclassify")
public class LpMaterialsClassifyController extends BaseController
{
    @Autowired
    private ILpMaterialsClassifyService lpMaterialsClassifyService;

    /**
     * 查询原材料分类列表
     */
    @PreAuthorize("@ss.hasPermi('mclassify:mclassify:list')")
    @GetMapping("/list")
    public TableDataInfo list(LpMaterialsClassify lpMaterialsClassify)
    {
        startPage();
        List<LpMaterialsClassify> list = lpMaterialsClassifyService.selectLpMaterialsClassifyList(lpMaterialsClassify);
        return getDataTable(list);
    }

    /**
     * 导出原材料分类列表
     */
    @PreAuthorize("@ss.hasPermi('mclassify:mclassify:export')")
    @Log(title = "原材料分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LpMaterialsClassify lpMaterialsClassify)
    {
        List<LpMaterialsClassify> list = lpMaterialsClassifyService.selectLpMaterialsClassifyList(lpMaterialsClassify);
        ExcelUtil<LpMaterialsClassify> util = new ExcelUtil<LpMaterialsClassify>(LpMaterialsClassify.class);
        util.exportExcel(response, list, "原材料分类数据");
    }

    /**
     * 获取原材料分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('mclassify:mclassify:query')")
    @GetMapping(value = "/{materialsClassifyId}")
    public AjaxResult getInfo(@PathVariable("materialsClassifyId") Long materialsClassifyId)
    {
        return success(lpMaterialsClassifyService.selectLpMaterialsClassifyByMaterialsClassifyId(materialsClassifyId));
    }

    /**
     * 新增原材料分类
     */
    @PreAuthorize("@ss.hasPermi('mclassify:mclassify:add')")
    @Log(title = "原材料分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LpMaterialsClassify lpMaterialsClassify)
    {
        return toAjax(lpMaterialsClassifyService.insertLpMaterialsClassify(lpMaterialsClassify));
    }

    /**
     * 修改原材料分类
     */
    @PreAuthorize("@ss.hasPermi('mclassify:mclassify:edit')")
    @Log(title = "原材料分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LpMaterialsClassify lpMaterialsClassify)
    {
        return toAjax(lpMaterialsClassifyService.updateLpMaterialsClassify(lpMaterialsClassify));
    }

    /**
     * 删除原材料分类
     */
    @PreAuthorize("@ss.hasPermi('mclassify:mclassify:remove')")
    @Log(title = "原材料分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{materialsClassifyIds}")
    public AjaxResult remove(@PathVariable Long[] materialsClassifyIds)
    {
        return toAjax(lpMaterialsClassifyService.deleteLpMaterialsClassifyByMaterialsClassifyIds(materialsClassifyIds));
    }
}

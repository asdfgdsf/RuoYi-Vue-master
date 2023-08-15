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
import com.ruoyi.domain.ClassesProduct;
import com.ruoyi.service.IClassesProductService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 成品分类Controller
 * 
 * @author zjj
 * @date 2023-05-11
 */
@RestController
@RequestMapping("/product/product")
public class ClassesProductController extends BaseController
{
    @Autowired
    private IClassesProductService classesProductService;

    /**
     * 查询成品分类列表
     */
    @PreAuthorize("@ss.hasPermi('product:product:list')")
    @GetMapping("/list")
    public TableDataInfo list(ClassesProduct classesProduct)
    {
        startPage();
        List<ClassesProduct> list = classesProductService.selectClassesProductList(classesProduct);
        return getDataTable(list);
    }

    /**
     * 导出成品分类列表
     */
    @PreAuthorize("@ss.hasPermi('product:product:export')")
    @Log(title = "成品分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ClassesProduct classesProduct)
    {
        List<ClassesProduct> list = classesProductService.selectClassesProductList(classesProduct);
        ExcelUtil<ClassesProduct> util = new ExcelUtil<ClassesProduct>(ClassesProduct.class);
        util.exportExcel(response, list, "成品分类数据");
    }

    /**
     * 获取成品分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('product:product:query')")
    @GetMapping(value = "/{classesProductId}")
    public AjaxResult getInfo(@PathVariable("classesProductId") Long classesProductId)
    {
        return success(classesProductService.selectClassesProductByClassesProductId(classesProductId));
    }

    /**
     * 新增成品分类
     */
    @PreAuthorize("@ss.hasPermi('product:product:add')")
    @Log(title = "成品分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ClassesProduct classesProduct)
    {
        return toAjax(classesProductService.insertClassesProduct(classesProduct));
    }

    /**
     * 修改成品分类
     */
    @PreAuthorize("@ss.hasPermi('product:product:edit')")
    @Log(title = "成品分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ClassesProduct classesProduct)
    {
        return toAjax(classesProductService.updateClassesProduct(classesProduct));
    }

    /**
     * 删除成品分类
     */
    @PreAuthorize("@ss.hasPermi('product:product:remove')")
    @Log(title = "成品分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{classesProductIds}")
    public AjaxResult remove(@PathVariable Long[] classesProductIds)
    {
        return toAjax(classesProductService.deleteClassesProductByClassesProductIds(classesProductIds));
    }
}

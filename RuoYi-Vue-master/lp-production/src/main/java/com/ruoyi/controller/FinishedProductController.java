package com.ruoyi.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.Vo.FinishedProductVo;
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
import com.ruoyi.domain.FinishedProduct;
import com.ruoyi.service.IFinishedProductService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 成品列表Controller
 *
 * @author jia
 * @date 2023-05-12
 */
@RestController
@RequestMapping("/finishedproduct/finishedproduct")
public class FinishedProductController extends BaseController
{
    @Autowired
    private IFinishedProductService finishedProductService;
    /**
     * 修改成品列表
     */
    @PreAuthorize("@ss.hasPermi('finishedproduct:finishedproduct:operation')")
    @Log(title = "成品列表", businessType = BusinessType.INSERT)
    @PostMapping("/operation")
    public AjaxResult operationFinishedProduct(@RequestBody FinishedProductVo finishedProductVo)
    {
        return toAjax(finishedProductService.operationFinishedProduct(finishedProductVo));
    }

    /**
     * 查询成品列表列表
     */
    @PreAuthorize("@ss.hasPermi('finishedproduct:finishedproduct:list')")
    @GetMapping("/list")
    public TableDataInfo list(FinishedProduct finishedProduct)
    {
        startPage();
        List<FinishedProduct> list = finishedProductService.selectFinishedProductList(finishedProduct);
        return getDataTable(list);
    }

    /**
     * 导出成品列表列表
     */
    @PreAuthorize("@ss.hasPermi('finishedproduct:finishedproduct:export')")
    @Log(title = "成品列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FinishedProduct finishedProduct)
    {
        List<FinishedProduct> list = finishedProductService.selectFinishedProductList(finishedProduct);
        ExcelUtil<FinishedProduct> util = new ExcelUtil<FinishedProduct>(FinishedProduct.class);
        util.exportExcel(response, list, "成品列表数据");
    }

    /**
     * 获取成品列表详细信息
     */
    @PreAuthorize("@ss.hasPermi('finishedproduct:finishedproduct:query')")
    @GetMapping(value = "/{finishedProductId}")
    public AjaxResult getInfo(@PathVariable("finishedProductId") Integer finishedProductId)
    {
        return success(finishedProductService.selectFinishedProductByFinishedProductId(finishedProductId));
    }

    /**
     * 新增成品列表
     */
    @PreAuthorize("@ss.hasPermi('finishedproduct:finishedproduct:add')")
    @Log(title = "成品列表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FinishedProduct finishedProduct)
    {
        return toAjax(finishedProductService.insertFinishedProduct(finishedProduct));
    }

    /**
     * 修改成品列表
     */
    @PreAuthorize("@ss.hasPermi('finishedproduct:finishedproduct:edit')")
    @Log(title = "成品列表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FinishedProduct finishedProduct)
    {
        return toAjax(finishedProductService.updateFinishedProduct(finishedProduct));
    }

    /**
     * 删除成品列表
     */
    @PreAuthorize("@ss.hasPermi('finishedproduct:finishedproduct:remove')")
    @Log(title = "成品列表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{finishedProductIds}")
    public AjaxResult remove(@PathVariable Integer[] finishedProductIds)
    {
        return toAjax(finishedProductService.deleteFinishedProductByFinishedProductIds(finishedProductIds));
    }
}

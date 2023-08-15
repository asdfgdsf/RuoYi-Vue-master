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
import com.ruoyi.domain.Product;
import com.ruoyi.service.IProductService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 成品库存Controller
 *
 * @author zjj
 * @date 2023-05-12
 */
@RestController
@RequestMapping("/productp/productp")
public class ProductController extends BaseController
{
    @Autowired
    private IProductService productService;

    /**
     * 查询成品库存列表
     */
    @PreAuthorize("@ss.hasPermi('product:product:list')")
    @GetMapping(value ="/list")
    public TableDataInfo list(Product product)
    {
        startPage();
        List<Product> list = productService.selectProductList(product);
        return getDataTable(list);
    }

    /**
     * 导出成品库存列表
     */
    @PreAuthorize("@ss.hasPermi('product:product:export')")
    @Log(title = "成品库存", businessType = BusinessType.EXPORT)
    @PostMapping(value ="/export")
    public void export(HttpServletResponse response, Product product)
    {
        List<Product> list = productService.selectProductList(product);
        ExcelUtil<Product> util = new ExcelUtil<Product>(Product.class);
        util.exportExcel(response, list, "成品库存数据");
    }

    /**
     * 获取成品库存详细信息
     */
    @PreAuthorize("@ss.hasPermi('product:product:query')")
    @GetMapping(value = "/{productId}")
    public AjaxResult getInfo(@PathVariable("productId") Integer productId)
    {
        return success(productService.selectProductByProductId(productId));
    }

    /**
     * 新增成品库存
     */
    @PreAuthorize("@ss.hasPermi('product:product:add')")
    @Log(title = "成品库存", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Product product)
    {
        return toAjax(productService.insertProduct(product));
    }

    /**
     * 修改成品库存
     */
    @PreAuthorize("@ss.hasPermi('product:product:edit')")
    @Log(title = "成品库存", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Product product)
    {
        return toAjax(productService.updateProduct(product));
    }

    /**
     * 删除成品库存
     */
    @PreAuthorize("@ss.hasPermi('product:product:remove')")
    @Log(title = "成品库存", businessType = BusinessType.DELETE)
	@DeleteMapping(value ="/{productIds}")
    public AjaxResult remove(@PathVariable Integer[] productIds)
    {
        return toAjax(productService.deleteProductByProductIds(productIds));
    }
}

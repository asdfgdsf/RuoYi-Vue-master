package com.ruoyi.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.Vo.ProductionInventoryVo;
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
import com.ruoyi.domain.ProductionInventory;
import com.ruoyi.service.IProductionInventoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 生产耗材Controller
 *
 * @author ruoyi
 * @date 2023-05-11
 */
@RestController
@RequestMapping("/productioninventory/productioninventory")
public class ProductionInventoryController extends BaseController
{
    @Autowired
    private IProductionInventoryService productionInventoryService;

    /**
     * 查询生产耗材列表
     */
    @PreAuthorize("@ss.hasPermi('productioninventory:productioninventory:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProductionInventory productionInventory)
    {
        startPage();
        List<ProductionInventory> list = productionInventoryService.selectProductionInventoryList(productionInventory);
        return getDataTable(list);
    }

    /**
     * 导出生产耗材列表
     */
    @PreAuthorize("@ss.hasPermi('productioninventory:productioninventory:export')")
    @Log(title = "生产耗材", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductionInventory productionInventory)
    {
        List<ProductionInventory> list = productionInventoryService.selectProductionInventoryList(productionInventory);
        ExcelUtil<ProductionInventory> util = new ExcelUtil<ProductionInventory>(ProductionInventory.class);
        util.exportExcel(response, list, "生产耗材数据");
    }

    /**
     * 获取生产耗材详细信息
     */
    @PreAuthorize("@ss.hasPermi('productioninventory:productioninventory:query')")
    @GetMapping(value = "/{productionInventoryId}")
    public AjaxResult getInfo(@PathVariable("productionInventoryId") Long productionInventoryId)
    {
        return success(productionInventoryService.selectProductionInventoryByProductionInventoryId(productionInventoryId));
    }

    /**
     * 新增生产耗材
     */
    @PreAuthorize("@ss.hasPermi('productioninventory:productioninventory:add')")
    @Log(title = "生产耗材", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductionInventory productionInventory)
    {
        return toAjax(productionInventoryService.insertProductionInventory(productionInventory));
    }

    /**
     * 修改生产耗材
     */
    @PreAuthorize("@ss.hasPermi('productioninventory:productioninventory:edit')")
    @Log(title = "生产耗材", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductionInventoryVo productionInventoryVo)
    {
        return toAjax(productionInventoryService.updateProductionInventory(productionInventoryVo));
    }

    /**
     * 删除生产耗材
     */
    @PreAuthorize("@ss.hasPermi('productioninventory:productioninventory:remove')")
    @Log(title = "生产耗材", businessType = BusinessType.DELETE)
	@DeleteMapping("/{productionInventoryIds}")
    public AjaxResult remove(@PathVariable Long[] productionInventoryIds)
    {
        return toAjax(productionInventoryService.deleteProductionInventoryByProductionInventoryIds(productionInventoryIds));
    }
}

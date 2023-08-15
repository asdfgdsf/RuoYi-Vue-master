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
import com.ruoyi.domain.Inventory;
import com.ruoyi.service.IInventoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 库存列Controller
 * 
 * @author ruoyi
 * @date 2023-05-10
 */
@RestController
@RequestMapping("/inventory/inventory")
public class InventoryController extends BaseController
{
    @Autowired
    private IInventoryService inventoryService;

    /**
     * 查询库存列列表
     */
    @PreAuthorize("@ss.hasPermi('inventory:inventory:list')")
    @GetMapping("/list")
    public TableDataInfo list(Inventory inventory)
    {
        startPage();
        List<Inventory> list = inventoryService.selectInventoryList(inventory);
        return getDataTable(list);
    }

    /**
     * 导出库存列列表
     */
    @PreAuthorize("@ss.hasPermi('inventory:inventory:export')")
    @Log(title = "库存列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Inventory inventory)
    {
        List<Inventory> list = inventoryService.selectInventoryList(inventory);
        ExcelUtil<Inventory> util = new ExcelUtil<Inventory>(Inventory.class);
        util.exportExcel(response, list, "库存列数据");
    }

    /**
     * 获取库存列详细信息
     */
    @PreAuthorize("@ss.hasPermi('inventory:inventory:query')")
    @GetMapping(value = "/{inventoryId}")
    public AjaxResult getInfo(@PathVariable("inventoryId") Long inventoryId)
    {
        return success(inventoryService.selectInventoryByInventoryId(inventoryId));
    }

    /**
     * 新增库存列
     */
    @PreAuthorize("@ss.hasPermi('inventory:inventory:add')")
    @Log(title = "库存列", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Inventory inventory)
    {
        return toAjax(inventoryService.insertInventory(inventory));
    }

    /**
     * 修改库存列
     */
    @PreAuthorize("@ss.hasPermi('inventory:inventory:edit')")
    @Log(title = "库存列", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Inventory inventory)
    {
        return toAjax(inventoryService.updateInventory(inventory));
    }

    /**
     * 删除库存列
     */
    @PreAuthorize("@ss.hasPermi('inventory:inventory:remove')")
    @Log(title = "库存列", businessType = BusinessType.DELETE)
	@DeleteMapping("/{inventoryIds}")
    public AjaxResult remove(@PathVariable Long[] inventoryIds)
    {
        return toAjax(inventoryService.deleteInventoryByInventoryIds(inventoryIds));
    }
}

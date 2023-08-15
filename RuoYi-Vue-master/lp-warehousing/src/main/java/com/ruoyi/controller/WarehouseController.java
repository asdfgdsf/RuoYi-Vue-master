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
import com.ruoyi.domain.Warehouse;
import com.ruoyi.service.IWarehouseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 库房列Controller
 * 
 * @author zjj
 * @date 2023-05-10
 */
@RestController
@RequestMapping("/warehouse/warehouse")
public class WarehouseController extends BaseController
{
    @Autowired
    private IWarehouseService warehouseService;

    /**
     * 查询库房列列表
     */
    @PreAuthorize("@ss.hasPermi('warehouse:warehouse:list')")
    @GetMapping("/list")
    public TableDataInfo list(Warehouse warehouse)
    {
        startPage();
        List<Warehouse> list = warehouseService.selectWarehouseList(warehouse);
        return getDataTable(list);
    }

    /**
     * 导出库房列列表
     */
    @PreAuthorize("@ss.hasPermi('warehouse:warehouse:export')")
    @Log(title = "库房列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Warehouse warehouse)
    {
        List<Warehouse> list = warehouseService.selectWarehouseList(warehouse);
        ExcelUtil<Warehouse> util = new ExcelUtil<Warehouse>(Warehouse.class);
        util.exportExcel(response, list, "库房列数据");
    }

    /**
     * 获取库房列详细信息
     */
    @PreAuthorize("@ss.hasPermi('warehouse:warehouse:query')")
    @GetMapping(value = "/{warehouseId}")
    public AjaxResult getInfo(@PathVariable("warehouseId") Long warehouseId)
    {
        return success(warehouseService.selectWarehouseByWarehouseId(warehouseId));
    }

    /**
     * 新增库房列
     */
    @PreAuthorize("@ss.hasPermi('warehouse:warehouse:add')")
    @Log(title = "库房列", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Warehouse warehouse)
    {
        return toAjax(warehouseService.insertWarehouse(warehouse));
    }

    /**
     * 修改库房列
     */
    @PreAuthorize("@ss.hasPermi('warehouse:warehouse:edit')")
    @Log(title = "库房列", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Warehouse warehouse)
    {
        return toAjax(warehouseService.updateWarehouse(warehouse));
    }

    /**
     * 删除库房列
     */
    @PreAuthorize("@ss.hasPermi('warehouse:warehouse:remove')")
    @Log(title = "库房列", businessType = BusinessType.DELETE)
	@DeleteMapping("/{warehouseIds}")
    public AjaxResult remove(@PathVariable Long[] warehouseIds)
    {
        return toAjax(warehouseService.deleteWarehouseByWarehouseIds(warehouseIds));
    }
}

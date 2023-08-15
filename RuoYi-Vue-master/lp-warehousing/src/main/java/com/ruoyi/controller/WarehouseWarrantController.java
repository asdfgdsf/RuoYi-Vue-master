package com.ruoyi.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.Vo.WarehouseWarrantVo;
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
import com.ruoyi.domain.WarehouseWarrant;
import com.ruoyi.service.IWarehouseWarrantService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 入库列Controller
 *
 * @author zjj
 * @date 2023-05-10
 */
@RestController
@RequestMapping("/warrant/warrant")
public class WarehouseWarrantController extends BaseController
{
    @Autowired
    private IWarehouseWarrantService warehouseWarrantService;
    /**
     * 审批入库列表
     */
    @PreAuthorize("@ss.hasPermi('warehouseWarrant:warehouseWarrant:approver')")
    @Log(title = "入库列表", businessType = BusinessType.UPDATE)
    @PutMapping("/approver")
    public AjaxResult approverWarehouseWarrant(@RequestBody WarehouseWarrantVo warehouseWarrantVo)
    {
        return toAjax(warehouseWarrantService.approverWarehouseWarrant(warehouseWarrantVo));
    }

    /**
     * 审核入库列表
     */
    @PreAuthorize("@ss.hasPermi('warehouseWarrant:warehouseWarrant:audit')")
    @Log(title = "入库列表", businessType = BusinessType.UPDATE)
    @PutMapping("/audit")
    public AjaxResult auditWarehouseWarrant(@RequestBody WarehouseWarrantVo warehouseWarrantVo)
    {
        return toAjax(warehouseWarrantService.auditWarehouseWarrant(warehouseWarrantVo));
    }


    /**
     * 选择入库列表
     */
    @PreAuthorize("@ss.hasPermi('warehouseWarrant:warehouseWarrant:warehouse')")
    @Log(title = "入库列表", businessType = BusinessType.UPDATE)
    @PutMapping("/warehouse")
    public AjaxResult warehouse(@RequestBody WarehouseWarrant warehouseWarrant)
    {
        return toAjax(warehouseWarrantService.updateWarehouseWarrant(warehouseWarrant));
    }

    /**
     * 查询入库列列表
     */
    @PreAuthorize("@ss.hasPermi('warrant:warrant:list')")
    @GetMapping("/list")
    public TableDataInfo list(WarehouseWarrant warehouseWarrant)
    {
        startPage();
        List<WarehouseWarrant> list = warehouseWarrantService.selectWarehouseWarrantList(warehouseWarrant);
        return getDataTable(list);
    }

    /**
     * 导出入库列列表
     */
    @PreAuthorize("@ss.hasPermi('warrant:warrant:export')")
    @Log(title = "入库列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WarehouseWarrant warehouseWarrant)
    {
        List<WarehouseWarrant> list = warehouseWarrantService.selectWarehouseWarrantList(warehouseWarrant);
        ExcelUtil<WarehouseWarrant> util = new ExcelUtil<WarehouseWarrant>(WarehouseWarrant.class);
        util.exportExcel(response, list, "入库列数据");
    }

    /**
     * 获取入库列详细信息
     */
    @PreAuthorize("@ss.hasPermi('warrant:warrant:query')")
    @GetMapping(value = "/{warehouseWarrantId}")
    public AjaxResult getInfo(@PathVariable("warehouseWarrantId") Long warehouseWarrantId)
    {
        return success(warehouseWarrantService.selectWarehouseWarrantByWarehouseWarrantId(warehouseWarrantId));
    }

    /**
     * 新增入库列
     */
    @PreAuthorize("@ss.hasPermi('warrant:warrant:add')")
    @Log(title = "入库列", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WarehouseWarrant warehouseWarrant)
    {
        return toAjax(warehouseWarrantService.insertWarehouseWarrant(warehouseWarrant));
    }

    /**
     * 修改入库列
     */
    @PreAuthorize("@ss.hasPermi('warrant:warrant:edit')")
    @Log(title = "入库列", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WarehouseWarrant warehouseWarrant)
    {
        return toAjax(warehouseWarrantService.updateWarehouseWarrant(warehouseWarrant));
    }

    /**
     * 删除入库列
     */
    @PreAuthorize("@ss.hasPermi('warrant:warrant:remove')")
    @Log(title = "入库列", businessType = BusinessType.DELETE)
	@DeleteMapping("/{warehouseWarrantIds}")
    public AjaxResult remove(@PathVariable Long[] warehouseWarrantIds)
    {
        return toAjax(warehouseWarrantService.deleteWarehouseWarrantByWarehouseWarrantIds(warehouseWarrantIds));
    }
}

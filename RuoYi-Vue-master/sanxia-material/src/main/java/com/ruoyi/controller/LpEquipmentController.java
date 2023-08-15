package com.ruoyi.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.Vo.EquipmentVo;
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
import com.ruoyi.domain.LpEquipment;
import com.ruoyi.service.ILpEquipmentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备列Controller
 *
 * @author zjj
 * @date 2023-05-08
 */
@RestController
@RequestMapping("/equipment/equipment")
public class LpEquipmentController extends BaseController
{
    @Autowired
    private ILpEquipmentService lpEquipmentService;
    /**
     * 审批设备
     */
    @PreAuthorize("@ss.hasPermi('equipment:equipment:approver')")
    @Log(title = "设备列表", businessType = BusinessType.UPDATE)
    @PutMapping("/approver")
    public AjaxResult approverEquipment(@RequestBody EquipmentVo equipmentVo)
    {
        return toAjax(lpEquipmentService.approverEquipment(equipmentVo));
    }


    /**
     * 审核设备
     */
    @PreAuthorize("@ss.hasPermi('equipment:equipment:audit')")
    @Log(title = "设备列表", businessType = BusinessType.UPDATE)
    @PutMapping("/audit")
    public AjaxResult auditEquipment(@RequestBody EquipmentVo equipmentVo)
    {
        return toAjax(lpEquipmentService.auditEquipment(equipmentVo));
    }


    /**
     * 查询设备列列表
     */
    @PreAuthorize("@ss.hasPermi('equipment:equipment:list')")
    @GetMapping("/list")
    public TableDataInfo list(LpEquipment lpEquipment)
    {
        startPage();
        List<LpEquipment> list = lpEquipmentService.selectLpEquipmentList(lpEquipment);
        return getDataTable(list);
    }

    /**
     * 导出设备列列表
     */
    @PreAuthorize("@ss.hasPermi('equipment:equipment:export')")
    @Log(title = "设备列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LpEquipment lpEquipment)
    {
        List<LpEquipment> list = lpEquipmentService.selectLpEquipmentList(lpEquipment);
        ExcelUtil<LpEquipment> util = new ExcelUtil<LpEquipment>(LpEquipment.class);
        util.exportExcel(response, list, "设备列数据");
    }

    /**
     * 获取设备列详细信息
     */
    @PreAuthorize("@ss.hasPermi('equipment:equipment:query')")
    @GetMapping(value = "/{equipmentId}")
    public AjaxResult getInfo(@PathVariable("equipmentId") Long equipmentId)
    {
        return success(lpEquipmentService.selectLpEquipmentByEquipmentId(equipmentId));
    }

    /**
     * 新增设备列
     */
    @PreAuthorize("@ss.hasPermi('equipment:equipment:add')")
    @Log(title = "设备列", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LpEquipment lpEquipment)
    {
        return toAjax(lpEquipmentService.insertLpEquipment(lpEquipment));
    }

    /**
     * 修改设备列
     */
    @PreAuthorize("@ss.hasPermi('equipment:equipment:edit')")
    @Log(title = "设备列", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LpEquipment lpEquipment)
    {
        return toAjax(lpEquipmentService.updateLpEquipment(lpEquipment));
    }

    /**
     * 删除设备列
     */
    @PreAuthorize("@ss.hasPermi('equipment:equipment:remove')")
    @Log(title = "设备列", businessType = BusinessType.DELETE)
	@DeleteMapping("/{equipmentIds}")
    public AjaxResult remove(@PathVariable Long[] equipmentIds)
    {
        return toAjax(lpEquipmentService.deleteLpEquipmentByEquipmentIds(equipmentIds));
    }
    /**
     *设备保养
     */

    @PreAuthorize("@ss.hasPermi('equipment:equipment:maintain')")
    @Log(title = "设备列表", businessType = BusinessType.UPDATE)
    @PutMapping("/maintain")
    public AjaxResult maintainEquipment(@RequestBody LpEquipment equipment)
    {
        return toAjax(lpEquipmentService.maintainEquipment(equipment));
    }
}

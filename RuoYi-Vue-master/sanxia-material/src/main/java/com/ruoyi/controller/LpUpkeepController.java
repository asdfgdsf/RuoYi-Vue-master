package com.ruoyi.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.Vo.UpkeepVo;
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
import com.ruoyi.domain.LpUpkeep;
import com.ruoyi.service.ILpUpkeepService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备保养Controller
 *
 * @author zjj
 * @date 2023-05-09
 */
@RestController
@RequestMapping("/upkeep/upkeep")
public class LpUpkeepController extends BaseController
{
    @Autowired
    private ILpUpkeepService lpUpkeepService;
    /**
     * 获取设备保养详细信息
     */
    @PreAuthorize("@ss.hasPermi('upkeep:upkeep:upkeepList')")
    @GetMapping(value = "/upkeepList/{upkeepId}")
    public AjaxResult upkeepList(@PathVariable("upkeepId") Integer upkeepId)
    {
        return AjaxResult.success(lpUpkeepService.selectUpkeepLists(Long.valueOf(upkeepId)));
    }
    /**
     * 审核设备附件列表
     */
    @PreAuthorize("@ss.hasPermi('upkeep:upkeep:approver')")
    @Log(title = "设备附件列表", businessType = BusinessType.UPDATE)
    @PutMapping("/approver")
    public AjaxResult approverUpkeep(@RequestBody UpkeepVo upkeepVo)
    {

        return toAjax(lpUpkeepService.approverAdjunct(upkeepVo));
    }

    /**
     * 审核设备保养
     */
    @PreAuthorize("@ss.hasPermi('upkeep:upkeep:audit')")
    @Log(title = "设备保养", businessType = BusinessType.UPDATE)
    @PutMapping("/audit")
    public AjaxResult auditUpkeep(@RequestBody UpkeepVo upkeepVo)
    {
        return toAjax(lpUpkeepService.auditUpkeep(upkeepVo));
    }


    /**
     * 查询设备保养列表
     */
    @PreAuthorize("@ss.hasPermi('upkeep:upkeep:list')")
    @GetMapping("/list")
    public TableDataInfo list(LpUpkeep lpUpkeep)
    {
        startPage();
        List<LpUpkeep> list = lpUpkeepService.selectLpUpkeepList(lpUpkeep);
        return getDataTable(list);
    }

    /**
     * 导出设备保养列表
     */
    @PreAuthorize("@ss.hasPermi('upkeep:upkeep:export')")
    @Log(title = "设备保养", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LpUpkeep lpUpkeep)
    {
        List<LpUpkeep> list = lpUpkeepService.selectLpUpkeepList(lpUpkeep);
        ExcelUtil<LpUpkeep> util = new ExcelUtil<LpUpkeep>(LpUpkeep.class);
        util.exportExcel(response, list, "设备保养数据");
    }

    /**
     * 获取设备保养详细信息
     */
    @PreAuthorize("@ss.hasPermi('upkeep:upkeep:query')")
    @GetMapping(value = "/{upkeepId}")
    public AjaxResult getInfo(@PathVariable("upkeepId") Long upkeepId)
    {
        return success(lpUpkeepService.selectLpUpkeepByUpkeepId(upkeepId));
    }

    /**
     * 新增设备保养
     */
    @PreAuthorize("@ss.hasPermi('upkeep:upkeep:add')")
    @Log(title = "设备保养", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LpUpkeep lpUpkeep)
    {
        return toAjax(lpUpkeepService.insertLpUpkeep(lpUpkeep));
    }

    /**
     * 修改设备保养
     */
    @PreAuthorize("@ss.hasPermi('upkeep:upkeep:edit')")
    @Log(title = "设备保养", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LpUpkeep lpUpkeep)
    {
        return toAjax(lpUpkeepService.updateLpUpkeep(lpUpkeep));
    }

    /**
     * 删除设备保养
     */
    @PreAuthorize("@ss.hasPermi('upkeep:upkeep:remove')")
    @Log(title = "设备保养", businessType = BusinessType.DELETE)
	@DeleteMapping("/{upkeepIds}")
    public AjaxResult remove(@PathVariable Long[] upkeepIds)
    {
        return toAjax(lpUpkeepService.deleteLpUpkeepByUpkeepIds(upkeepIds));
    }
}

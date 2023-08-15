package com.ruoyi.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.Vo.AdjunctVo;
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
import com.ruoyi.domain.LpAdjunct;
import com.ruoyi.service.ILpAdjunctService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备附件Controller
 *
 * @author zjj
 * @date 2023-05-09
 */
@RestController
@RequestMapping("/adjunct/adjunct")
public class LpAdjunctController extends BaseController
{
    @Autowired
    private ILpAdjunctService lpAdjunctService;
    /**
     * 审核设备附件列表
     */
    @PreAuthorize("@ss.hasPermi('adjunct:adjunct:approver')")
    @Log(title = "设备附件列表", businessType = BusinessType.UPDATE)
    @PutMapping("/approver")
    public AjaxResult approverAdjunct(@RequestBody AdjunctVo adjunctVo)
    {

        return toAjax(lpAdjunctService.approverAdjunct(adjunctVo));
    }


    /**
     * 审核设备附件列表
     */
    @PreAuthorize("@ss.hasPermi('adjunct:adjunct:audit')")
    @Log(title = "设备附件列表", businessType = BusinessType.UPDATE)
    @PutMapping("/audit")
    public AjaxResult auditAdjunct(@RequestBody AdjunctVo adjunctVo)
    {

        return toAjax(lpAdjunctService.auditAdjunct(adjunctVo));
    }



    /**
     * 查询设备附件列表
     */
    @PreAuthorize("@ss.hasPermi('adjunct:adjunct:list')")
    @GetMapping("/list")
    public TableDataInfo list(LpAdjunct lpAdjunct)
    {
        startPage();
        List<LpAdjunct> list = lpAdjunctService.selectAdjunctList(lpAdjunct);
        return getDataTable(list);
    }

    /**
     * 导出设备附件列表
     */
    @PreAuthorize("@ss.hasPermi('adjunct:adjunct:export')")
    @Log(title = "设备附件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LpAdjunct lpAdjunct)
    {
        List<LpAdjunct> list = lpAdjunctService.selectAdjunctList(lpAdjunct);
        ExcelUtil<LpAdjunct> util = new ExcelUtil<LpAdjunct>(LpAdjunct.class);
        util.exportExcel(response, list, "设备附件数据");
    }

    /**
     * 获取设备附件详细信息
     */
    @PreAuthorize("@ss.hasPermi('adjunct:adjunct:query')")
    @GetMapping(value = "/{adjunctId}")
    public AjaxResult getInfo(@PathVariable("adjunctId") Long adjunctId)
    {
        return success(lpAdjunctService.selectAdjunctByAdjunctId(adjunctId));
    }

    /**
     * 新增设备附件
     */
    @PreAuthorize("@ss.hasPermi('adjunct:adjunct:add')")
    @Log(title = "设备附件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LpAdjunct lpAdjunct)
    {
        return toAjax(lpAdjunctService.insertAdjunct(lpAdjunct));
    }

    /**
     * 修改设备附件
     */
    @PreAuthorize("@ss.hasPermi('adjunct:adjunct:edit')")
    @Log(title = "设备附件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LpAdjunct lpAdjunct)
    {
        return toAjax(lpAdjunctService.updateAdjunct(lpAdjunct));
    }

    /**
     * 删除设备附件
     */
    @PreAuthorize("@ss.hasPermi('adjunct:adjunct:remove')")
    @Log(title = "设备附件", businessType = BusinessType.DELETE)
	@DeleteMapping("/{adjunctIds}")
    public AjaxResult remove(@PathVariable Long[] adjunctIds)
    {
        return toAjax(lpAdjunctService.deleteAdjunctByAdjunctIds(adjunctIds));
    }
}

package com.ruoyi.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.domain.LpClassify;
import com.ruoyi.service.ILpClassifyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 供应商分类Controller
 *
 * @author zjj
 * @date 2023-05-04
 */
@CrossOrigin
@RestController
@RequestMapping("/system/classify")
public class LpClassifyController extends BaseController
{
    @Autowired
    private ILpClassifyService lpClassifyService;

    /**
     * 查询供应商分类列表
     */
    @PreAuthorize("@ss.hasPermi('system:classify:list')")
    @GetMapping("/list")
    public TableDataInfo list(LpClassify lpClassify)
    {
        startPage();
        List<LpClassify> list = lpClassifyService.selectLpClassifyList(lpClassify);
        return getDataTable(list);
    }

    /**
     * 导出供应商分类列表
     */
    @PreAuthorize("@ss.hasPermi('system:classify:export')")
    @Log(title = "供应商分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LpClassify lpClassify)
    {
        List<LpClassify> list = lpClassifyService.selectLpClassifyList(lpClassify);
        ExcelUtil<LpClassify> util = new ExcelUtil<LpClassify>(LpClassify.class);
        util.exportExcel(response, list, "供应商分类数据");
    }

    /**
     * 获取供应商分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:classify:query')")
    @GetMapping(value = "/{classifyId}")
    public AjaxResult getInfo(@PathVariable("classifyId") Long classifyId)
    {
        return success(lpClassifyService.selectLpClassifyByClassifyId(classifyId));
    }

    /**
     * 新增供应商分类
     */
    @PreAuthorize("@ss.hasPermi('system:classify:add')")
//    对一张表的修改操作进行了日志记录。只需要加上@Log即可
//后面的参数title:可以随便写。一般是您本方法的作用
//businessType：这个后面的参数是我们之前写的枚举类。
    @Log(title = "供应商分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LpClassify lpClassify)
    {
        return toAjax(lpClassifyService.insertLpClassify(lpClassify));
    }

    /**
     * 修改供应商分类
     */
    @PreAuthorize("@ss.hasPermi('system:classify:edit')")
    @Log(title = "供应商分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LpClassify lpClassify)
    {
        return toAjax(lpClassifyService.updateLpClassify(lpClassify));
    }

    /**
     * 删除供应商分类
     */
    @PreAuthorize("@ss.hasPermi('system:classify:remove')")
    @Log(title = "供应商分类", businessType = BusinessType.DELETE)
    @DeleteMapping("/{classifyIds}")
    public AjaxResult remove(@PathVariable Long[] classifyIds)
    {
        return toAjax(lpClassifyService.deleteLpClassifyByClassifyIds(classifyIds));
    }
}

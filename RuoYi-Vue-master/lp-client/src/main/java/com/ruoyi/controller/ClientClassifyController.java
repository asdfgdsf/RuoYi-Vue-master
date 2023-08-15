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
import com.ruoyi.domain.ClientClassify;
import com.ruoyi.service.IClientClassifyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客户分类Controller
 * 
 * @author jia
 * @date 2023-05-12
 */
@RestController
@RequestMapping("/clientclassify/clientclassify")
public class ClientClassifyController extends BaseController
{
    @Autowired
    private IClientClassifyService clientClassifyService;

    /**
     * 查询客户分类列表
     */
    @PreAuthorize("@ss.hasPermi('clientclassify:clientclassify:list')")
    @GetMapping("/list")
    public TableDataInfo list(ClientClassify clientClassify)
    {
        startPage();
        List<ClientClassify> list = clientClassifyService.selectClientClassifyList(clientClassify);
        return getDataTable(list);
    }

    /**
     * 导出客户分类列表
     */
    @PreAuthorize("@ss.hasPermi('clientclassify:clientclassify:export')")
    @Log(title = "客户分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ClientClassify clientClassify)
    {
        List<ClientClassify> list = clientClassifyService.selectClientClassifyList(clientClassify);
        ExcelUtil<ClientClassify> util = new ExcelUtil<ClientClassify>(ClientClassify.class);
        util.exportExcel(response, list, "客户分类数据");
    }

    /**
     * 获取客户分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('clientclassify:clientclassify:query')")
    @GetMapping(value = "/{clientClassifyId}")
    public AjaxResult getInfo(@PathVariable("clientClassifyId") Integer clientClassifyId)
    {
        return success(clientClassifyService.selectClientClassifyByClientClassifyId(clientClassifyId));
    }

    /**
     * 新增客户分类
     */
    @PreAuthorize("@ss.hasPermi('clientclassify:clientclassify:add')")
    @Log(title = "客户分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ClientClassify clientClassify)
    {
        return toAjax(clientClassifyService.insertClientClassify(clientClassify));
    }

    /**
     * 修改客户分类
     */
    @PreAuthorize("@ss.hasPermi('clientclassify:clientclassify:edit')")
    @Log(title = "客户分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ClientClassify clientClassify)
    {
        return toAjax(clientClassifyService.updateClientClassify(clientClassify));
    }

    /**
     * 删除客户分类
     */
    @PreAuthorize("@ss.hasPermi('clientclassify:clientclassify:remove')")
    @Log(title = "客户分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{clientClassifyIds}")
    public AjaxResult remove(@PathVariable Integer[] clientClassifyIds)
    {
        return toAjax(clientClassifyService.deleteClientClassifyByClientClassifyIds(clientClassifyIds));
    }
}

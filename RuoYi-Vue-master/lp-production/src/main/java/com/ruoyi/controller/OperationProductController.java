package com.ruoyi.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.Vo.OperationProductVo;
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
import com.ruoyi.domain.OperationProduct;
import com.ruoyi.service.IOperationProductService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 成品入库Controller
 *
 * @author jia
 * @date 2023-05-12
 */
@RestController
@RequestMapping("/operationproduct/operationproduct")
public class OperationProductController extends BaseController
{
    @Autowired
    private IOperationProductService operationProductService;

    @PreAuthorize("@ss.hasPermi('operationproduct:operationproduct:approver')")
    @Log(title = "成品入库", businessType = BusinessType.UPDATE)
    @PutMapping("/approver")
    public AjaxResult approverOperationProduct(@RequestBody OperationProductVo operationProductVo)
    {
        return toAjax(operationProductService.approverOperationProduct(operationProductVo));
    }
    /**
     * 审核成品入库
     */
    @PreAuthorize("@ss.hasPermi('operationproduct:operationproduct:audit')")
    @Log(title = "成品入库", businessType = BusinessType.UPDATE)
    @PutMapping("/audit")
    public AjaxResult auditOperationProduct(@RequestBody OperationProductVo operationProductVo)
    {
        return toAjax(operationProductService.auditOperationProduct(operationProductVo));
    }
    /**
     * 选择成品入库
     */
    @PreAuthorize("@ss.hasPermi('operationproduct:operationproduct:chonse')")
    @Log(title = "成品入库", businessType = BusinessType.UPDATE)
    @PutMapping("/chonse")
    public AjaxResult chonseOperationProduct(@RequestBody OperationProductVo operationProductVo)
    {
        return toAjax(operationProductService.chonseOperationProduct(operationProductVo));
    }

    /**
     * 查询成品入库列表
     */
    @PreAuthorize("@ss.hasPermi('operationproduct:operationproduct:list')")
    @GetMapping("/list")
    public TableDataInfo list(OperationProduct operationProduct)
    {
        startPage();
        List<OperationProduct> list = operationProductService.selectOperationProductList(operationProduct);
        return getDataTable(list);
    }

    /**
     * 导出成品入库列表
     */
    @PreAuthorize("@ss.hasPermi('operationproduct:operationproduct:export')")
    @Log(title = "成品入库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OperationProduct operationProduct)
    {
        List<OperationProduct> list = operationProductService.selectOperationProductList(operationProduct);
        ExcelUtil<OperationProduct> util = new ExcelUtil<OperationProduct>(OperationProduct.class);
        util.exportExcel(response, list, "成品入库数据");
    }

    /**
     * 获取成品入库详细信息
     */
    @PreAuthorize("@ss.hasPermi('operationproduct:operationproduct:query')")
    @GetMapping(value = "/{operationProductId}")
    public AjaxResult getInfo(@PathVariable("operationProductId") Integer operationProductId)
    {
        return success(operationProductService.selectOperationProductByOperationProductId(operationProductId));
    }

    /**
     * 新增成品入库
     */
    @PreAuthorize("@ss.hasPermi('operationproduct:operationproduct:add')")
    @Log(title = "成品入库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OperationProduct operationProduct)
    {
        return toAjax(operationProductService.insertOperationProduct(operationProduct));
    }

    /**
     * 修改成品入库
     */
    @PreAuthorize("@ss.hasPermi('operationproduct:operationproduct:edit')")
    @Log(title = "成品入库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OperationProduct operationProduct)
    {
        return toAjax(operationProductService.updateOperationProduct(operationProduct));
    }

    /**
     * 删除成品入库
     */
    @PreAuthorize("@ss.hasPermi('operationproduct:operationproduct:remove')")
    @Log(title = "成品入库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{operationProductIds}")
    public AjaxResult remove(@PathVariable Integer[] operationProductIds)
    {
        return toAjax(operationProductService.deleteOperationProductByOperationProductIds(operationProductIds));
    }
}

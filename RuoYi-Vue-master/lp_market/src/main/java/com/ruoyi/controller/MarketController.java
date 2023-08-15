package com.ruoyi.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.Vo.MarketVo;
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
import com.ruoyi.domain.Market;
import com.ruoyi.service.IMarketService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * marketController
 *
 * @author jia
 * @date 2023-05-12
 */
@RestController
@RequestMapping("/market/market")
public class MarketController extends BaseController
{
    @Autowired
    private IMarketService marketService;
    /**
     * 审批market
     */
    @PreAuthorize("@ss.hasPermi('market:market:approver')")
    @Log(title = "market", businessType = BusinessType.UPDATE)
    @PutMapping("/approver")
    public AjaxResult approverMarket(@RequestBody MarketVo marketVo)
    {
        return toAjax(marketService.approverMarket(marketVo));
    }

    /**
     * 审核market
     */
    @PreAuthorize("@ss.hasPermi('market:market:audit')")
    @Log(title = "market", businessType = BusinessType.UPDATE)
    @PutMapping("/audit")
    public AjaxResult auditMarket(@RequestBody MarketVo marketVo)
    {
        return toAjax(marketService.auditMarket(marketVo));
    }

    /**
     * 查询market列表
     */
    @PreAuthorize("@ss.hasPermi('market:market:list')")
    @GetMapping("/list")
    public TableDataInfo list(Market market)
    {
        startPage();
        List<Market> list = marketService.selectMarketList(market);
        return getDataTable(list);
    }

    /**
     * 导出market列表
     */
    @PreAuthorize("@ss.hasPermi('market:market:export')")
    @Log(title = "market", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Market market)
    {
        List<Market> list = marketService.selectMarketList(market);
        ExcelUtil<Market> util = new ExcelUtil<Market>(Market.class);
        util.exportExcel(response, list, "market数据");
    }

    /**
     * 获取market详细信息
     */
    @PreAuthorize("@ss.hasPermi('market:market:query')")
    @GetMapping(value = "/{marketId}")
    public AjaxResult getInfo(@PathVariable("marketId") Integer marketId)
    {
        return success(marketService.selectMarketByMarketId(marketId));
    }

    /**
     * 新增market
     */
    @PreAuthorize("@ss.hasPermi('market:market:add')")
    @Log(title = "market", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Market market)
    {
        return toAjax(marketService.insertMarket(market));
    }

    /**
     * 修改market
     */
    @PreAuthorize("@ss.hasPermi('market:market:edit')")
    @Log(title = "market", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Market market)
    {
        return toAjax(marketService.updateMarket(market));
    }

    /**
     * 删除market
     */
    @PreAuthorize("@ss.hasPermi('market:market:remove')")
    @Log(title = "market", businessType = BusinessType.DELETE)
	@DeleteMapping("/{marketIds}")
    public AjaxResult remove(@PathVariable Integer[] marketIds)
    {
        return toAjax(marketService.deleteMarketByMarketIds(marketIds));
    }
}

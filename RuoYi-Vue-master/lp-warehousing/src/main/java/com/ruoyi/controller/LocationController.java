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
import com.ruoyi.domain.Location;
import com.ruoyi.service.ILocationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 货位列Controller
 * 
 * @author ruoyi
 * @date 2023-05-10
 */
@RestController
@RequestMapping("/location/location")
public class LocationController extends BaseController
{
    @Autowired
    private ILocationService locationService;

    /**
     * 查询货位列列表
     */
    @PreAuthorize("@ss.hasPermi('location:location:list')")
    @GetMapping("/list")
    public TableDataInfo list(Location location)
    {
        startPage();
        List<Location> list = locationService.selectLocationList(location);
        return getDataTable(list);
    }

    /**
     * 导出货位列列表
     */
    @PreAuthorize("@ss.hasPermi('location:location:export')")
    @Log(title = "货位列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Location location)
    {
        List<Location> list = locationService.selectLocationList(location);
        ExcelUtil<Location> util = new ExcelUtil<Location>(Location.class);
        util.exportExcel(response, list, "货位列数据");
    }

    /**
     * 获取货位列详细信息
     */
    @PreAuthorize("@ss.hasPermi('location:location:query')")
    @GetMapping(value = "/{locationId}")
    public AjaxResult getInfo(@PathVariable("locationId") Long locationId)
    {
        return success(locationService.selectLocationByLocationId(locationId));
    }

    /**
     * 新增货位列
     */
    @PreAuthorize("@ss.hasPermi('location:location:add')")
    @Log(title = "货位列", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Location location)
    {
        return toAjax(locationService.insertLocation(location));
    }

    /**
     * 修改货位列
     */
    @PreAuthorize("@ss.hasPermi('location:location:edit')")
    @Log(title = "货位列", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Location location)
    {
        return toAjax(locationService.updateLocation(location));
    }

    /**
     * 删除货位列
     */
    @PreAuthorize("@ss.hasPermi('location:location:remove')")
    @Log(title = "货位列", businessType = BusinessType.DELETE)
	@DeleteMapping("/{locationIds}")
    public AjaxResult remove(@PathVariable Long[] locationIds)
    {
        return toAjax(locationService.deleteLocationByLocationIds(locationIds));
    }
}

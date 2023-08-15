package com.ruoyi.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.LocationMapper;
import com.ruoyi.domain.Location;
import com.ruoyi.service.ILocationService;

/**
 * 货位列Service业务层处理
 *
 * @author ruoyi
 * @date 2023-05-10
 */
@Service
public class LocationServiceImpl implements ILocationService
{
    @Autowired(required = false)
    private LocationMapper locationMapper;

    /**
     * 查询货位列
     *
     * @param locationId 货位列主键
     * @return 货位列
     */
    @Override
    public Location selectLocationByLocationId(Long locationId)
    {
        return locationMapper.selectLocationByLocationId(locationId);
    }

    /**
     * 查询货位列列表
     *
     * @param location 货位列
     * @return 货位列
     */
    @Override
    public List<Location> selectLocationList(Location location)
    {
        return locationMapper.selectLocationList(location);
    }

    /**
     * 新增货位列
     *
     * @param location 货位列
     * @return 结果
     */
    @Override
    public int insertLocation(Location location)
    {
        location.setCreateTime(DateUtils.getNowDate());
        return locationMapper.insertLocation(location);
    }

    /**
     * 修改货位列
     *
     * @param location 货位列
     * @return 结果
     */
    @Override
    public int updateLocation(Location location)
    {
        location.setUpdateTime(DateUtils.getNowDate());
        return locationMapper.updateLocation(location);
    }

    /**
     * 批量删除货位列
     *
     * @param locationIds 需要删除的货位列主键
     * @return 结果
     */
    @Override
    public int deleteLocationByLocationIds(Long[] locationIds)
    {
        return locationMapper.deleteLocationByLocationIds(locationIds);
    }

    /**
     * 删除货位列信息
     *
     * @param locationId 货位列主键
     * @return 结果
     */
    @Override
    public int deleteLocationByLocationId(Long locationId)
    {
        return locationMapper.deleteLocationByLocationId(locationId);
    }
}

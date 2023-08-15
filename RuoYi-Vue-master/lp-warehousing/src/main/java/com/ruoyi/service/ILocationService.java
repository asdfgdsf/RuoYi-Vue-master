package com.ruoyi.service;

import java.util.List;
import com.ruoyi.domain.Location;

/**
 * 货位列Service接口
 * 
 * @author ruoyi
 * @date 2023-05-10
 */
public interface ILocationService 
{
    /**
     * 查询货位列
     * 
     * @param locationId 货位列主键
     * @return 货位列
     */
    public Location selectLocationByLocationId(Long locationId);

    /**
     * 查询货位列列表
     * 
     * @param location 货位列
     * @return 货位列集合
     */
    public List<Location> selectLocationList(Location location);

    /**
     * 新增货位列
     * 
     * @param location 货位列
     * @return 结果
     */
    public int insertLocation(Location location);

    /**
     * 修改货位列
     * 
     * @param location 货位列
     * @return 结果
     */
    public int updateLocation(Location location);

    /**
     * 批量删除货位列
     * 
     * @param locationIds 需要删除的货位列主键集合
     * @return 结果
     */
    public int deleteLocationByLocationIds(Long[] locationIds);

    /**
     * 删除货位列信息
     * 
     * @param locationId 货位列主键
     * @return 结果
     */
    public int deleteLocationByLocationId(Long locationId);
}

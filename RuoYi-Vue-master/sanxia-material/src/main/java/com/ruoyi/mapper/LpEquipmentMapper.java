package com.ruoyi.mapper;

import java.util.List;
import com.ruoyi.domain.LpEquipment;

/**
 * 设备列Mapper接口
 * 
 * @author zjj
 * @date 2023-05-08
 */
public interface LpEquipmentMapper 
{
    /**
     * 查询设备列
     * 
     * @param equipmentId 设备列主键
     * @return 设备列
     */
    public LpEquipment selectLpEquipmentByEquipmentId(Long equipmentId);

    /**
     * 查询设备列列表
     * 
     * @param lpEquipment 设备列
     * @return 设备列集合
     */
    public List<LpEquipment> selectLpEquipmentList(LpEquipment lpEquipment);

    /**
     * 新增设备列
     * 
     * @param lpEquipment 设备列
     * @return 结果
     */
    public int insertLpEquipment(LpEquipment lpEquipment);

    /**
     * 修改设备列
     * 
     * @param lpEquipment 设备列
     * @return 结果
     */
    public int updateLpEquipment(LpEquipment lpEquipment);

    /**
     * 删除设备列
     * 
     * @param equipmentId 设备列主键
     * @return 结果
     */
    public int deleteLpEquipmentByEquipmentId(Long equipmentId);

    /**
     * 批量删除设备列
     * 
     * @param equipmentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLpEquipmentByEquipmentIds(Long[] equipmentIds);
}

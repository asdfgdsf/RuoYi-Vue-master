package com.ruoyi.service;

import java.util.List;

import com.ruoyi.Vo.EquipmentVo;
import com.ruoyi.domain.LpEquipment;

/**
 * 设备列Service接口
 *
 * @author zjj
 * @date 2023-05-08
 */
public interface ILpEquipmentService
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
     * 批量删除设备列
     *
     * @param equipmentIds 需要删除的设备列主键集合
     * @return 结果
     */
    public int deleteLpEquipmentByEquipmentIds(Long[] equipmentIds);

    /**
     * 删除设备列信息
     *
     * @param equipmentId 设备列主键
     * @return 结果
     */
    public int deleteLpEquipmentByEquipmentId(Long equipmentId);
    public int maintainEquipment(LpEquipment lpEquipment);

    public int auditEquipment(EquipmentVo equipmentVo);

    public int approverEquipment(EquipmentVo equipmentVo);
}

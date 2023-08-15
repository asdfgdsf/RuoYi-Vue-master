package com.ruoyi.service;

import java.util.List;
import com.ruoyi.domain.LpMaterials;

/**
 * 原料列Service接口
 * 
 * @author zjj
 * @date 2023-05-10
 */
public interface ILpMaterialsService 
{
    /**
     * 查询原料列
     * 
     * @param lpMaterialsId 原料列主键
     * @return 原料列
     */
    public LpMaterials selectLpMaterialsByLpMaterialsId(Long lpMaterialsId);

    /**
     * 查询原料列列表
     * 
     * @param lpMaterials 原料列
     * @return 原料列集合
     */
    public List<LpMaterials> selectLpMaterialsList(LpMaterials lpMaterials);

    /**
     * 新增原料列
     * 
     * @param lpMaterials 原料列
     * @return 结果
     */
    public int insertLpMaterials(LpMaterials lpMaterials);

    /**
     * 修改原料列
     * 
     * @param lpMaterials 原料列
     * @return 结果
     */
    public int updateLpMaterials(LpMaterials lpMaterials);

    /**
     * 批量删除原料列
     * 
     * @param lpMaterialsIds 需要删除的原料列主键集合
     * @return 结果
     */
    public int deleteLpMaterialsByLpMaterialsIds(Long[] lpMaterialsIds);

    /**
     * 删除原料列信息
     * 
     * @param lpMaterialsId 原料列主键
     * @return 结果
     */
    public int deleteLpMaterialsByLpMaterialsId(Long lpMaterialsId);
}

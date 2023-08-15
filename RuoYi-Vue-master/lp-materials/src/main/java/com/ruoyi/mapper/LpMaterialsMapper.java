package com.ruoyi.mapper;

import java.util.List;
import com.ruoyi.domain.LpMaterials;

/**
 * 原料列Mapper接口
 * 
 * @author zjj
 * @date 2023-05-10
 */
public interface LpMaterialsMapper 
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
     * 删除原料列
     * 
     * @param lpMaterialsId 原料列主键
     * @return 结果
     */
    public int deleteLpMaterialsByLpMaterialsId(Long lpMaterialsId);

    /**
     * 批量删除原料列
     * 
     * @param lpMaterialsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLpMaterialsByLpMaterialsIds(Long[] lpMaterialsIds);
}

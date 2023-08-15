package com.ruoyi.mapper;

import java.util.List;
import com.ruoyi.domain.LpMaterialsClassify;

/**
 * 原材料分类Mapper接口
 * 
 * @author zjj
 * @date 2023-05-10
 */
public interface LpMaterialsClassifyMapper 
{
    /**
     * 查询原材料分类
     * 
     * @param materialsClassifyId 原材料分类主键
     * @return 原材料分类
     */
    public LpMaterialsClassify selectLpMaterialsClassifyByMaterialsClassifyId(Long materialsClassifyId);

    /**
     * 查询原材料分类列表
     * 
     * @param lpMaterialsClassify 原材料分类
     * @return 原材料分类集合
     */
    public List<LpMaterialsClassify> selectLpMaterialsClassifyList(LpMaterialsClassify lpMaterialsClassify);

    /**
     * 新增原材料分类
     * 
     * @param lpMaterialsClassify 原材料分类
     * @return 结果
     */
    public int insertLpMaterialsClassify(LpMaterialsClassify lpMaterialsClassify);

    /**
     * 修改原材料分类
     * 
     * @param lpMaterialsClassify 原材料分类
     * @return 结果
     */
    public int updateLpMaterialsClassify(LpMaterialsClassify lpMaterialsClassify);

    /**
     * 删除原材料分类
     * 
     * @param materialsClassifyId 原材料分类主键
     * @return 结果
     */
    public int deleteLpMaterialsClassifyByMaterialsClassifyId(Long materialsClassifyId);

    /**
     * 批量删除原材料分类
     * 
     * @param materialsClassifyIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLpMaterialsClassifyByMaterialsClassifyIds(Long[] materialsClassifyIds);
}

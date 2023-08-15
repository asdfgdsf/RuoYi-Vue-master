package com.ruoyi.mapper;

import java.util.List;
import com.ruoyi.domain.LpClassification;

/**
 * 设备分类Mapper接口
 * 
 * @author zjj
 * @date 2023-05-08
 */
public interface LpClassificationMapper 
{
    /**
     * 查询设备分类
     * 
     * @param classificationId 设备分类主键
     * @return 设备分类
     */
    public LpClassification selectLpClassificationByClassificationId(Long classificationId);

    /**
     * 查询设备分类列表
     * 
     * @param lpClassification 设备分类
     * @return 设备分类集合
     */
    public List<LpClassification> selectLpClassificationList(LpClassification lpClassification);

    /**
     * 新增设备分类
     * 
     * @param lpClassification 设备分类
     * @return 结果
     */
    public int insertLpClassification(LpClassification lpClassification);

    /**
     * 修改设备分类
     * 
     * @param lpClassification 设备分类
     * @return 结果
     */
    public int updateLpClassification(LpClassification lpClassification);

    /**
     * 删除设备分类
     * 
     * @param classificationId 设备分类主键
     * @return 结果
     */
    public int deleteLpClassificationByClassificationId(Long classificationId);

    /**
     * 批量删除设备分类
     * 
     * @param classificationIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLpClassificationByClassificationIds(Long[] classificationIds);
}

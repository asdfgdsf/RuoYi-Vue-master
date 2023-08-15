package com.ruoyi.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.LpClassificationMapper;
import com.ruoyi.domain.LpClassification;
import com.ruoyi.service.ILpClassificationService;

/**
 * 设备分类Service业务层处理
 *
 * @author zjj
 * @date 2023-05-08
 */
@Service
public class LpClassificationServiceImpl implements ILpClassificationService
{
    @Autowired(required = false)
    private LpClassificationMapper lpClassificationMapper;

    /**
     * 查询设备分类
     *
     * @param classificationId 设备分类主键
     * @return 设备分类
     */
    @Override
    public LpClassification selectLpClassificationByClassificationId(Long classificationId)
    {
        return lpClassificationMapper.selectLpClassificationByClassificationId(classificationId);
    }

    /**
     * 查询设备分类列表
     *
     * @param lpClassification 设备分类
     * @return 设备分类
     */
    @Override
    public List<LpClassification> selectLpClassificationList(LpClassification lpClassification)
    {
        return lpClassificationMapper.selectLpClassificationList(lpClassification);
    }

    /**
     * 新增设备分类
     *
     * @param lpClassification 设备分类
     * @return 结果
     */
    @Override
    public int insertLpClassification(LpClassification lpClassification)
    {
        lpClassification.setCreateTime(DateUtils.getNowDate());
        return lpClassificationMapper.insertLpClassification(lpClassification);
    }

    /**
     * 修改设备分类
     *
     * @param lpClassification 设备分类
     * @return 结果
     */
    @Override
    public int updateLpClassification(LpClassification lpClassification)
    {
        lpClassification.setUpdateTime(DateUtils.getNowDate());
        return lpClassificationMapper.updateLpClassification(lpClassification);
    }

    /**
     * 批量删除设备分类
     *
     * @param classificationIds 需要删除的设备分类主键
     * @return 结果
     */
    @Override
    public int deleteLpClassificationByClassificationIds(Long[] classificationIds)
    {
        return lpClassificationMapper.deleteLpClassificationByClassificationIds(classificationIds);
    }

    /**
     * 删除设备分类信息
     *
     * @param classificationId 设备分类主键
     * @return 结果
     */
    @Override
    public int deleteLpClassificationByClassificationId(Long classificationId)
    {
        return lpClassificationMapper.deleteLpClassificationByClassificationId(classificationId);
    }
}

package com.ruoyi.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.LpMaterialsClassifyMapper;
import com.ruoyi.domain.LpMaterialsClassify;
import com.ruoyi.service.ILpMaterialsClassifyService;

/**
 * 原材料分类Service业务层处理
 * 
 * @author zjj
 * @date 2023-05-10
 */
@Service
public class LpMaterialsClassifyServiceImpl implements ILpMaterialsClassifyService 
{
    @Autowired
    private LpMaterialsClassifyMapper lpMaterialsClassifyMapper;

    /**
     * 查询原材料分类
     * 
     * @param materialsClassifyId 原材料分类主键
     * @return 原材料分类
     */
    @Override
    public LpMaterialsClassify selectLpMaterialsClassifyByMaterialsClassifyId(Long materialsClassifyId)
    {
        return lpMaterialsClassifyMapper.selectLpMaterialsClassifyByMaterialsClassifyId(materialsClassifyId);
    }

    /**
     * 查询原材料分类列表
     * 
     * @param lpMaterialsClassify 原材料分类
     * @return 原材料分类
     */
    @Override
    public List<LpMaterialsClassify> selectLpMaterialsClassifyList(LpMaterialsClassify lpMaterialsClassify)
    {
        return lpMaterialsClassifyMapper.selectLpMaterialsClassifyList(lpMaterialsClassify);
    }

    /**
     * 新增原材料分类
     * 
     * @param lpMaterialsClassify 原材料分类
     * @return 结果
     */
    @Override
    public int insertLpMaterialsClassify(LpMaterialsClassify lpMaterialsClassify)
    {
        lpMaterialsClassify.setCreateTime(DateUtils.getNowDate());
        return lpMaterialsClassifyMapper.insertLpMaterialsClassify(lpMaterialsClassify);
    }

    /**
     * 修改原材料分类
     * 
     * @param lpMaterialsClassify 原材料分类
     * @return 结果
     */
    @Override
    public int updateLpMaterialsClassify(LpMaterialsClassify lpMaterialsClassify)
    {
        lpMaterialsClassify.setUpdateTime(DateUtils.getNowDate());
        return lpMaterialsClassifyMapper.updateLpMaterialsClassify(lpMaterialsClassify);
    }

    /**
     * 批量删除原材料分类
     * 
     * @param materialsClassifyIds 需要删除的原材料分类主键
     * @return 结果
     */
    @Override
    public int deleteLpMaterialsClassifyByMaterialsClassifyIds(Long[] materialsClassifyIds)
    {
        return lpMaterialsClassifyMapper.deleteLpMaterialsClassifyByMaterialsClassifyIds(materialsClassifyIds);
    }

    /**
     * 删除原材料分类信息
     * 
     * @param materialsClassifyId 原材料分类主键
     * @return 结果
     */
    @Override
    public int deleteLpMaterialsClassifyByMaterialsClassifyId(Long materialsClassifyId)
    {
        return lpMaterialsClassifyMapper.deleteLpMaterialsClassifyByMaterialsClassifyId(materialsClassifyId);
    }
}

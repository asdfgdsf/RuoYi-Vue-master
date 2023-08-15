package com.ruoyi.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.LpClassifyMapper;
import com.ruoyi.domain.LpClassify;
import com.ruoyi.service.ILpClassifyService;

/**
 * 供应商分类Service业务层处理
 *
 * @author zjj
 * @date 2023-05-04
 */
@Service
public class LpClassifyServiceImpl implements ILpClassifyService
{
    @Autowired(required = false)
    private LpClassifyMapper lpClassifyMapper;

    /**
     * 查询供应商分类
     *
     * @param classifyId 供应商分类主键
     * @return 供应商分类
     */
    @Override
    public LpClassify selectLpClassifyByClassifyId(Long classifyId)
    {
        return lpClassifyMapper.selectLpClassifyByClassifyId(classifyId);
    }

    /**
     * 查询供应商分类列表
     *
     * @param lpClassify 供应商分类
     * @return 供应商分类
     */
    @Override
    public List<LpClassify> selectLpClassifyList(LpClassify lpClassify)
    {
        return lpClassifyMapper.selectLpClassifyList(lpClassify);
    }

    /**
     * 新增供应商分类
     *
     * @param lpClassify 供应商分类
     * @return 结果
     */
    @Override
    public int insertLpClassify(LpClassify lpClassify)
    {
        lpClassify.setCreateTime(DateUtils.getNowDate());
        return lpClassifyMapper.insertLpClassify(lpClassify);
    }

    /**
     * 修改供应商分类
     *
     * @param lpClassify 供应商分类
     * @return 结果
     */
    @Override
    public int updateLpClassify(LpClassify lpClassify)
    {
        lpClassify.setUpdateTime(DateUtils.getNowDate());
        return lpClassifyMapper.updateLpClassify(lpClassify);
    }

    /**
     * 批量删除供应商分类
     *
     * @param classifyIds 需要删除的供应商分类主键
     * @return 结果
     */
    @Override
    public int deleteLpClassifyByClassifyIds(Long[] classifyIds)
    {
        return lpClassifyMapper.deleteLpClassifyByClassifyIds(classifyIds);
    }

    /**
     * 删除供应商分类信息
     *
     * @param classifyId 供应商分类主键
     * @return 结果
     */
    @Override
    public int deleteLpClassifyByClassifyId(Long classifyId)
    {
        return lpClassifyMapper.deleteLpClassifyByClassifyId(classifyId);
    }
}

package com.ruoyi.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.LpMaterialsMapper;
import com.ruoyi.domain.LpMaterials;
import com.ruoyi.service.ILpMaterialsService;

/**
 * 原料列Service业务层处理
 *
 * @author zjj
 * @date 2023-05-10
 */
@Service
public class LpMaterialsServiceImpl implements ILpMaterialsService
{
    @Autowired(required = false)
    private LpMaterialsMapper lpMaterialsMapper;

    /**
     * 查询原料列
     *
     * @param lpMaterialsId 原料列主键
     * @return 原料列
     */
    @Override
    public LpMaterials selectLpMaterialsByLpMaterialsId(Long lpMaterialsId)
    {
        return lpMaterialsMapper.selectLpMaterialsByLpMaterialsId(lpMaterialsId);
    }

    /**
     * 查询原料列列表
     *
     * @param lpMaterials 原料列
     * @return 原料列
     */
    @Override
    public List<LpMaterials> selectLpMaterialsList(LpMaterials lpMaterials)
    {
        return lpMaterialsMapper.selectLpMaterialsList(lpMaterials);
    }

    /**
     * 新增原料列
     *
     * @param lpMaterials 原料列
     * @return 结果
     */
    @Override
    public int insertLpMaterials(LpMaterials lpMaterials)
    {
        lpMaterials.setCreateTime(DateUtils.getNowDate());
        return lpMaterialsMapper.insertLpMaterials(lpMaterials);
    }

    /**
     * 修改原料列
     *
     * @param lpMaterials 原料列
     * @return 结果
     */
    @Override
    public int updateLpMaterials(LpMaterials lpMaterials)
    {
        lpMaterials.setUpdateTime(DateUtils.getNowDate());
        return lpMaterialsMapper.updateLpMaterials(lpMaterials);
    }

    /**
     * 批量删除原料列
     *
     * @param lpMaterialsIds 需要删除的原料列主键
     * @return 结果
     */
    @Override
    public int deleteLpMaterialsByLpMaterialsIds(Long[] lpMaterialsIds)
    {
        return lpMaterialsMapper.deleteLpMaterialsByLpMaterialsIds(lpMaterialsIds);
    }

    /**
     * 删除原料列信息
     *
     * @param lpMaterialsId 原料列主键
     * @return 结果
     */
    @Override
    public int deleteLpMaterialsByLpMaterialsId(Long lpMaterialsId)
    {
        return lpMaterialsMapper.deleteLpMaterialsByLpMaterialsId(lpMaterialsId);
    }
}

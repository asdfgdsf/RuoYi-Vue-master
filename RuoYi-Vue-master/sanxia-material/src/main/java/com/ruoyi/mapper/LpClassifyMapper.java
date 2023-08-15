package com.ruoyi.mapper;

import java.util.List;
import com.ruoyi.domain.LpClassify;

/**
 * 供应商分类Mapper接口
 *
 * @author zjj
 * @date 2023-05-04
 */
public interface LpClassifyMapper
{
    /**
     * 查询供应商分类
     *
     * @param classifyId 供应商分类主键
     * @return 供应商分类
     */
    public LpClassify selectLpClassifyByClassifyId(Long classifyId);

    /**
     * 查询供应商分类列表
     *
     * @param lpClassify 供应商分类
     * @return 供应商分类集合
     */
    public List<LpClassify> selectLpClassifyList(LpClassify lpClassify);

    /**
     * 新增供应商分类
     *
     * @param lpClassify 供应商分类
     * @return 结果
     */
    public int insertLpClassify(LpClassify lpClassify);

    /**
     * 修改供应商分类
     *
     * @param lpClassify 供应商分类
     * @return 结果
     */
    public int updateLpClassify(LpClassify lpClassify);

    /**
     * 删除供应商分类
     *
     * @param classifyId 供应商分类主键
     * @return 结果
     */
    public int deleteLpClassifyByClassifyId(Long classifyId);

    /**
     * 批量删除供应商分类
     *
     * @param classifyIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLpClassifyByClassifyIds(Long[] classifyIds);
}

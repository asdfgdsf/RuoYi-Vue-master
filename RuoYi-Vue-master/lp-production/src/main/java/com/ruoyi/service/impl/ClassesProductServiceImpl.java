package com.ruoyi.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.ClassesProductMapper;
import com.ruoyi.domain.ClassesProduct;
import com.ruoyi.service.IClassesProductService;

/**
 * 成品分类Service业务层处理
 *
 * @author zjj
 * @date 2023-05-11
 */
@Service
public class ClassesProductServiceImpl implements IClassesProductService
{
    @Autowired(required = false)
    private ClassesProductMapper classesProductMapper;

    /**
     * 查询成品分类
     *
     * @param classesProductId 成品分类主键
     * @return 成品分类
     */
    @Override
    public ClassesProduct selectClassesProductByClassesProductId(Long classesProductId)
    {
        return classesProductMapper.selectClassesProductByClassesProductId(classesProductId);
    }

    /**
     * 查询成品分类列表
     *
     * @param classesProduct 成品分类
     * @return 成品分类
     */
    @Override
    public List<ClassesProduct> selectClassesProductList(ClassesProduct classesProduct)
    {
        return classesProductMapper.selectClassesProductList(classesProduct);
    }

    /**
     * 新增成品分类
     *
     * @param classesProduct 成品分类
     * @return 结果
     */
    @Override
    public int insertClassesProduct(ClassesProduct classesProduct)
    {
        classesProduct.setCreateTime(DateUtils.getNowDate());
        return classesProductMapper.insertClassesProduct(classesProduct);
    }

    /**
     * 修改成品分类
     *
     * @param classesProduct 成品分类
     * @return 结果
     */
    @Override
    public int updateClassesProduct(ClassesProduct classesProduct)
    {
        classesProduct.setUpdateTime(DateUtils.getNowDate());
        return classesProductMapper.updateClassesProduct(classesProduct);
    }

    /**
     * 批量删除成品分类
     *
     * @param classesProductIds 需要删除的成品分类主键
     * @return 结果
     */
    @Override
    public int deleteClassesProductByClassesProductIds(Long[] classesProductIds)
    {
        return classesProductMapper.deleteClassesProductByClassesProductIds(classesProductIds);
    }

    /**
     * 删除成品分类信息
     *
     * @param classesProductId 成品分类主键
     * @return 结果
     */
    @Override
    public int deleteClassesProductByClassesProductId(Long classesProductId)
    {
        return classesProductMapper.deleteClassesProductByClassesProductId(classesProductId);
    }
}

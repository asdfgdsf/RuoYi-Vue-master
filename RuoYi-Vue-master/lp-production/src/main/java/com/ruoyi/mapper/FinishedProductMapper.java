package com.ruoyi.mapper;

import java.util.List;
import com.ruoyi.domain.FinishedProduct;

/**
 * 成品列表Mapper接口
 * 
 * @author jia
 * @date 2023-05-12
 */
public interface FinishedProductMapper 
{
    /**
     * 查询成品列表
     * 
     * @param finishedProductId 成品列表主键
     * @return 成品列表
     */
    public FinishedProduct selectFinishedProductByFinishedProductId(Integer finishedProductId);

    /**
     * 查询成品列表列表
     * 
     * @param finishedProduct 成品列表
     * @return 成品列表集合
     */
    public List<FinishedProduct> selectFinishedProductList(FinishedProduct finishedProduct);

    /**
     * 新增成品列表
     * 
     * @param finishedProduct 成品列表
     * @return 结果
     */
    public int insertFinishedProduct(FinishedProduct finishedProduct);

    /**
     * 修改成品列表
     * 
     * @param finishedProduct 成品列表
     * @return 结果
     */
    public int updateFinishedProduct(FinishedProduct finishedProduct);

    /**
     * 删除成品列表
     * 
     * @param finishedProductId 成品列表主键
     * @return 结果
     */
    public int deleteFinishedProductByFinishedProductId(Integer finishedProductId);

    /**
     * 批量删除成品列表
     * 
     * @param finishedProductIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFinishedProductByFinishedProductIds(Integer[] finishedProductIds);
}

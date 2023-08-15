package com.ruoyi.service;

import java.util.List;
import com.ruoyi.domain.Product;

/**
 * 成品库存Service接口
 * 
 * @author zjj
 * @date 2023-05-12
 */
public interface IProductService 
{
    /**
     * 查询成品库存
     * 
     * @param productId 成品库存主键
     * @return 成品库存
     */
    public Product selectProductByProductId(Integer productId);

    /**
     * 查询成品库存列表
     * 
     * @param product 成品库存
     * @return 成品库存集合
     */
    public List<Product> selectProductList(Product product);

    /**
     * 新增成品库存
     * 
     * @param product 成品库存
     * @return 结果
     */
    public int insertProduct(Product product);

    /**
     * 修改成品库存
     * 
     * @param product 成品库存
     * @return 结果
     */
    public int updateProduct(Product product);

    /**
     * 批量删除成品库存
     * 
     * @param productIds 需要删除的成品库存主键集合
     * @return 结果
     */
    public int deleteProductByProductIds(Integer[] productIds);

    /**
     * 删除成品库存信息
     * 
     * @param productId 成品库存主键
     * @return 结果
     */
    public int deleteProductByProductId(Integer productId);
}

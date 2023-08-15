package com.ruoyi.mapper;

import java.util.List;
import com.ruoyi.domain.OperationProduct;

/**
 * 成品入库Mapper接口
 * 
 * @author jia
 * @date 2023-05-12
 */
public interface OperationProductMapper 
{
    /**
     * 查询成品入库
     * 
     * @param operationProductId 成品入库主键
     * @return 成品入库
     */
    public OperationProduct selectOperationProductByOperationProductId(Integer operationProductId);

    /**
     * 查询成品入库列表
     * 
     * @param operationProduct 成品入库
     * @return 成品入库集合
     */
    public List<OperationProduct> selectOperationProductList(OperationProduct operationProduct);

    /**
     * 新增成品入库
     * 
     * @param operationProduct 成品入库
     * @return 结果
     */
    public int insertOperationProduct(OperationProduct operationProduct);

    /**
     * 修改成品入库
     * 
     * @param operationProduct 成品入库
     * @return 结果
     */
    public int updateOperationProduct(OperationProduct operationProduct);

    /**
     * 删除成品入库
     * 
     * @param operationProductId 成品入库主键
     * @return 结果
     */
    public int deleteOperationProductByOperationProductId(Integer operationProductId);

    /**
     * 批量删除成品入库
     * 
     * @param operationProductIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOperationProductByOperationProductIds(Integer[] operationProductIds);
}

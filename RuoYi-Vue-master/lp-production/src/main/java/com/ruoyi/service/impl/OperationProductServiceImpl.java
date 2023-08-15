package com.ruoyi.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.Vo.OperationProductVo;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.domain.Product;
import com.ruoyi.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.OperationProductMapper;
import com.ruoyi.domain.OperationProduct;
import com.ruoyi.service.IOperationProductService;

/**
 * 成品入库Service业务层处理
 *
 * @author jia
 * @date 2023-05-12
 */
@Service
public class OperationProductServiceImpl implements IOperationProductService
{
    @Autowired(required = false)
    private OperationProductMapper operationProductMapper;
    @Autowired(required = false)
    private ProductMapper productMapper;

    /**
     * 查询成品入库
     *
     * @param operationProductId 成品入库主键
     * @return 成品入库
     */
    @Override
    public OperationProduct selectOperationProductByOperationProductId(Integer operationProductId)
    {
        return operationProductMapper.selectOperationProductByOperationProductId(operationProductId);
    }

    /**
     * 查询成品入库列表
     *
     * @param operationProduct 成品入库
     * @return 成品入库
     */
    @Override
    public List<OperationProduct> selectOperationProductList(OperationProduct operationProduct)
    {
        return operationProductMapper.selectOperationProductList(operationProduct);
    }

    /**
     * 新增成品入库
     *
     * @param operationProduct 成品入库
     * @return 结果
     */
    @Override
    public int insertOperationProduct(OperationProduct operationProduct)
    {
        operationProduct.setCreateTime(DateUtils.getNowDate());
        return operationProductMapper.insertOperationProduct(operationProduct);
    }

    /**
     * 修改成品入库
     *
     * @param operationProduct 成品入库
     * @return 结果
     */
    @Override
    public int updateOperationProduct(OperationProduct operationProduct)
    {
        operationProduct.setUpdateTime(DateUtils.getNowDate());
        return operationProductMapper.updateOperationProduct(operationProduct);
    }

    /**
     * 批量删除成品入库
     *
     * @param operationProductIds 需要删除的成品入库主键
     * @return 结果
     */
    @Override
    public int deleteOperationProductByOperationProductIds(Integer[] operationProductIds)
    {
        return operationProductMapper.deleteOperationProductByOperationProductIds(operationProductIds);
    }

    /**
     * 删除成品入库信息
     *
     * @param operationProductId 成品入库主键
     * @return 结果
     */
    @Override
    public int deleteOperationProductByOperationProductId(Integer operationProductId)
    {
        return operationProductMapper.deleteOperationProductByOperationProductId(operationProductId);
    }

    @Override
    public int chonseOperationProduct(OperationProductVo operationProductVo) {
        OperationProduct operationProduct = new OperationProduct();
        operationProduct.setOperationProductId(operationProductVo.getOperationProductId());
        operationProduct.setWarehouseId(operationProductVo.getWarehouseId());
        operationProduct.setShelfId(operationProductVo.getShelfId());
        operationProduct.setLocationId(operationProductVo.getLocationId());

        return operationProductMapper.updateOperationProduct(operationProduct);
    }

    @Override
    public int auditOperationProduct(OperationProductVo operationProductVo) {
        OperationProduct operationProduct = new OperationProduct();
        operationProduct.setOperationProductId(operationProductVo.getOperationProductId());
        operationProduct.setAuditStatus(operationProductVo.getAuditStatus());
        operationProduct.setAuditOpinion(operationProductVo.getAuditOpinion());
        operationProduct.setAuditPerson(SecurityUtils.getUsername());
        operationProduct.setAuditTime(new Date());
        return operationProductMapper.updateOperationProduct(operationProduct);
    }

    @Override
    public int approverOperationProduct(OperationProductVo operationProductVo) {
        OperationProduct operationProduct = new OperationProduct();
        operationProduct.setOperationProductId(operationProductVo.getOperationProductId());
        operationProduct.setAuditStatus(operationProductVo.getAuditStatus());
        operationProduct.setApproverOpinion(operationProductVo.getApproverOpinion());
        operationProduct.setApproverPerson(SecurityUtils.getUsername());
        operationProduct.setApproverTime(new Date());
        int num = operationProductMapper.updateOperationProduct(operationProduct);
        if(num == 1){
            OperationProduct oP = operationProductMapper.selectOperationProductByOperationProductId(operationProductVo.getOperationProductId());
            if(oP.getAuditStatus().intValue() == 2){
                Product product = new Product();
                product.setProductName(oP.getOperationProductName());
                product.setProductNum(oP.getOperationProductNum());
                product.setProductUnit(oP.getOperationProductUnit());
                product.setOperationProductId(oP.getOperationProductId());
                product.setProductPrice(oP.getOperationProductPrice());
                product.setCreateTime(new Date());
                product.setCreateBy("系统创建");

                return productMapper.insertProduct(product);
            }
        }
        return 0;
    }
}

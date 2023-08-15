package com.ruoyi.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 成品库存对象 lp_product
 * 
 * @author zjj
 * @date 2023-05-12
 */
public class Product extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer productId;

    /** 成品库存名称 */
    @Excel(name = "成品库存名称")
    private String productName;

    /** 数量 */
    @Excel(name = "数量")
    private Integer productNum;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal productPrice;

    /** 单位 */
    @Excel(name = "单位")
    private String productUnit;

    /** 成品入库ID */
    @Excel(name = "成品入库ID")
    private Integer operationProductId;

    public void setProductId(Integer productId) 
    {
        this.productId = productId;
    }

    public Integer getProductId() 
    {
        return productId;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setProductNum(Integer productNum) 
    {
        this.productNum = productNum;
    }

    public Integer getProductNum() 
    {
        return productNum;
    }
    public void setProductPrice(BigDecimal productPrice) 
    {
        this.productPrice = productPrice;
    }

    public BigDecimal getProductPrice() 
    {
        return productPrice;
    }
    public void setProductUnit(String productUnit) 
    {
        this.productUnit = productUnit;
    }

    public String getProductUnit() 
    {
        return productUnit;
    }
    public void setOperationProductId(Integer operationProductId) 
    {
        this.operationProductId = operationProductId;
    }

    public Integer getOperationProductId() 
    {
        return operationProductId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("productId", getProductId())
            .append("productName", getProductName())
            .append("productNum", getProductNum())
            .append("productPrice", getProductPrice())
            .append("productUnit", getProductUnit())
            .append("operationProductId", getOperationProductId())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}

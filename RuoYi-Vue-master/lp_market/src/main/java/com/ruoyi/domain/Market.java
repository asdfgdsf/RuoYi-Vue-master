package com.ruoyi.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * market对象 lp_market
 * 
 * @author jia
 * @date 2023-05-12
 */
public class Market extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer marketId;

    /** 销售名称 */
    @Excel(name = "销售名称")
    private String marketName;

    /** 客户ID */
    @Excel(name = "客户ID")
    private Integer clientId;

    /** 销售数量 */
    @Excel(name = "销售数量")
    private Integer marketNum;

    /** 销售价格 */
    @Excel(name = "销售价格")
    private BigDecimal marketPrice;

    /** 单位 */
    @Excel(name = "单位")
    private String marketUnit;

    /** 0表示未审核  1表示审核  2表示审批 */
    @Excel(name = "0表示未审核  1表示审核  2表示审批")
    private Integer auditStatus;

    /** 审核意见 */
    @Excel(name = "审核意见")
    private String auditOpinion;

    /** 审核时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date auditTime;

    /** 审核人 */
    @Excel(name = "审核人")
    private String auditPerson;

    /** 审批意见 */
    @Excel(name = "审批意见")
    private String approverOpinion;

    /** 审批时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审批时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date approverTime;

    /** 审批人 */
    @Excel(name = "审批人")
    private String approverPerson;

    /** 描述 */
    @Excel(name = "描述")
    private String description;

    public void setMarketId(Integer marketId) 
    {
        this.marketId = marketId;
    }

    public Integer getMarketId() 
    {
        return marketId;
    }
    public void setMarketName(String marketName) 
    {
        this.marketName = marketName;
    }

    public String getMarketName() 
    {
        return marketName;
    }
    public void setClientId(Integer clientId) 
    {
        this.clientId = clientId;
    }

    public Integer getClientId() 
    {
        return clientId;
    }
    public void setMarketNum(Integer marketNum) 
    {
        this.marketNum = marketNum;
    }

    public Integer getMarketNum() 
    {
        return marketNum;
    }
    public void setMarketPrice(BigDecimal marketPrice) 
    {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getMarketPrice() 
    {
        return marketPrice;
    }
    public void setMarketUnit(String marketUnit) 
    {
        this.marketUnit = marketUnit;
    }

    public String getMarketUnit() 
    {
        return marketUnit;
    }
    public void setAuditStatus(Integer auditStatus) 
    {
        this.auditStatus = auditStatus;
    }

    public Integer getAuditStatus() 
    {
        return auditStatus;
    }
    public void setAuditOpinion(String auditOpinion) 
    {
        this.auditOpinion = auditOpinion;
    }

    public String getAuditOpinion() 
    {
        return auditOpinion;
    }
    public void setAuditTime(Date auditTime) 
    {
        this.auditTime = auditTime;
    }

    public Date getAuditTime() 
    {
        return auditTime;
    }
    public void setAuditPerson(String auditPerson) 
    {
        this.auditPerson = auditPerson;
    }

    public String getAuditPerson() 
    {
        return auditPerson;
    }
    public void setApproverOpinion(String approverOpinion) 
    {
        this.approverOpinion = approverOpinion;
    }

    public String getApproverOpinion() 
    {
        return approverOpinion;
    }
    public void setApproverTime(Date approverTime) 
    {
        this.approverTime = approverTime;
    }

    public Date getApproverTime() 
    {
        return approverTime;
    }
    public void setApproverPerson(String approverPerson) 
    {
        this.approverPerson = approverPerson;
    }

    public String getApproverPerson() 
    {
        return approverPerson;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("marketId", getMarketId())
            .append("marketName", getMarketName())
            .append("clientId", getClientId())
            .append("marketNum", getMarketNum())
            .append("marketPrice", getMarketPrice())
            .append("marketUnit", getMarketUnit())
            .append("auditStatus", getAuditStatus())
            .append("auditOpinion", getAuditOpinion())
            .append("auditTime", getAuditTime())
            .append("auditPerson", getAuditPerson())
            .append("approverOpinion", getApproverOpinion())
            .append("approverTime", getApproverTime())
            .append("approverPerson", getApproverPerson())
            .append("description", getDescription())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}

package com.ruoyi.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 生产耗材对象 lp_production_inventory
 * 
 * @author ruoyi
 * @date 2023-05-11
 */
public class ProductionInventory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键递增 */
    private Long productionInventoryId;

    /** 原料名称 */
    @Excel(name = "原料名称")
    private String productionInventoryName;

    /** 原料数量 */
    @Excel(name = "原料数量")
    private Long productionInventoryNum;

    /** 原料价格 */
    @Excel(name = "原料价格")
    private BigDecimal productionInventoryPrice;

    /** 单位 */
    @Excel(name = "单位")
    private String productionInventoryUnit;

    /** 成品名称 */
    @Excel(name = "成品名称")
    private String finishedProductName;

    /** 成品数量 */
    @Excel(name = "成品数量")
    private Long finishedProductNum;

    /** 成品单位 */
    @Excel(name = "成品单位")
    private String finishedProductUnit;

    /** 损耗名称 */
    @Excel(name = "损耗名称")
    private String lossName;

    /** 损耗数量 */
    @Excel(name = "损耗数量")
    private Long lossNum;

    /** 损耗单位 */
    @Excel(name = "损耗单位")
    private String lossUnit;

    /** 带班人员 */
    @Excel(name = "带班人员")
    private String firstDuty;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String firstDutyPhone;

    /** 班次 */
    @Excel(name = "班次")
    private String gradeClass;

    /** 上班时间 */
    @Excel(name = "上班时间")
    private String officeTime;

    /** 下班时间 */
    @Excel(name = "下班时间")
    private String offTime;

    /** 上班人数 */
    @Excel(name = "上班人数")
    private Long officeNum;

    /** 0表示未审核  1表示审核  2表示审批  */
    @Excel(name = "0表示未审核  1表示审核  2表示审批 ")
    private Long auditStatus;

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

    public void setProductionInventoryId(Long productionInventoryId) 
    {
        this.productionInventoryId = productionInventoryId;
    }

    public Long getProductionInventoryId() 
    {
        return productionInventoryId;
    }
    public void setProductionInventoryName(String productionInventoryName) 
    {
        this.productionInventoryName = productionInventoryName;
    }

    public String getProductionInventoryName() 
    {
        return productionInventoryName;
    }
    public void setProductionInventoryNum(Long productionInventoryNum) 
    {
        this.productionInventoryNum = productionInventoryNum;
    }

    public Long getProductionInventoryNum() 
    {
        return productionInventoryNum;
    }
    public void setProductionInventoryPrice(BigDecimal productionInventoryPrice) 
    {
        this.productionInventoryPrice = productionInventoryPrice;
    }

    public BigDecimal getProductionInventoryPrice() 
    {
        return productionInventoryPrice;
    }
    public void setProductionInventoryUnit(String productionInventoryUnit) 
    {
        this.productionInventoryUnit = productionInventoryUnit;
    }

    public String getProductionInventoryUnit() 
    {
        return productionInventoryUnit;
    }
    public void setFinishedProductName(String finishedProductName) 
    {
        this.finishedProductName = finishedProductName;
    }

    public String getFinishedProductName() 
    {
        return finishedProductName;
    }
    public void setFinishedProductNum(Long finishedProductNum) 
    {
        this.finishedProductNum = finishedProductNum;
    }

    public Long getFinishedProductNum() 
    {
        return finishedProductNum;
    }
    public void setFinishedProductUnit(String finishedProductUnit) 
    {
        this.finishedProductUnit = finishedProductUnit;
    }

    public String getFinishedProductUnit() 
    {
        return finishedProductUnit;
    }
    public void setLossName(String lossName) 
    {
        this.lossName = lossName;
    }

    public String getLossName() 
    {
        return lossName;
    }
    public void setLossNum(Long lossNum) 
    {
        this.lossNum = lossNum;
    }

    public Long getLossNum() 
    {
        return lossNum;
    }
    public void setLossUnit(String lossUnit) 
    {
        this.lossUnit = lossUnit;
    }

    public String getLossUnit() 
    {
        return lossUnit;
    }
    public void setFirstDuty(String firstDuty) 
    {
        this.firstDuty = firstDuty;
    }

    public String getFirstDuty() 
    {
        return firstDuty;
    }
    public void setFirstDutyPhone(String firstDutyPhone) 
    {
        this.firstDutyPhone = firstDutyPhone;
    }

    public String getFirstDutyPhone() 
    {
        return firstDutyPhone;
    }
    public void setGradeClass(String gradeClass) 
    {
        this.gradeClass = gradeClass;
    }

    public String getGradeClass() 
    {
        return gradeClass;
    }
    public void setOfficeTime(String officeTime) 
    {
        this.officeTime = officeTime;
    }

    public String getOfficeTime() 
    {
        return officeTime;
    }
    public void setOffTime(String offTime) 
    {
        this.offTime = offTime;
    }

    public String getOffTime() 
    {
        return offTime;
    }
    public void setOfficeNum(Long officeNum) 
    {
        this.officeNum = officeNum;
    }

    public Long getOfficeNum() 
    {
        return officeNum;
    }
    public void setAuditStatus(Long auditStatus) 
    {
        this.auditStatus = auditStatus;
    }

    public Long getAuditStatus() 
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("productionInventoryId", getProductionInventoryId())
            .append("productionInventoryName", getProductionInventoryName())
            .append("productionInventoryNum", getProductionInventoryNum())
            .append("productionInventoryPrice", getProductionInventoryPrice())
            .append("productionInventoryUnit", getProductionInventoryUnit())
            .append("finishedProductName", getFinishedProductName())
            .append("finishedProductNum", getFinishedProductNum())
            .append("finishedProductUnit", getFinishedProductUnit())
            .append("lossName", getLossName())
            .append("lossNum", getLossNum())
            .append("lossUnit", getLossUnit())
            .append("firstDuty", getFirstDuty())
            .append("firstDutyPhone", getFirstDutyPhone())
            .append("gradeClass", getGradeClass())
            .append("officeTime", getOfficeTime())
            .append("offTime", getOffTime())
            .append("officeNum", getOfficeNum())
            .append("auditStatus", getAuditStatus())
            .append("auditOpinion", getAuditOpinion())
            .append("auditTime", getAuditTime())
            .append("auditPerson", getAuditPerson())
            .append("approverOpinion", getApproverOpinion())
            .append("approverTime", getApproverTime())
            .append("approverPerson", getApproverPerson())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}

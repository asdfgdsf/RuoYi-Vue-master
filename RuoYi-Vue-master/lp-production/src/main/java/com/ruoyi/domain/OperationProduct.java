package com.ruoyi.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 成品入库对象 lp_operation_product
 * 
 * @author jia
 * @date 2023-05-12
 */
public class OperationProduct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer operationProductId;

    /** 成品库存名称 */
    @Excel(name = "成品库存名称")
    private String operationProductName;

    /** 数量 */
    @Excel(name = "数量")
    private Integer operationProductNum;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal operationProductPrice;

    /** 单位 */
    @Excel(name = "单位")
    private String operationProductUnit;

    /** 库房ID */
    @Excel(name = "库房ID")
    private Integer warehouseId;

    /** 货架ID */
    @Excel(name = "货架ID")
    private Integer shelfId;

    /** 库位ID */
    @Excel(name = "库位ID")
    private Integer locationId;

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
    private Integer officeNum;

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

    public void setOperationProductId(Integer operationProductId) 
    {
        this.operationProductId = operationProductId;
    }

    public Integer getOperationProductId() 
    {
        return operationProductId;
    }
    public void setOperationProductName(String operationProductName) 
    {
        this.operationProductName = operationProductName;
    }

    public String getOperationProductName() 
    {
        return operationProductName;
    }
    public void setOperationProductNum(Integer operationProductNum) 
    {
        this.operationProductNum = operationProductNum;
    }

    public Integer getOperationProductNum() 
    {
        return operationProductNum;
    }
    public void setOperationProductPrice(BigDecimal operationProductPrice) 
    {
        this.operationProductPrice = operationProductPrice;
    }

    public BigDecimal getOperationProductPrice() 
    {
        return operationProductPrice;
    }
    public void setOperationProductUnit(String operationProductUnit) 
    {
        this.operationProductUnit = operationProductUnit;
    }

    public String getOperationProductUnit() 
    {
        return operationProductUnit;
    }
    public void setWarehouseId(Integer warehouseId) 
    {
        this.warehouseId = warehouseId;
    }

    public Integer getWarehouseId() 
    {
        return warehouseId;
    }
    public void setShelfId(Integer shelfId) 
    {
        this.shelfId = shelfId;
    }

    public Integer getShelfId() 
    {
        return shelfId;
    }
    public void setLocationId(Integer locationId) 
    {
        this.locationId = locationId;
    }

    public Integer getLocationId() 
    {
        return locationId;
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
    public void setOfficeNum(Integer officeNum) 
    {
        this.officeNum = officeNum;
    }

    public Integer getOfficeNum() 
    {
        return officeNum;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("operationProductId", getOperationProductId())
            .append("operationProductName", getOperationProductName())
            .append("operationProductNum", getOperationProductNum())
            .append("operationProductPrice", getOperationProductPrice())
            .append("operationProductUnit", getOperationProductUnit())
            .append("warehouseId", getWarehouseId())
            .append("shelfId", getShelfId())
            .append("locationId", getLocationId())
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

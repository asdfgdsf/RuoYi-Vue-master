package com.ruoyi.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

public class ClientVo {
    private Integer clientId;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String clientName;

    /** 分类ID */
    @Excel(name = "分类ID")
    private Integer clientClassifyId;

    /** 客户地址 */
    @Excel(name = "客户地址")
    private String clientAddress;

    /** 联系人 */
    @Excel(name = "联系人")
    private String clientPerson;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String clientPhone;

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

    public void setClientId(Integer clientId)
    {
        this.clientId = clientId;
    }

    public Integer getClientId()
    {
        return clientId;
    }
    public void setClientName(String clientName)
    {
        this.clientName = clientName;
    }

    public String getClientName()
    {
        return clientName;
    }
    public void setClientClassifyId(Integer clientClassifyId)
    {
        this.clientClassifyId = clientClassifyId;
    }

    public Integer getClientClassifyId()
    {
        return clientClassifyId;
    }
    public void setClientAddress(String clientAddress)
    {
        this.clientAddress = clientAddress;
    }

    public String getClientAddress()
    {
        return clientAddress;
    }
    public void setClientPerson(String clientPerson)
    {
        this.clientPerson = clientPerson;
    }

    public String getClientPerson()
    {
        return clientPerson;
    }
    public void setClientPhone(String clientPhone)
    {
        this.clientPhone = clientPhone;
    }

    public String getClientPhone()
    {
        return clientPhone;
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
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("clientId", getClientId())
                .append("clientName", getClientName())
                .append("clientClassifyId", getClientClassifyId())
                .append("clientAddress", getClientAddress())
                .append("clientPerson", getClientPerson())
                .append("clientPhone", getClientPhone())
                .append("auditStatus", getAuditStatus())
                .append("auditOpinion", getAuditOpinion())
                .append("auditTime", getAuditTime())
                .append("auditPerson", getAuditPerson())
                .append("approverOpinion", getApproverOpinion())
                .append("approverTime", getApproverTime())
                .append("approverPerson", getApproverPerson())
                .append("description", getDescription())
                .toString();
    }
}

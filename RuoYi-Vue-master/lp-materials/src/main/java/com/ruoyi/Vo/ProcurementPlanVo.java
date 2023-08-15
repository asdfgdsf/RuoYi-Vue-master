package com.ruoyi.Vo;

import java.util.Date;

public class ProcurementPlanVo {
    private Long procurementPlanId;
    private Long auditStatus;
    private String auditOpinion;
    private Date auditTime;
    private String auditPerson;
    private String approverOpinion;
    private Date approverTime;
    private String approverPerson;

    public ProcurementPlanVo() {
    }

    public ProcurementPlanVo(Long procurementPlanId, Long auditStatus, String auditOpinion, Date auditTime, String auditPerson, String approverOpinion, Date approverTime, String approverPerson) {
        this.procurementPlanId = procurementPlanId;
        this.auditStatus = auditStatus;
        this.auditOpinion = auditOpinion;
        this.auditTime = auditTime;
        this.auditPerson = auditPerson;
        this.approverOpinion = approverOpinion;
        this.approverTime = approverTime;
        this.approverPerson = approverPerson;
    }

    public Long getProcurementPlanId() {
        return procurementPlanId;
    }

    public void setProcurementPlanId(Long procurementPlanId) {
        this.procurementPlanId = procurementPlanId;
    }

    public Long getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Long auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAuditOpinion() {
        return auditOpinion;
    }

    public void setAuditOpinion(String auditOpinion) {
        this.auditOpinion = auditOpinion;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getAuditPerson() {
        return auditPerson;
    }

    public void setAuditPerson(String auditPerson) {
        this.auditPerson = auditPerson;
    }

    public String getApproverOpinion() {
        return approverOpinion;
    }

    public void setApproverOpinion(String approverOpinion) {
        this.approverOpinion = approverOpinion;
    }

    public Date getApproverTime() {
        return approverTime;
    }

    public void setApproverTime(Date approverTime) {
        this.approverTime = approverTime;
    }

    public String getApproverPerson() {
        return approverPerson;
    }

    public void setApproverPerson(String approverPerson) {
        this.approverPerson = approverPerson;
    }

    @Override
    public String toString() {
        return "ProcurementPlanVo{" +
                "procurementPlanId=" + procurementPlanId +
                ", auditStatus=" + auditStatus +
                ", auditOpinion='" + auditOpinion + '\'' +
                ", auditTime=" + auditTime +
                ", auditPerson='" + auditPerson + '\'' +
                ", approverOpinion='" + approverOpinion + '\'' +
                ", approverTime=" + approverTime +
                ", approverPerson='" + approverPerson + '\'' +
                '}';
    }
}

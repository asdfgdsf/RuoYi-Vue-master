package com.ruoyi.Vo;

import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

public class EquipmentVo extends BaseEntity {
    private Long equipmentId;
    private Long equipmentStatus;
    private Long auditStatus;
    private String auditOpinion;
    private Date auditTime;
    private String auditPerson;
    private String approverOpinion;
    private Date approverTime;
    private String approverPerson;

    public EquipmentVo() {
    }

    public EquipmentVo(Long equipmentId, Long equipmentStatus, Long auditStatus, String auditOpinion, Date auditTime, String auditPerson, String approverOpinion, Date approverTime, String approverPerson) {
        this.equipmentId = equipmentId;
        this.equipmentStatus = equipmentStatus;
        this.auditStatus = auditStatus;
        this.auditOpinion = auditOpinion;
        this.auditTime = auditTime;
        this.auditPerson = auditPerson;
        this.approverOpinion = approverOpinion;
        this.approverTime = approverTime;
        this.approverPerson = approverPerson;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Long getEquipmentStatus() {
        return equipmentStatus;
    }

    public void setEquipmentStatus(Long equipmentStatus) {
        this.equipmentStatus = equipmentStatus;
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
        return "EquipmentVo{" +
                "equipmentId=" + equipmentId +
                ", equipmentStatus=" + equipmentStatus +
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

package com.ruoyi.Vo;

import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class FinishedProductVo {
    private Integer finishedProductId;

    /** 成品名称 */
    @Excel(name = "成品名称")
    private String finishedProductName;

    /** 成品数量 */
    @Excel(name = "成品数量")
    private Integer finishedProductNum;

    /** 单位 */
    @Excel(name = "单位")
    private String finishedProductUnit;

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

    public void setFinishedProductId(Integer finishedProductId)
    {
        this.finishedProductId = finishedProductId;
    }

    public Integer getFinishedProductId()
    {
        return finishedProductId;
    }
    public void setFinishedProductName(String finishedProductName)
    {
        this.finishedProductName = finishedProductName;
    }

    public String getFinishedProductName()
    {
        return finishedProductName;
    }
    public void setFinishedProductNum(Integer finishedProductNum)
    {
        this.finishedProductNum = finishedProductNum;
    }

    public Integer getFinishedProductNum()
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("finishedProductId", getFinishedProductId())
                .append("finishedProductName", getFinishedProductName())
                .append("finishedProductNum", getFinishedProductNum())
                .append("finishedProductUnit", getFinishedProductUnit())
                .append("firstDuty", getFirstDuty())
                .append("firstDutyPhone", getFirstDutyPhone())
                .append("gradeClass", getGradeClass())
                .append("officeTime", getOfficeTime())
                .append("offTime", getOffTime())
                .append("officeNum", getOfficeNum())

                .toString();
    }
}

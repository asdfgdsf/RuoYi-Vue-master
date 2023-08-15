package com.ruoyi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备分类对象 lp_classification
 *
 * @author zjj
 * @date 2023-05-08
 */
public class LpClassification extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键递增 */
    private Long classificationId;

    /** 设备分类名称 */
    @Excel(name = "设备分类名称")
    private String classificationName;

    /** 设备描述 */
    @Excel(name = "设备描述")
    private String description;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    public void setClassificationId(Long classificationId)
    {
        this.classificationId = classificationId;
    }

    public Long getClassificationId()
    {
        return classificationId;
    }
    public void setClassificationName(String classificationName)
    {
        this.classificationName = classificationName;
    }

    public String getClassificationName()
    {
        return classificationName;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
    public void setSort(Long sort)
    {
        this.sort = sort;
    }

    public Long getSort()
    {
        return sort;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("classificationId", getClassificationId())
                .append("classificationName", getClassificationName())
                .append("description", getDescription())
                .append("sort", getSort())
                .append("remark", getRemark())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}

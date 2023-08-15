package com.ruoyi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 原材料分类对象 lp_materials_classify
 * 
 * @author zjj
 * @date 2023-05-10
 */
public class LpMaterialsClassify extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long materialsClassifyId;

    /** 原材料分类名称 */
    @Excel(name = "原材料分类名称")
    private String materialsClassifyName;

    public void setMaterialsClassifyId(Long materialsClassifyId) 
    {
        this.materialsClassifyId = materialsClassifyId;
    }

    public Long getMaterialsClassifyId() 
    {
        return materialsClassifyId;
    }
    public void setMaterialsClassifyName(String materialsClassifyName) 
    {
        this.materialsClassifyName = materialsClassifyName;
    }

    public String getMaterialsClassifyName() 
    {
        return materialsClassifyName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("materialsClassifyId", getMaterialsClassifyId())
            .append("materialsClassifyName", getMaterialsClassifyName())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}

package com.ruoyi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客户分类对象 lp_client_classify
 * 
 * @author jia
 * @date 2023-05-12
 */
public class ClientClassify extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer clientClassifyId;

    /** 客户分类名称 */
    @Excel(name = "客户分类名称")
    private String clientClassifyName;

    /** 描述 */
    @Excel(name = "描述")
    private String description;

    public void setClientClassifyId(Integer clientClassifyId) 
    {
        this.clientClassifyId = clientClassifyId;
    }

    public Integer getClientClassifyId() 
    {
        return clientClassifyId;
    }
    public void setClientClassifyName(String clientClassifyName) 
    {
        this.clientClassifyName = clientClassifyName;
    }

    public String getClientClassifyName() 
    {
        return clientClassifyName;
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
            .append("clientClassifyId", getClientClassifyId())
            .append("clientClassifyName", getClientClassifyName())
            .append("description", getDescription())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}

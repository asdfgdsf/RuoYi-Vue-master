package com.ruoyi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 货架列对象 lp_shelf
 * 
 * @author zjj
 * @date 2023-05-10
 */
public class Shelf extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long shelfId;

    /** 货架名称 */
    @Excel(name = "货架名称")
    private String shelfName;

    /** 货架编码 */
    @Excel(name = "货架编码")
    private String shelfEncoding;

    public void setShelfId(Long shelfId) 
    {
        this.shelfId = shelfId;
    }

    public Long getShelfId() 
    {
        return shelfId;
    }
    public void setShelfName(String shelfName) 
    {
        this.shelfName = shelfName;
    }

    public String getShelfName() 
    {
        return shelfName;
    }
    public void setShelfEncoding(String shelfEncoding) 
    {
        this.shelfEncoding = shelfEncoding;
    }

    public String getShelfEncoding() 
    {
        return shelfEncoding;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("shelfId", getShelfId())
            .append("shelfName", getShelfName())
            .append("shelfEncoding", getShelfEncoding())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}

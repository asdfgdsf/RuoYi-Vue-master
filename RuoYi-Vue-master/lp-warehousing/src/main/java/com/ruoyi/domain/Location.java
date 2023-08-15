package com.ruoyi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 货位列对象 lp_location
 * 
 * @author ruoyi
 * @date 2023-05-10
 */
public class Location extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long locationId;

    /** 货位名称 */
    @Excel(name = "货位名称")
    private String locationName;

    /** 货位编码 */
    @Excel(name = "货位编码")
    private String locationEncoding;

    public void setLocationId(Long locationId) 
    {
        this.locationId = locationId;
    }

    public Long getLocationId() 
    {
        return locationId;
    }
    public void setLocationName(String locationName) 
    {
        this.locationName = locationName;
    }

    public String getLocationName() 
    {
        return locationName;
    }
    public void setLocationEncoding(String locationEncoding) 
    {
        this.locationEncoding = locationEncoding;
    }

    public String getLocationEncoding() 
    {
        return locationEncoding;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("locationId", getLocationId())
            .append("locationName", getLocationName())
            .append("locationEncoding", getLocationEncoding())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}

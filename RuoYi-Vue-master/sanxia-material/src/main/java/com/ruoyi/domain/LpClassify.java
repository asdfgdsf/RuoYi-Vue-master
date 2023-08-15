package com.ruoyi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 供应商分类对象 lp_classify
 *
 * @author zjj
 * @date 2023-05-04
 */
//BaseEntity里含有update和create
public class LpClassify extends BaseEntity
{
    private static final long serialVersionUID = 1L;
//    这个东西简单的说就是一个版本名字。在反序列化的时候回用到。
//
//
//
//jvm在反序列化的时候先去对比这个版本名字，如果数据流中的serialVersionUID和类中的serialVersionUID相同，才会进行反序列化，而不同的话就会抛出异常。一般来说，如果你对一个实现了serializable接口的类进行修改之后，需要修改这个版本信息。
//
//如果你显示定义了private static final long serialVersionUID = 1L;那么如果你忘记修改这个信息，而且你对这个类进行修改的话，这个类也能被进行反序列化。而且不会报错，一个简单的概括就是，如果你忘记修改，那么它是会版本向上兼容的。


    /** 主键递增 */
    private Long classifyId;

    /** 供应商分类名称 */
    @Excel(name = "供应商分类名称")
    private String classifyName;

    /** 供应商分类描述 */
//    自定义导出Excel数据注解
    @Excel(name = "供应商分类描述")
    private String description;

    /** 是否删除 0 表示不删除  1表示删除 */
    @Excel(name = "是否删除 0 表示不删除  1表示删除")
    private Long isDelete;

    public void setClassifyId(Long classifyId)
    {
        this.classifyId = classifyId;
    }

    public Long getClassifyId()
    {
        return classifyId;
    }
    public void setClassifyName(String classifyName)
    {
        this.classifyName = classifyName;
    }

    public String getClassifyName()
    {
        return classifyName;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
    public void setIsDelete(Long isDelete)
    {
        this.isDelete = isDelete;
    }

    public Long getIsDelete()
    {
        return isDelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("classifyId", getClassifyId())
                .append("classifyName", getClassifyName())
                .append("description", getDescription())
                .append("remark", getRemark())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("isDelete", getIsDelete())
                .toString();
    }
}

package com.ruoyi.mapper;

import java.util.List;
import com.ruoyi.domain.LpAdjunct;

/**
 * 设备附件Mapper接口
 *
 * @author zjj
 * @date 2023-05-09
 */
public interface LpAdjunctMapper
{
    /**
     * 查询设备附件列表
     *
     * @param adjunctId 设备附件列表主键
     * @return 设备附件列表
     */
    public LpAdjunct selectAdjunctByAdjunctId(Long adjunctId);

    /**
     * 查询设备附件列表列表
     *
     * @param adjunct 设备附件列表
     * @return 设备附件列表集合
     */
    public List<LpAdjunct> selectAdjunctList(LpAdjunct adjunct);

    /**
     * 新增设备附件列表
     *
     * @param adjunct 设备附件列表
     * @return 结果
     */
    public int insertAdjunct(LpAdjunct adjunct);

    /**
     * 修改设备附件列表
     *
     * @param adjunct 设备附件列表
     * @return 结果
     */
    public int updateAdjunct(LpAdjunct adjunct);

    /**
     * 删除设备附件列表
     *
     * @param adjunctId 设备附件列表主键
     * @return 结果
     */
    public int deleteAdjunctByAdjunctId(Long adjunctId);

    /**
     * 批量删除设备附件列表
     *
     * @param adjunctIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAdjunctByAdjunctIds(Long[] adjunctIds);
}

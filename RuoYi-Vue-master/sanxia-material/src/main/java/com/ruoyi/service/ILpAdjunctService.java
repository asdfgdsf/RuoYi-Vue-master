package com.ruoyi.service;

import java.util.List;

import com.ruoyi.Vo.AdjunctVo;
import com.ruoyi.domain.LpAdjunct;

/**
 * 设备附件Service接口
 *
 * @author zjj
 * @date 2023-05-09
 */
public interface ILpAdjunctService
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
     * 批量删除设备附件列表
     *
     * @param adjunctIds 需要删除的设备附件列表主键集合
     * @return 结果
     */
    public int deleteAdjunctByAdjunctIds(Long[] adjunctIds);

    /**
     * 删除设备附件列表信息
     *
     * @param adjunctId 设备附件列表主键
     * @return 结果
     */
    public int deleteAdjunctByAdjunctId(Long adjunctId);

    public int auditAdjunct(AdjunctVo adjunctVo);

    public int approverAdjunct(AdjunctVo adjunctVo);
}

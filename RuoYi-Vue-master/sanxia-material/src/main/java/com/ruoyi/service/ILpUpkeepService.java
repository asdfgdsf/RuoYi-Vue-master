package com.ruoyi.service;

import java.util.List;

import com.ruoyi.Vo.UpkeepVo;
import com.ruoyi.domain.LpUpkeep;

/**
 * 设备保养Service接口
 *
 * @author zjj
 * @date 2023-05-09
 */
public interface ILpUpkeepService
{
    /**
     * 查询设备保养
     *
     * @param upkeepId 设备保养主键
     * @return 设备保养
     */
    public LpUpkeep selectLpUpkeepByUpkeepId(Long upkeepId);

    /**
     * 查询设备保养列表
     *
     * @param lpUpkeep 设备保养
     * @return 设备保养集合
     */
    public List<LpUpkeep> selectLpUpkeepList(LpUpkeep lpUpkeep);

    /**
     * 新增设备保养
     *
     * @param lpUpkeep 设备保养
     * @return 结果
     */
    public int insertLpUpkeep(LpUpkeep lpUpkeep);

    /**
     * 修改设备保养
     *
     * @param lpUpkeep 设备保养
     * @return 结果
     */
    public int updateLpUpkeep(LpUpkeep lpUpkeep);

    /**
     * 批量删除设备保养
     *
     * @param upkeepIds 需要删除的设备保养主键集合
     * @return 结果
     */
    public int deleteLpUpkeepByUpkeepIds(Long[] upkeepIds);

    /**
     * 删除设备保养信息
     *
     * @param upkeepId 设备保养主键
     * @return 结果
     */
    public int deleteLpUpkeepByUpkeepId(Long upkeepId);
    public int auditUpkeep(UpkeepVo upkeepVo);

    public int approverAdjunct(UpkeepVo upkeepVo);
    public LpUpkeep selectUpkeepLists(Long upkeepId);
}

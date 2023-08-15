package com.ruoyi.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.Vo.UpkeepVo;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.domain.LpFinance;
import com.ruoyi.mapper.LpFinanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.LpUpkeepMapper;
import com.ruoyi.domain.LpUpkeep;
import com.ruoyi.service.ILpUpkeepService;

/**
 * 设备保养Service业务层处理
 *
 * @author zjj
 * @date 2023-05-09
 */
@Service
public class LpUpkeepServiceImpl implements ILpUpkeepService
{
    @Autowired(required = false)
    private LpUpkeepMapper lpUpkeepMapper;
    @Autowired(required = false)
    private LpFinanceMapper lpFinanceMapper;

    /**
     * 查询设备保养
     *
     * @param upkeepId 设备保养主键
     * @return 设备保养
     */
    @Override
    public LpUpkeep selectLpUpkeepByUpkeepId(Long upkeepId)
    {
        return lpUpkeepMapper.selectLpUpkeepByUpkeepId(upkeepId);
    }

    /**
     * 查询设备保养列表
     *
     * @param lpUpkeep 设备保养
     * @return 设备保养
     */
    @Override
    public List<LpUpkeep> selectLpUpkeepList(LpUpkeep lpUpkeep)
    {
        return lpUpkeepMapper.selectLpUpkeepList(lpUpkeep);
    }

    /**
     * 新增设备保养
     *
     * @param lpUpkeep 设备保养
     * @return 结果
     */
    @Override
    public int insertLpUpkeep(LpUpkeep lpUpkeep)
    {
        lpUpkeep.setCreateTime(DateUtils.getNowDate());
        return lpUpkeepMapper.insertLpUpkeep(lpUpkeep);
    }

    /**
     * 修改设备保养
     *
     * @param lpUpkeep 设备保养
     * @return 结果
     */
    @Override
    public int updateLpUpkeep(LpUpkeep lpUpkeep)
    {
        lpUpkeep.setUpdateTime(DateUtils.getNowDate());
        return lpUpkeepMapper.updateLpUpkeep(lpUpkeep);
    }

    /**
     * 批量删除设备保养
     *
     * @param upkeepIds 需要删除的设备保养主键
     * @return 结果
     */
    @Override
    public int deleteLpUpkeepByUpkeepIds(Long[] upkeepIds)
    {
        return lpUpkeepMapper.deleteLpUpkeepByUpkeepIds(upkeepIds);
    }

    /**
     * 删除设备保养信息
     *
     * @param upkeepId 设备保养主键
     * @return 结果
     */
    @Override
    public int deleteLpUpkeepByUpkeepId(Long upkeepId)
    {
        return lpUpkeepMapper.deleteLpUpkeepByUpkeepId(upkeepId);
    }

    @Override
    public int auditUpkeep(UpkeepVo upkeepVo) {
        LpUpkeep upkeep = new LpUpkeep();
        upkeep.setUpkeepId(upkeepVo.getUpkeepId());
        upkeep.setAuditStatus(upkeepVo.getAuditStatus());
        upkeep.setAuditOpinion(upkeepVo.getAuditOpinion());
        upkeep.setAuditTime(new Date());
        upkeep.setAuditPerson(SecurityUtils.getUsername());

        return lpUpkeepMapper.updateLpUpkeep(upkeep);
    }

    @Override
    public int approverAdjunct(UpkeepVo upkeepVo) {
        LpUpkeep upkeep = new LpUpkeep();
        upkeep.setUpkeepId(upkeepVo.getUpkeepId());
        upkeep.setAuditStatus(upkeepVo.getAuditStatus());
        upkeep.setApproverOpinion(upkeepVo.getApproverOpinion());
        upkeep.setApproverTime(new Date());
        upkeep.setApproverPerson(SecurityUtils.getUsername());
        lpUpkeepMapper.updateLpUpkeep(upkeep);

        LpUpkeep  upk = lpUpkeepMapper.selectLpUpkeepByUpkeepId(upkeepVo.getUpkeepId());

        if(upk.getAuditStatus().intValue() == 2){
            LpFinance finance = new LpFinance();
            finance.setFinanceName("保养"+upk.getUpkeepName());
            finance.setFinanceMoney(upk.getUpkeepPrice());
            //TODO 建表少了供应商
            finance.setAuditStatus(0L);
            finance.setFinanceStatus(0L);
            //finance.setSupplierId(upk.);
            finance.setCreateBy("系统生成");
            finance.setCreateTime(new Date());
            return lpFinanceMapper.insertLpFinance(finance);
        }
        return 1;
    }

    @Override
    public LpUpkeep selectUpkeepLists(Long upkeepId) {
        return lpUpkeepMapper.selectUpkeepLists(upkeepId);
    }
}

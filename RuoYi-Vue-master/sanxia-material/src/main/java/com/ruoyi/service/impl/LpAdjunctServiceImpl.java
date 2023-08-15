package com.ruoyi.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.Vo.AdjunctVo;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.domain.LpFinance;
import com.ruoyi.mapper.LpFinanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.LpAdjunctMapper;
import com.ruoyi.domain.LpAdjunct;
import com.ruoyi.service.ILpAdjunctService;

/**
 * 设备附件Service业务层处理
 *
 * @author zjj
 * @date 2023-05-09
 */
@Service
public class LpAdjunctServiceImpl implements ILpAdjunctService
{
    @Autowired(required = false)
    private LpAdjunctMapper lpAdjunctMapper;
    @Autowired(required = false)
    private LpFinanceMapper lpFinanceMapper;

    /**
     * 查询设备附件
     *
     * @param adjunctId 设备附件主键
     * @return 设备附件
     */
    @Override
    public LpAdjunct selectAdjunctByAdjunctId(Long adjunctId)
    {
        return lpAdjunctMapper.selectAdjunctByAdjunctId(adjunctId);
    }

    /**
     * 查询设备附件列表
     *
     * @param lpAdjunct 设备附件
     * @return 设备附件
     */
    @Override
    public List<LpAdjunct> selectAdjunctList(LpAdjunct lpAdjunct)
    {
        return lpAdjunctMapper.selectAdjunctList(lpAdjunct);
    }

    /**
     * 新增设备附件
     *
     * @param lpAdjunct 设备附件
     * @return 结果
     */
    @Override
    public int insertAdjunct(LpAdjunct lpAdjunct)
    {
        lpAdjunct.setCreateTime(DateUtils.getNowDate());
        return lpAdjunctMapper.insertAdjunct(lpAdjunct);
    }

    /**
     * 修改设备附件
     *
     * @param lpAdjunct 设备附件
     * @return 结果
     */
    @Override
    public int updateAdjunct(LpAdjunct lpAdjunct)
    {
        lpAdjunct.setUpdateTime(DateUtils.getNowDate());
        return lpAdjunctMapper.updateAdjunct(lpAdjunct);
    }

    /**
     * 批量删除设备附件
     *
     * @param adjunctIds 需要删除的设备附件主键
     * @return 结果
     */
    @Override
    public int deleteAdjunctByAdjunctIds(Long[] adjunctIds)
    {
        return lpAdjunctMapper.deleteAdjunctByAdjunctIds(adjunctIds);
    }

    /**
     * 删除设备附件信息
     *
     * @param adjunctId 设备附件主键
     * @return 结果
     */
    @Override
    public int deleteAdjunctByAdjunctId(Long adjunctId)
    {
        return lpAdjunctMapper.deleteAdjunctByAdjunctId(adjunctId);
    }

    @Override
    public int auditAdjunct(AdjunctVo adjunctVo) {
        LpAdjunct adjunct = new LpAdjunct();
        adjunct.setAdjunctId(adjunctVo.getAdjunctId());
        adjunct.setAuditStatus(adjunctVo.getAuditStatus());
        adjunct.setAuditOpinion(adjunctVo.getAuditOpinion());
        adjunct.setAuditPerson(SecurityUtils.getUsername());
        adjunct.setAuditTime(new Date());
        return lpAdjunctMapper.updateAdjunct(adjunct);
    }

    @Override
    public int approverAdjunct(AdjunctVo adjunctVo) {
        LpAdjunct adjunct = new LpAdjunct();
        adjunct.setAdjunctId(adjunctVo.getAdjunctId());
        adjunct.setAuditStatus(adjunctVo.getAuditStatus());
        adjunct.setApproverOpinion(adjunctVo.getApproverOpinion());
        adjunct.setApproverPerson(SecurityUtils.getUsername());
        adjunct.setApproverTime(new Date());
        lpAdjunctMapper.updateAdjunct(adjunct);

        LpAdjunct adjunct1 = lpAdjunctMapper.selectAdjunctByAdjunctId(adjunctVo.getAdjunctId());

        if(adjunct1.getAuditStatus().intValue() == 2){
            LpFinance finance = new LpFinance();
            finance.setFinanceName("购买"+ adjunct1.getAdjunctName());
            finance.setFinanceMoney(adjunct1.getAdjunctPrice());
            finance.setSupplierId(adjunct1.getSupplierId());
            finance.setFinanceStatus(0L);//支出
            finance.setAuditStatus(0L);
            finance.setCreateTime(new Date());
            finance.setCreateBy("系统生成");
            return lpFinanceMapper.insertLpFinance(finance);

        }

        return 1;
    }
}

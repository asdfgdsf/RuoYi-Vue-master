package com.ruoyi.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.ruoyi.Vo.FinanceVo;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.apache.poi.ss.formula.functions.Finance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.LpFinanceMapper;
import com.ruoyi.domain.LpFinance;
import com.ruoyi.service.ILpFinanceService;

/**
 * 财务数据Service业务层处理
 *
 * @author zjj
 * @date 2023-05-09
 */
@Service
public class LpFinanceServiceImpl implements ILpFinanceService
{
    @Autowired(required = false)
    private LpFinanceMapper lpFinanceMapper;

    /**
     * 查询财务数据
     *
     * @param financeId 财务数据主键
     * @return 财务数据
     */
    @Override
    public LpFinance selectLpFinanceByFinanceId(Long financeId)
    {
        return lpFinanceMapper.selectLpFinanceByFinanceId(financeId);
    }

    /**
     * 查询财务数据列表
     *
     * @param lpFinance 财务数据
     * @return 财务数据
     */
    @Override
    public List<LpFinance> selectLpFinanceList(LpFinance lpFinance)
    {
        return lpFinanceMapper.selectLpFinanceList(lpFinance);
    }

    /**
     * 新增财务数据
     *
     * @param lpFinance 财务数据
     * @return 结果
     */
    @Override
    public int insertLpFinance(LpFinance lpFinance)
    {
        lpFinance.setCreateTime(DateUtils.getNowDate());
        return lpFinanceMapper.insertLpFinance(lpFinance);
    }

    /**
     * 修改财务数据
     *
     * @param lpFinance 财务数据
     * @return 结果
     */
    @Override
    public int updateLpFinance(LpFinance lpFinance)
    {
        lpFinance.setUpdateTime(DateUtils.getNowDate());
        return lpFinanceMapper.updateLpFinance(lpFinance);
    }

    /**
     * 批量删除财务数据
     *
     * @param financeIds 需要删除的财务数据主键
     * @return 结果
     */
    @Override
    public int deleteLpFinanceByFinanceIds(Long[] financeIds)
    {
        return lpFinanceMapper.deleteLpFinanceByFinanceIds(financeIds);
    }

    /**
     * 删除财务数据信息
     *
     * @param financeId 财务数据主键
     * @return 结果
     */
    @Override
    public int deleteLpFinanceByFinanceId(Long financeId)
    {
        return lpFinanceMapper.deleteLpFinanceByFinanceId(financeId);
    }

    @Override
    public int auditFinance(FinanceVo financeVo) {
        LpFinance finance = new LpFinance();
        finance.setFinanceId(financeVo.getFinanceId());
        finance.setAuditStatus(financeVo.getAuditStatus());
        finance.setAuditOpinion(financeVo.getAuditOpinion());
        finance.setAuditPerson(SecurityUtils.getUsername());
        finance.setAuditTime(new Date());
        return lpFinanceMapper.updateLpFinance(finance);
    }

    @Override
    public int approverFinance(FinanceVo financeVo) {
        LpFinance finance = new LpFinance();
        finance.setFinanceId(financeVo.getFinanceId());
        finance.setAuditStatus(financeVo.getAuditStatus());
        finance.setApproverOpinion(financeVo.getApproverOpinion());
        finance.setApproverTime(new Date());
        finance.setApproverPerson(SecurityUtils.getUsername());

        int num = lpFinanceMapper.updateLpFinance(finance);//这是审批操作

        if(num >0){

            LpFinance yu = lpFinanceMapper.selectfinanceBalance();//查出余额
            LpFinance finance1 = lpFinanceMapper.selectLpFinanceByFinanceId(financeVo.getFinanceId());//查对象
            if(finance1.getAuditStatus().intValue() == 2){

                double financeMoney = finance1.getFinanceMoney().doubleValue();//发生额数据
                double financeBalance = yu.getFinanceBalance().doubleValue();//余额
                double nums = financeBalance-financeMoney;//减掉余额赋值发生额
                BigDecimal financeBalance1 = new BigDecimal(nums);//
                finance1.setFinanceBalance(financeBalance1);
                return lpFinanceMapper.updateLpFinance(finance1);
            }
            ;//获得余额数据

        }

        return 1;
    }
}

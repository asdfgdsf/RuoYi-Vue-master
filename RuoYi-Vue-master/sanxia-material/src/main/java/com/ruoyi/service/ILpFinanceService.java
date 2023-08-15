package com.ruoyi.service;

import java.util.List;

import com.ruoyi.Vo.FinanceVo;
import com.ruoyi.domain.LpFinance;

/**
 * 财务数据Service接口
 *
 * @author zjj
 * @date 2023-05-09
 */
public interface ILpFinanceService
{
    /**
     * 查询财务数据
     *
     * @param financeId 财务数据主键
     * @return 财务数据
     */
    public LpFinance selectLpFinanceByFinanceId(Long financeId);

    /**
     * 查询财务数据列表
     *
     * @param lpFinance 财务数据
     * @return 财务数据集合
     */
    public List<LpFinance> selectLpFinanceList(LpFinance lpFinance);

    /**
     * 新增财务数据
     *
     * @param lpFinance 财务数据
     * @return 结果
     */
    public int insertLpFinance(LpFinance lpFinance);

    /**
     * 修改财务数据
     *
     * @param lpFinance 财务数据
     * @return 结果
     */
    public int updateLpFinance(LpFinance lpFinance);

    /**
     * 批量删除财务数据
     *
     * @param financeIds 需要删除的财务数据主键集合
     * @return 结果
     */
    public int deleteLpFinanceByFinanceIds(Long[] financeIds);

    /**
     * 删除财务数据信息
     *
     * @param financeId 财务数据主键
     * @return 结果
     */
    public int deleteLpFinanceByFinanceId(Long financeId);
    public int auditFinance(FinanceVo financeVo);

    public int approverFinance(FinanceVo financeVo);
}

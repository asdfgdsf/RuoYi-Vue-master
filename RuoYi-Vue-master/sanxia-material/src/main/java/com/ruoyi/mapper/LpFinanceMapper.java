package com.ruoyi.mapper;

import java.util.List;
import com.ruoyi.domain.LpFinance;
import org.apache.poi.ss.formula.functions.Finance;

/**
 * 财务数据Mapper接口
 *
 * @author zjj
 * @date 2023-05-09
 */
public interface LpFinanceMapper
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
     * 删除财务数据
     *
     * @param financeId 财务数据主键
     * @return 结果
     */
    public int deleteLpFinanceByFinanceId(Long financeId);

    /**
     * 批量删除财务数据
     *
     * @param financeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLpFinanceByFinanceIds(Long[] financeIds);
    public LpFinance getFinanceMoney();

    public LpFinance selectfinanceBalance();
}

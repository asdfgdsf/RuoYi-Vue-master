package com.ruoyi.mapper;

import java.util.List;
import com.ruoyi.domain.Market;

/**
 * marketMapper接口
 * 
 * @author jia
 * @date 2023-05-12
 */
public interface MarketMapper 
{
    /**
     * 查询market
     * 
     * @param marketId market主键
     * @return market
     */
    public Market selectMarketByMarketId(Integer marketId);

    /**
     * 查询market列表
     * 
     * @param market market
     * @return market集合
     */
    public List<Market> selectMarketList(Market market);

    /**
     * 新增market
     * 
     * @param market market
     * @return 结果
     */
    public int insertMarket(Market market);

    /**
     * 修改market
     * 
     * @param market market
     * @return 结果
     */
    public int updateMarket(Market market);

    /**
     * 删除market
     * 
     * @param marketId market主键
     * @return 结果
     */
    public int deleteMarketByMarketId(Integer marketId);

    /**
     * 批量删除market
     * 
     * @param marketIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMarketByMarketIds(Integer[] marketIds);
}

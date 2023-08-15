package com.ruoyi.service;

import java.util.List;
import com.ruoyi.domain.Shelf;

/**
 * 货架列Service接口
 * 
 * @author zjj
 * @date 2023-05-10
 */
public interface IShelfService 
{
    /**
     * 查询货架列
     * 
     * @param shelfId 货架列主键
     * @return 货架列
     */
    public Shelf selectShelfByShelfId(Long shelfId);

    /**
     * 查询货架列列表
     * 
     * @param shelf 货架列
     * @return 货架列集合
     */
    public List<Shelf> selectShelfList(Shelf shelf);

    /**
     * 新增货架列
     * 
     * @param shelf 货架列
     * @return 结果
     */
    public int insertShelf(Shelf shelf);

    /**
     * 修改货架列
     * 
     * @param shelf 货架列
     * @return 结果
     */
    public int updateShelf(Shelf shelf);

    /**
     * 批量删除货架列
     * 
     * @param shelfIds 需要删除的货架列主键集合
     * @return 结果
     */
    public int deleteShelfByShelfIds(Long[] shelfIds);

    /**
     * 删除货架列信息
     * 
     * @param shelfId 货架列主键
     * @return 结果
     */
    public int deleteShelfByShelfId(Long shelfId);
}

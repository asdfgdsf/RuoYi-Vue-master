package com.ruoyi.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.ShelfMapper;
import com.ruoyi.domain.Shelf;
import com.ruoyi.service.IShelfService;

/**
 * 货架列Service业务层处理
 * 
 * @author zjj
 * @date 2023-05-10
 */
@Service
public class ShelfServiceImpl implements IShelfService 
{
    @Autowired
    private ShelfMapper shelfMapper;

    /**
     * 查询货架列
     * 
     * @param shelfId 货架列主键
     * @return 货架列
     */
    @Override
    public Shelf selectShelfByShelfId(Long shelfId)
    {
        return shelfMapper.selectShelfByShelfId(shelfId);
    }

    /**
     * 查询货架列列表
     * 
     * @param shelf 货架列
     * @return 货架列
     */
    @Override
    public List<Shelf> selectShelfList(Shelf shelf)
    {
        return shelfMapper.selectShelfList(shelf);
    }

    /**
     * 新增货架列
     * 
     * @param shelf 货架列
     * @return 结果
     */
    @Override
    public int insertShelf(Shelf shelf)
    {
        shelf.setCreateTime(DateUtils.getNowDate());
        return shelfMapper.insertShelf(shelf);
    }

    /**
     * 修改货架列
     * 
     * @param shelf 货架列
     * @return 结果
     */
    @Override
    public int updateShelf(Shelf shelf)
    {
        shelf.setUpdateTime(DateUtils.getNowDate());
        return shelfMapper.updateShelf(shelf);
    }

    /**
     * 批量删除货架列
     * 
     * @param shelfIds 需要删除的货架列主键
     * @return 结果
     */
    @Override
    public int deleteShelfByShelfIds(Long[] shelfIds)
    {
        return shelfMapper.deleteShelfByShelfIds(shelfIds);
    }

    /**
     * 删除货架列信息
     * 
     * @param shelfId 货架列主键
     * @return 结果
     */
    @Override
    public int deleteShelfByShelfId(Long shelfId)
    {
        return shelfMapper.deleteShelfByShelfId(shelfId);
    }
}

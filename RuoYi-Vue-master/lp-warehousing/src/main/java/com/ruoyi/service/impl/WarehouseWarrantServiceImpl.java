package com.ruoyi.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.Vo.WarehouseWarrantVo;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.domain.Inventory;
import com.ruoyi.domain.LpFinance;
import com.ruoyi.mapper.InventoryMapper;
import com.ruoyi.mapper.LpFinanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.WarehouseWarrantMapper;
import com.ruoyi.domain.WarehouseWarrant;
import com.ruoyi.service.IWarehouseWarrantService;

/**
 * 入库列Service业务层处理
 *
 * @author zjj
 * @date 2023-05-10
 */
@Service
public class WarehouseWarrantServiceImpl implements IWarehouseWarrantService
{
    @Autowired(required = false)
    private WarehouseWarrantMapper warehouseWarrantMapper;
    @Autowired(required = false)
    private InventoryMapper inventoryMapper;
    @Autowired(required = false)
    private LpFinanceMapper financeMapper;

    /**
     * 查询入库列
     *
     * @param warehouseWarrantId 入库列主键
     * @return 入库列
     */
    @Override
    public WarehouseWarrant selectWarehouseWarrantByWarehouseWarrantId(Long warehouseWarrantId)
    {
        return warehouseWarrantMapper.selectWarehouseWarrantByWarehouseWarrantId(warehouseWarrantId);
    }

    /**
     * 查询入库列列表
     *
     * @param warehouseWarrant 入库列
     * @return 入库列
     */
    @Override
    public List<WarehouseWarrant> selectWarehouseWarrantList(WarehouseWarrant warehouseWarrant)
    {
        return warehouseWarrantMapper.selectWarehouseWarrantList(warehouseWarrant);
    }

    /**
     * 新增入库列
     *
     * @param warehouseWarrant 入库列
     * @return 结果
     */
    @Override
    public int insertWarehouseWarrant(WarehouseWarrant warehouseWarrant)
    {
        warehouseWarrant.setCreateTime(DateUtils.getNowDate());
        return warehouseWarrantMapper.insertWarehouseWarrant(warehouseWarrant);
    }

    /**
     * 修改入库列
     *
     * @param warehouseWarrant 入库列
     * @return 结果
     */
    @Override
    public int updateWarehouseWarrant(WarehouseWarrant warehouseWarrant)
    {
        warehouseWarrant.setUpdateTime(DateUtils.getNowDate());
        return warehouseWarrantMapper.updateWarehouseWarrant(warehouseWarrant);
    }

    /**
     * 批量删除入库列
     *
     * @param warehouseWarrantIds 需要删除的入库列主键
     * @return 结果
     */
    @Override
    public int deleteWarehouseWarrantByWarehouseWarrantIds(Long[] warehouseWarrantIds)
    {
        return warehouseWarrantMapper.deleteWarehouseWarrantByWarehouseWarrantIds(warehouseWarrantIds);
    }

    /**
     * 删除入库列信息
     *
     * @param warehouseWarrantId 入库列主键
     * @return 结果
     */
    @Override
    public int deleteWarehouseWarrantByWarehouseWarrantId(Long warehouseWarrantId)
    {
        return warehouseWarrantMapper.deleteWarehouseWarrantByWarehouseWarrantId(warehouseWarrantId);
    }

    @Override
    public int auditWarehouseWarrant(WarehouseWarrantVo warehouseWarrantVo) {
        WarehouseWarrant warehouseWarrant = new WarehouseWarrant();
        warehouseWarrant.setWarehouseWarrantId(warehouseWarrantVo.getWarehouseWarrantId());
        warehouseWarrant.setAuditStatus(warehouseWarrantVo.getAuditStatus());
        warehouseWarrant.setAuditOpinion(warehouseWarrantVo.getAuditOpinion());
        warehouseWarrant.setAuditPerson(SecurityUtils.getUsername());
        warehouseWarrant.setAuditTime(new Date());
        return warehouseWarrantMapper.updateWarehouseWarrant(warehouseWarrant);
    }

    @Override
    public int approverWarehouseWarrant(WarehouseWarrantVo warehouseWarrantVo) {
        WarehouseWarrant warehouseWarrant = new WarehouseWarrant();
        warehouseWarrant.setWarehouseWarrantId(warehouseWarrantVo.getWarehouseWarrantId());//ID
        warehouseWarrant.setAuditStatus(warehouseWarrantVo.getAuditStatus());//状态
        warehouseWarrant.setApproverOpinion(warehouseWarrantVo.getApproverOpinion());//意见
        warehouseWarrant.setApproverTime(new Date());
        warehouseWarrant.setApproverPerson(SecurityUtils.getUsername());
        warehouseWarrantMapper.updateWarehouseWarrant(warehouseWarrant);
        WarehouseWarrant ware = warehouseWarrantMapper.selectWarehouseWarrantByWarehouseWarrantId(warehouseWarrantVo.getWarehouseWarrantId());

        if(ware.getAuditStatus().intValue() == 2){
            //第一步创建财务数据
            LpFinance finance = new LpFinance();
            finance.setFinanceName("采购"+ware.getWarehouseWarrantName());
            finance.setFinanceMoney(ware.getWarehouseWarrantPrice());
            finance.setFinanceStatus(0L);
            finance.setAuditStatus(0L);
            finance.setCreateTime(new Date());
            finance.setCreateBy("系统生成");
            financeMapper.insertLpFinance(finance);
            //创建库存数据
            Inventory inventory = new Inventory();
            inventory.setInventoryName(ware.getWarehouseWarrantName());
            inventory.setInventoryNum(ware.getWarehouseWarrantNum());
            inventory.setInventoryPrice(ware.getWarehouseWarrantPrice());
            inventory.setInventoryUnit(ware.getUnit());
            inventory.setWarehouseWarrantId(ware.getWarehouseWarrantId());
            inventory.setCreateTime(new Date());
            inventory.setCreateBy("系统生成");
            inventoryMapper.insertInventory(inventory);

        }


        return 1;
    }
}

package com.ruoyi.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.Vo.ClientVo;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.ClientMapper;
import com.ruoyi.domain.Client;
import com.ruoyi.service.IClientService;

/**
 * 客户列表Service业务层处理
 *
 * @author jia
 * @date 2023-05-12
 */
@Service
public class ClientServiceImpl implements IClientService
{
    @Autowired(required = false)
    private ClientMapper clientMapper;

    /**
     * 查询客户列表
     *
     * @param clientId 客户列表主键
     * @return 客户列表
     */
    @Override
    public Client selectClientByClientId(Integer clientId)
    {
        return clientMapper.selectClientByClientId(clientId);
    }

    /**
     * 查询客户列表列表
     *
     * @param client 客户列表
     * @return 客户列表
     */
    @Override
    public List<Client> selectClientList(Client client)
    {
        return clientMapper.selectClientList(client);
    }

    /**
     * 新增客户列表
     *
     * @param client 客户列表
     * @return 结果
     */
    @Override
    public int insertClient(Client client)
    {
        client.setCreateTime(DateUtils.getNowDate());
        return clientMapper.insertClient(client);
    }

    /**
     * 修改客户列表
     *
     * @param client 客户列表
     * @return 结果
     */
    @Override
    public int updateClient(Client client)
    {
        client.setUpdateTime(DateUtils.getNowDate());
        return clientMapper.updateClient(client);
    }

    /**
     * 批量删除客户列表
     *
     * @param clientIds 需要删除的客户列表主键
     * @return 结果
     */
    @Override
    public int deleteClientByClientIds(Integer[] clientIds)
    {
        return clientMapper.deleteClientByClientIds(clientIds);
    }

    /**
     * 删除客户列表信息
     *
     * @param clientId 客户列表主键
     * @return 结果
     */
    @Override
    public int deleteClientByClientId(Integer clientId)
    {
        return clientMapper.deleteClientByClientId(clientId);
    }

    @Override
    public int auditClient(ClientVo clientVo) {
        Client client = new Client();
        client.setClientId(clientVo.getClientId());
        client.setAuditStatus(clientVo.getAuditStatus());
        client.setAuditOpinion(clientVo.getAuditOpinion());
        client.setAuditTime(new Date());
        client.setAuditPerson(SecurityUtils.getUsername());

        return clientMapper.updateClient(client);
    }

    @Override
    public int approverClient(ClientVo clientVo) {
        Client client = new Client();
        client.setClientId(clientVo.getClientId());
        client.setAuditStatus(clientVo.getAuditStatus());
        client.setApproverOpinion(clientVo.getApproverOpinion());
        client.setApproverTime(new Date());
        client.setApproverPerson(SecurityUtils.getUsername());

        return clientMapper.updateClient(client);
    }

}

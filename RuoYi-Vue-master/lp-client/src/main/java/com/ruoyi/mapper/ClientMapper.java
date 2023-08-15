package com.ruoyi.mapper;

import java.util.List;
import com.ruoyi.domain.Client;

/**
 * 客户列表Mapper接口
 * 
 * @author jia
 * @date 2023-05-12
 */
public interface ClientMapper 
{
    /**
     * 查询客户列表
     * 
     * @param clientId 客户列表主键
     * @return 客户列表
     */
    public Client selectClientByClientId(Integer clientId);

    /**
     * 查询客户列表列表
     * 
     * @param client 客户列表
     * @return 客户列表集合
     */
    public List<Client> selectClientList(Client client);

    /**
     * 新增客户列表
     * 
     * @param client 客户列表
     * @return 结果
     */
    public int insertClient(Client client);

    /**
     * 修改客户列表
     * 
     * @param client 客户列表
     * @return 结果
     */
    public int updateClient(Client client);

    /**
     * 删除客户列表
     * 
     * @param clientId 客户列表主键
     * @return 结果
     */
    public int deleteClientByClientId(Integer clientId);

    /**
     * 批量删除客户列表
     * 
     * @param clientIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClientByClientIds(Integer[] clientIds);
}

package com.ruoyi.mapper;

import java.util.List;
import com.ruoyi.domain.ClientClassify;

/**
 * 客户分类Mapper接口
 * 
 * @author jia
 * @date 2023-05-12
 */
public interface ClientClassifyMapper 
{
    /**
     * 查询客户分类
     * 
     * @param clientClassifyId 客户分类主键
     * @return 客户分类
     */
    public ClientClassify selectClientClassifyByClientClassifyId(Integer clientClassifyId);

    /**
     * 查询客户分类列表
     * 
     * @param clientClassify 客户分类
     * @return 客户分类集合
     */
    public List<ClientClassify> selectClientClassifyList(ClientClassify clientClassify);

    /**
     * 新增客户分类
     * 
     * @param clientClassify 客户分类
     * @return 结果
     */
    public int insertClientClassify(ClientClassify clientClassify);

    /**
     * 修改客户分类
     * 
     * @param clientClassify 客户分类
     * @return 结果
     */
    public int updateClientClassify(ClientClassify clientClassify);

    /**
     * 删除客户分类
     * 
     * @param clientClassifyId 客户分类主键
     * @return 结果
     */
    public int deleteClientClassifyByClientClassifyId(Integer clientClassifyId);

    /**
     * 批量删除客户分类
     * 
     * @param clientClassifyIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClientClassifyByClientClassifyIds(Integer[] clientClassifyIds);
}

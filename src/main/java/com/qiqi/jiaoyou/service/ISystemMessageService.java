package com.qiqi.jiaoyou.service;

import com.qiqi.jiaoyou.pojo.SystemMessage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qiqi.jiaoyou.util.ResultUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 系统消息表 服务类
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
public interface ISystemMessageService extends IService<SystemMessage> {

    /**
     * 查询系统消息表分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map);

    /**
     * 添加系统消息表
     *
     * @param systemMessage 系统消息表
     * @return ResultUtils
     */
    ResultUtils add(SystemMessage systemMessage);

    /**
     * 删除系统消息表
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Long id);

    /**
     * 修改系统消息表
     *
     * @param systemMessage 系统消息表
     * @return ResultUtils
     */
    ResultUtils updateData(SystemMessage systemMessage);

    /**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);

    /**
     * 修改启用状态
     */
    ResultUtils updateEnable(Integer id, Integer enableState);
}

package com.qiqi.jiaoyou.service;

import com.qiqi.jiaoyou.pojo.ServerInfoManager;
import com.qiqi.jiaoyou.util.ResultUtils;

import java.util.Map;

/**
 * 服务管理信息表(ServerInfoManager)表服务接口
 *
 * @author makejava
 * @since 2020-12-01 17:19:32
 */
public interface ServerInfoManagerService {

      /**
     * 查询表分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit, Map<String,String> map);
/**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);


    /**
     * 置顶操作
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils utop(Long id);


/**
     * 取消置顶
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils ntop(Long id);
/**
     *
     * 添加
     *
     * @param  serverInfoManager
     * @return ResultUtils
     */
    ResultUtils add(ServerInfoManager serverInfoManager);
    /**
     * 删除
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Long id);

    /**
     * 修改
     *
     * @param serverInfoManager
     * @return ResultUtils
     */
    ResultUtils updateData(ServerInfoManager serverInfoManager);
}
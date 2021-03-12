package com.qiqi.jiaoyou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiqi.jiaoyou.pojo.ServerInfoType;
import com.qiqi.jiaoyou.util.ResultUtils;

import java.util.List;
import java.util.Map;

/**
 * 服务信息管理类型表(ServerInfoType)表服务接口
 *
 * @author makejava
 * @since 2020-12-01 17:35:55
 */
public interface ServerInfoTypeService extends IService<ServerInfoType> {
 /**
     *
     * 添加礼物表
     *
     * @param  serverInfoType 礼物表
     * @return ResultUtils
     */
    ResultUtils add(ServerInfoType serverInfoType);
/**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);
    /**
     * 删除礼物表
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Long id);

    /**
     * 不啰嗦直接获取所有信息
     * @return
     */
    List<ServerInfoType> getAllInfo();
    /**
     * 修改礼物表
     *
     * @param serverInfoType 礼物表
     * @return ResultUtils
     */
    ResultUtils updateData(ServerInfoType serverInfoType);


      /**
     * 查询礼物表分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit, Map<String,String> map);
}
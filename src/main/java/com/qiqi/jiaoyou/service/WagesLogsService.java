package com.qiqi.jiaoyou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiqi.jiaoyou.pojo.WagesLogs;
import com.qiqi.jiaoyou.util.ResultUtils;

import java.util.Map;

/**
 * 工资记录表(WagesLogs)表服务接口
 *
 * @author makejava
 * @since 2020-12-14 19:01:35
 */
public interface WagesLogsService extends IService<WagesLogs> {
  /**
     * 查询礼物表分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit, Map<String,String> map);
}
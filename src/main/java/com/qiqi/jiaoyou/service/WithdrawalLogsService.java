package com.qiqi.jiaoyou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiqi.jiaoyou.pojo.WithdrawalLogs;
import com.qiqi.jiaoyou.util.ResultUtils;

import java.util.Map;

/**
 * 金钻银钻兑换记录表(WithdrawalLogs)表服务接口
 *
 * @author makejava
 * @since 2020-12-14 09:32:34
 */
public interface WithdrawalLogsService extends IService<WithdrawalLogs> {
    /**
     * 查询礼物表分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit, Map<String,String> map);
}
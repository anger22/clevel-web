package com.qiqi.jiaoyou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiqi.jiaoyou.pojo.LoveHeartDonationLogs;
import com.qiqi.jiaoyou.util.ResultUtils;

/**
 * (LoveHeartDonationLogs)表服务接口
 *
 * @author makejava
 * @since 2020-12-01 11:02:15
 */
public interface LoveHeartDonationLogsService extends IService<LoveHeartDonationLogs> {
/**
     * 查询爱心捐赠捐赠记录分页数*
     * @param page      页码
     * @param limit 每页条数
     * @param  userId
     * @return ResultUtils
     */
    ResultUtils findListByLogs(Integer page, Integer limit, Integer userId);
}
package com.qiqi.jiaoyou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiqi.jiaoyou.pojo.SendOfflineActivities;
import com.qiqi.jiaoyou.util.ResultUtils;

import java.util.Map;


/**
 * <p>
 * 线下活动列表 服务类
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
public interface ISendOfflineActivitiesService extends IService<SendOfflineActivities> {

    ResultUtils findListByPage(Integer page, Integer limit, Map<String, String> map);

    ResultUtils updateData(SendOfflineActivities sendOfflineActivities);

    /*根据id获取一条数据的详情信息*/
    SendOfflineActivities getReadById(Integer id);
}

package com.qiqi.jiaoyou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qiqi.jiaoyou.config.MybatisRedisCache;
import com.qiqi.jiaoyou.pojo.SendOfflineActivities;
import org.apache.ibatis.annotations.CacheNamespace;

/**
 * <p>
 * 线下活动列表 Mapper 接口
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */

public interface SendOfflineActivitiesMapper extends BaseMapper<SendOfflineActivities> {

}

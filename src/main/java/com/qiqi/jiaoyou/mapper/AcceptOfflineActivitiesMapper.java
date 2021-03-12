package com.qiqi.jiaoyou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qiqi.jiaoyou.config.MybatisRedisCache;
import com.qiqi.jiaoyou.pojo.AcceptOfflineActivities;
import com.qiqi.jiaoyou.vo.AcceptOfflineActivitiesVo;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.Date;


/**
 * <p>
 * 线下活动列表 Mapper 接口
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */

public interface AcceptOfflineActivitiesMapper extends BaseMapper<AcceptOfflineActivities> {
    IPage<AcceptOfflineActivitiesVo> joinList(IPage<AcceptOfflineActivities> page, @Param("name") String name, @Param("theme") String theme, @Param("time") Date time, @Param("status") Integer status);
}

package com.qiqi.jiaoyou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qiqi.jiaoyou.config.MybatisRedisCache;
import com.qiqi.jiaoyou.pojo.Report;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author slq
 * @since 2020-07-13
 */

public interface ReportMapper extends BaseMapper<Report> {
}


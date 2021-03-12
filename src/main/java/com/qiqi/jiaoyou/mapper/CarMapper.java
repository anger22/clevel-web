package com.qiqi.jiaoyou.mapper;

import com.qiqi.jiaoyou.config.MybatisRedisCache;
import com.qiqi.jiaoyou.pojo.Car;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.CacheNamespace;

/**
 * <p>
 * 车辆表 Mapper 接口
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */

public interface CarMapper extends BaseMapper<Car> {

}

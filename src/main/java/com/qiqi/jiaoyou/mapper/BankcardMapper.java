package com.qiqi.jiaoyou.mapper;

import com.qiqi.jiaoyou.config.MybatisRedisCache;
import com.qiqi.jiaoyou.pojo.Bankcard;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.CacheNamespace;

/**
 * <p>
 * 银行卡表 Mapper 接口
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */

public interface BankcardMapper extends BaseMapper<Bankcard> {

}

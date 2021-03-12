package com.qiqi.jiaoyou.mapper;

import com.qiqi.jiaoyou.config.MybatisRedisCache;
import com.qiqi.jiaoyou.pojo.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.CacheNamespace;

/**
 * <p>
 * 后台管理员表 Mapper 接口
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
public interface AccountMapper extends BaseMapper<Account> {

}

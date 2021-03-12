package com.qiqi.jiaoyou.service;

import com.qiqi.jiaoyou.config.MybatisRedisCache;
import com.qiqi.jiaoyou.pojo.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qiqi.jiaoyou.util.ResultUtils;
import org.apache.ibatis.annotations.CacheNamespace;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */

public interface IMenuService extends IService<Menu> {

    /**
     * 查询菜单表分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map);

    /**
     * 添加菜单表
     *
     * @param menu 菜单表
     * @return ResultUtils
     */
    ResultUtils add(Menu menu);

    /**
     * 删除菜单表
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Long id);

    /**
     * 修改菜单表
     *
     * @param menu 菜单表
     * @return ResultUtils
     */
    ResultUtils updateData(Menu menu);

    /**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);

    /**
     * 查询所有一级菜单
     * @return
     */
    ResultUtils selectLevelIsOne();

    /**
     * 根据一级菜单 查询二级菜单
     * @param id
     * @return
     */
    ResultUtils selectLevelIsTwo(Long id);

    /**
     * 查询所有一及以及二级
     * @return
     */
    ResultUtils selectLevelIsOneAndTwo();
}

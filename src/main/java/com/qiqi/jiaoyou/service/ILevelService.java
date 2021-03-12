package com.qiqi.jiaoyou.service;

import com.qiqi.jiaoyou.pojo.Level;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qiqi.jiaoyou.util.ResultUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 等级表 服务类
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
public interface ILevelService extends IService<Level> {

    /**
     * 查询等级表分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map);

    /**
     * 添加等级表
     *
     * @param level 等级表
     * @return ResultUtils
     */
    ResultUtils add(Level level);

    /**
     * 删除等级表
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Long id);

    /**
     * 修改等级表
     *
     * @param level 等级表
     * @return ResultUtils
     */
    ResultUtils updateData(Level level);

    /**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);
}

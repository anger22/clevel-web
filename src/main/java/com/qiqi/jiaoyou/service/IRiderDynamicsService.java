package com.qiqi.jiaoyou.service;

import com.qiqi.jiaoyou.pojo.RiderDynamics;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qiqi.jiaoyou.util.ResultUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 车友圈动态 服务类
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
public interface IRiderDynamicsService extends IService<RiderDynamics> {

    /**
     * 查询车友圈动态分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map);

    /**
     * 添加车友圈动态
     *
     * @param riderDynamics 车友圈动态
     * @return ResultUtils
     */
    ResultUtils add(RiderDynamics riderDynamics);

    /**
     * 删除车友圈动态
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Long id);

    /**
     * 修改车友圈动态
     *
     * @param riderDynamics 车友圈动态
     * @return ResultUtils
     */
    ResultUtils updateData(RiderDynamics riderDynamics);

    /**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);
}

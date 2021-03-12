package com.qiqi.jiaoyou.service;

import com.qiqi.jiaoyou.pojo.Car;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qiqi.jiaoyou.util.ResultUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 车辆表 服务类
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
public interface ICarService extends IService<Car> {

    /**
     * 查询车辆表分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map);

    /**
     * 添加车辆表
     *
     * @param car 车辆表
     * @return ResultUtils
     */
    ResultUtils add(Car car);

    /**
     * 删除车辆表
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Long id);

    /**
     * 修改车辆表
     *
     * @param car 车辆表
     * @return ResultUtils
     */
    ResultUtils updateData(Car car);

    /**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);
}

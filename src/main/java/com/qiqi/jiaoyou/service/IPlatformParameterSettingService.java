package com.qiqi.jiaoyou.service;

import com.qiqi.jiaoyou.pojo.PlatformParameterSetting;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qiqi.jiaoyou.util.ResultUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 平台参数设置 服务类
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
public interface IPlatformParameterSettingService extends IService<PlatformParameterSetting> {

    /**
     * 查询平台参数设置分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map);

    /**
     * 添加平台参数设置
     *
     * @param platformParameterSetting 平台参数设置
     * @return ResultUtils
     */
    ResultUtils add(PlatformParameterSetting platformParameterSetting);

    /**
     * 删除平台参数设置
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Long id);

    /**
     * 修改平台参数设置
     *
     * @param platformParameterSetting 平台参数设置
     * @return ResultUtils
     */
    ResultUtils updateData(PlatformParameterSetting platformParameterSetting);

    /**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);
}

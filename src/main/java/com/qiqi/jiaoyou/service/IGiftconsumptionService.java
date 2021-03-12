package com.qiqi.jiaoyou.service;

import com.qiqi.jiaoyou.pojo.Giftconsumption;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qiqi.jiaoyou.util.ResultUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 礼物记录表 服务类
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
public interface IGiftconsumptionService extends IService<Giftconsumption> {

    /**
     * 查询礼物记录表分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map);

    /**
     * 添加礼物记录表
     *
     * @param giftconsumption 礼物记录表
     * @return ResultUtils
     */
    ResultUtils add(Giftconsumption giftconsumption);

    /**
     * 删除礼物记录表
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Long id);

    /**
     * 修改礼物记录表
     *
     * @param giftconsumption 礼物记录表
     * @return ResultUtils
     */
    ResultUtils updateData(Giftconsumption giftconsumption);

    /**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);
}

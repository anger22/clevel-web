package com.qiqi.jiaoyou.service;

import com.qiqi.jiaoyou.pojo.RechargeRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qiqi.jiaoyou.util.ResultUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 充值记录 服务类
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
public interface IRechargeRecordService extends IService<RechargeRecord> {

    /**
     * 查询充值记录分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map);

    /**
     * 添加充值记录
     *
     * @param rechargeRecord 充值记录
     * @return ResultUtils
     */
    ResultUtils add(RechargeRecord rechargeRecord);

    /**
     * 删除充值记录
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Long id);

    /**
     * 修改充值记录
     *
     * @param rechargeRecord 充值记录
     * @return ResultUtils
     */
    ResultUtils updateData(RechargeRecord rechargeRecord);

    /**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);
}

package com.qiqi.jiaoyou.service;

import com.qiqi.jiaoyou.pojo.Proportionofwithdrawal;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qiqi.jiaoyou.util.ResultUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 提现比例表 服务类
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
public interface IProportionofwithdrawalService extends IService<Proportionofwithdrawal> {

    /**
     * 查询提现比例表分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map);

    /**
     * 添加提现比例表
     *
     * @param proportionofwithdrawal 提现比例表
     * @return ResultUtils
     */
    ResultUtils add(Proportionofwithdrawal proportionofwithdrawal);

    /**
     * 删除提现比例表
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Long id);

    /**
     * 修改提现比例表
     *
     * @param proportionofwithdrawal 提现比例表
     * @return ResultUtils
     */
    ResultUtils updateData(Proportionofwithdrawal proportionofwithdrawal);

    /**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);
}

package com.qiqi.jiaoyou.service;

import com.qiqi.jiaoyou.pojo.Withdraw;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qiqi.jiaoyou.util.ResultUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 提现申请表 服务类
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
public interface IWithdrawService extends IService<Withdraw> {

    /**
     * 查询提现申请表分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map);

    /**
     * 添加提现申请表
     *
     * @param withdraw 提现申请表
     * @return ResultUtils
     */
    ResultUtils add(Withdraw withdraw);

    /**
     * 删除提现申请表
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Long id);

    /**
     * 修改提现申请表
     *
     * @param withdraw 提现申请表
     * @return ResultUtils
     */
    ResultUtils updateData(Withdraw withdraw);

    /**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);
}

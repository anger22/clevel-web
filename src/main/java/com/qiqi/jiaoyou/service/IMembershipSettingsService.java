package com.qiqi.jiaoyou.service;

import com.qiqi.jiaoyou.pojo.MembershipSettings;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qiqi.jiaoyou.util.ResultUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 会员设置表 服务类
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
public interface IMembershipSettingsService extends IService<MembershipSettings> {

    /**
     * 查询会员设置表分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map);

    /**
     * 添加会员设置表
     *
     * @param membershipSettings 会员设置表
     * @return ResultUtils
     */
    ResultUtils add(MembershipSettings membershipSettings);

    /**
     * 删除会员设置表
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Long id);

    /**
     * 修改会员设置表
     *
     * @param membershipSettings 会员设置表
     * @return ResultUtils
     */
    ResultUtils updateData(MembershipSettings membershipSettings);

    /**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);
}

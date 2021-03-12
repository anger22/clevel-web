package com.qiqi.jiaoyou.service;

import com.qiqi.jiaoyou.pojo.Agreement;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qiqi.jiaoyou.util.ResultUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 协议表 服务类
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
public interface IAgreementService extends IService<Agreement> {

    /**
     * 查询协议表分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map);

    /**
     * 添加协议表
     *
     * @param agreement 协议表
     * @return ResultUtils
     */
    ResultUtils add(Agreement agreement);

    /**
     * 删除协议表
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Long id);

    /**
     * 修改协议表
     *
     * @param agreement 协议表
     * @return ResultUtils
     */
    ResultUtils updateData(Agreement agreement);

    /**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);
}

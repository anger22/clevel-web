package com.qiqi.jiaoyou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiqi.jiaoyou.pojo.OrderManage;
import com.qiqi.jiaoyou.util.ResultUtils;

import java.util.Map;

/**
 * 订单信息表(OrderManage)表服务接口
 *
 * @author nan
 * @since 2020-12-03 15:38:17
 */
public interface OrderManageService extends IService<OrderManage> {
/**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);


   /**
     * 查询表分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit, Map<String,String> map);


    /**
     * 更新订单信息
     * @param orderManage
     * @return
     */
   Boolean updateInfo(OrderManage orderManage);


}




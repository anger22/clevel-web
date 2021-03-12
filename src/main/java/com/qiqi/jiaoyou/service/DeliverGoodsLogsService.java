package com.qiqi.jiaoyou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiqi.jiaoyou.pojo.DeliverGoodsLogs;
import com.qiqi.jiaoyou.util.ResultUtils;

/**
 * 发货记录表(DeliverGoodsLogs)表服务接口
 *
 * @author nan
 * @since 2020-12-08 13:59:41
 */

public interface DeliverGoodsLogsService extends IService<DeliverGoodsLogs> {


   ResultUtils add(DeliverGoodsLogs deliverGoodsLogs);

}
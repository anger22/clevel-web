package com.qiqi.jiaoyou.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.mapper.AdvanceOrderDao;
import com.qiqi.jiaoyou.pojo.AdvanceOrder;
import com.qiqi.jiaoyou.service.AdvanceOrderService;
import org.springframework.stereotype.Service;

/**
 * (AdvanceOrder)表服务实现类
 *
 * @author makejava
 * @since 2021-01-08 02:43:51
 */
@Service("advanceOrderService")
public class AdvanceOrderServiceImpl extends ServiceImpl<AdvanceOrderDao, AdvanceOrder> implements AdvanceOrderService {

}
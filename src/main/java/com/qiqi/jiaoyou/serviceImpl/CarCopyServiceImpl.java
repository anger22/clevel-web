package com.qiqi.jiaoyou.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.mapper.CarCopyDao;
import com.qiqi.jiaoyou.pojo.CarCopy;
import com.qiqi.jiaoyou.service.CarCopyService;
import org.springframework.stereotype.Service;

/**
 * 车辆表(CarCopy)表服务实现类
 *
 * @author makejava
 * @since 2020-12-23 17:26:58
 */
@Service("carCopyService")
public class CarCopyServiceImpl extends ServiceImpl<CarCopyDao, CarCopy> implements CarCopyService {

}
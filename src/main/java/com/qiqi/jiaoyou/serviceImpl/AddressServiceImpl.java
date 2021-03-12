package com.qiqi.jiaoyou.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.mapper.AddressDao;
import com.qiqi.jiaoyou.pojo.Address;
import com.qiqi.jiaoyou.service.AddressService;
import org.springframework.stereotype.Service;

/**
 * 地址管理表(Address)表服务实现类
 *
 * @author makejava
 * @since 2020-12-03 16:59:09
 */
@Service("addressService")
public class AddressServiceImpl extends ServiceImpl<AddressDao, Address> implements AddressService {

}
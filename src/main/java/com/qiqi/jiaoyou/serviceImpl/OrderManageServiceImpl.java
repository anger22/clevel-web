package com.qiqi.jiaoyou.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.mapper.AddressDao;
import com.qiqi.jiaoyou.mapper.MemberMapper;
import com.qiqi.jiaoyou.mapper.OrderManageDao;
import com.qiqi.jiaoyou.pojo.Address;
import com.qiqi.jiaoyou.pojo.Member;
import com.qiqi.jiaoyou.pojo.OrderManage;
import com.qiqi.jiaoyou.service.OrderManageService;
import com.qiqi.jiaoyou.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * 订单信息表(OrderManage)表服务实现类
 *
 * @author nan
 * @since 2020-12-03 15:38:18
 */
@Service("orderManageService")
public class OrderManageServiceImpl extends ServiceImpl<OrderManageDao, OrderManage> implements OrderManageService {

	@Autowired
	private MemberMapper memberDao;
	@Autowired
	private AddressDao addressDao;
    @Override
    public ResultUtils findById(Long id) {
        ResultUtils resultUtils = new ResultUtils();
		OrderManage obj = baseMapper.selectById(id);


		QueryWrapper<Member> wrapper1 = new QueryWrapper<>();
				wrapper1.eq("id",obj.getUserId());
				Member member = memberDao.selectOne(wrapper1);

				QueryWrapper<Address> wrapper2 = new QueryWrapper<>();
				wrapper2.eq("address_id",obj.getOrderAddressId());
				Address address = addressDao.selectOne(wrapper2);

				/*设置用户信息*/
				if(member != null && !member.equals(null)){
				obj.setUserNickName(member.getNickName());
				obj.setHeadImg(member.getHead());
				obj.setUserPhone(member.getPhone());
				}

				if(address != null && !address.equals(null) ){
					obj.setReceverPeopleName(address.getConsigneeName());
					obj.setReceverPhone(address.getConsigneePhone());
					obj.setReceverAddress(address.getProvince()+
							address.getCity()+
							address.getDistrict()+
							address.getConsigneeAddress());
				}

		resultUtils.setData(obj);
		resultUtils.setStatus(200);
		resultUtils.setMessage("查询成功");
		return resultUtils;
    }

	@Override
	public ResultUtils findListByPage(Integer page, Integer limit, Map<String, String> map) {
		 ResultUtils resultUtils = new ResultUtils();
		IPage<OrderManage> wherePage = new Page<>(page, limit);
		QueryWrapper<OrderManage> wrapper = Wrappers.query();
		for (String key : map.keySet()) {
			wrapper.like(key,map.get(key));
		}
		wrapper.orderByDesc("create_time");
		wrapper.eq("order_del_status","1");

		IPage<OrderManage> list =   baseMapper.selectPage(wherePage, wrapper);
		/*需要在这里拼接上 用户的数据 以及地址的数据*/





			for(int a = 0;a<list.getRecords().size();a++){

				QueryWrapper<Member> wrapper1 = new QueryWrapper<>();
				wrapper1.eq("id",list.getRecords().get(a).getUserId());
				Member member = memberDao.selectOne(wrapper1);

				QueryWrapper<Address> wrapper2 = new QueryWrapper<>();
				wrapper2.eq("address_id",list.getRecords().get(a).getOrderAddressId());
				Address address = addressDao.selectOne(wrapper2);

				/*设置用户信息*/
				if(member != null && !member.equals(null)){
				list.getRecords().get(a).setUserNickName(member.getNickName());
				list.getRecords().get(a).setHeadImg(member.getHead());
				list.getRecords().get(a).setUserPhone(member.getPhone());
				}

				if(address != null && !address.equals(null) ){
					list.getRecords().get(a).setReceverPeopleName(address.getConsigneeName());
					list.getRecords().get(a).setReceverPhone(address.getConsigneePhone());
					list.getRecords().get(a).setReceverAddress(
							address.getConsigneeAddress());
				}
			}

		resultUtils.setData(list.getRecords());
		resultUtils.setMessage("查询成功");
		resultUtils.setStatus(200);
		resultUtils.setCode(0);
		resultUtils.setCount((int)list.getTotal());
		return resultUtils;
	}

	@Override
	public Boolean updateInfo(OrderManage orderManage) {
		orderManage.setUpdateTime(new Date());
		Integer i =  baseMapper.updateById(orderManage);
		if(i > 0){
			return true;
		}else{
			return false;
		}
	}
}
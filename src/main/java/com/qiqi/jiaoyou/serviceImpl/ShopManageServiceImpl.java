package com.qiqi.jiaoyou.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.mapper.ShopManageDao;
import com.qiqi.jiaoyou.pojo.Notice;
import com.qiqi.jiaoyou.pojo.ShopManage;
import com.qiqi.jiaoyou.service.INoticeService;
import com.qiqi.jiaoyou.service.ShopManageService;
import com.qiqi.jiaoyou.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * 商品管理(ShopManage)表服务实现类
 *
 * @author makejava
 * @since 2020-12-02 17:19:52
 */
@Service("shopManageService")
public class ShopManageServiceImpl extends ServiceImpl<ShopManageDao, ShopManage> implements ShopManageService {
	@Autowired
	private INoticeService iNoticeService;
    @Override
    public ResultUtils findListByPage(Integer page, Integer limit, Map<String, String> map) {
        ResultUtils resultUtils = new ResultUtils();
		IPage<ShopManage> wherePage = new Page<>(page, limit);
		QueryWrapper<ShopManage> wrapper = Wrappers.query();
		for (String key : map.keySet()) {
			wrapper.like(key,map.get(key));
		}
		wrapper.orderByAsc("shop_is_top","update_time");
		wrapper.eq("shop_status","1");

		IPage<ShopManage> list =   baseMapper.selectPage(wherePage, wrapper);

		resultUtils.setData(list.getRecords());
		resultUtils.setMessage("查询成功");
		resultUtils.setStatus(200);
		resultUtils.setCode(0);
		resultUtils.setCount((int)list.getTotal());
		return resultUtils;
    }

    @Override
    public ResultUtils findById(Long id) {
         ResultUtils resultUtils = new ResultUtils();
		ShopManage obj = baseMapper.selectById(id);
		resultUtils.setData(obj);
		resultUtils.setStatus(200);
		resultUtils.setMessage("查询成功");
		return resultUtils;
    }

    @Override
    public ResultUtils utop(Long id) {
       ResultUtils resultUtils = new ResultUtils();
        ShopManage serverInfoManager = baseMapper.selectById(id);
        serverInfoManager.setShopIsTop("1");
		Integer i =  baseMapper.updateById(serverInfoManager);
		if(i > 0){
			resultUtils.setStatus(200);
			resultUtils.setMessage("置顶成功");
		}else{
			resultUtils.setStatus(200);
			resultUtils.setMessage("置顶失败");
		}
		return resultUtils;
    }

    @Override
    public ResultUtils ntop(Long id) {
        ResultUtils resultUtils = new ResultUtils();
		 ShopManage serverInfoManager = baseMapper.selectById(id);
        serverInfoManager.setShopIsTop("0");
		Integer i =  baseMapper.updateById(serverInfoManager);
		if(i > 0){
			resultUtils.setStatus(200);
			resultUtils.setMessage("取消置顶成功");
		}else{
			resultUtils.setStatus(200);
			resultUtils.setMessage("取消置顶失败");
		}
		return resultUtils;
    }

    @Override
    public ResultUtils add(ShopManage shopManage) {
       ResultUtils resultUtils = new ResultUtils();
        ShopManage serverInfoType1 = new ShopManage();
		serverInfoType1.setCreateTime(new Date());
		serverInfoType1.setUpdateTime(new Date());
		serverInfoType1.setShopName(shopManage.getShopName());
		serverInfoType1.setShopPrice(shopManage.getShopPrice());
		serverInfoType1.setShopSpecs(shopManage.getShopSpecs());
		serverInfoType1.setShopIntroduce(shopManage.getShopIntroduce());
		serverInfoType1.setShopImg(shopManage.getShopImg());
		serverInfoType1.setCity(shopManage.getCity());
		serverInfoType1.setWidth(shopManage.getWidth());
		serverInfoType1.setBusinessIcon(shopManage.getBusinessIcon());
		serverInfoType1.setBusinessName(shopManage.getBusinessName());
		Integer i =  baseMapper.insert(serverInfoType1);
		if(i > 0){
			resultUtils.setStatus(200);
			resultUtils.setMessage("添加成功");

//			SendOfflineActivities sendOfflineActivities1 = sendOfflineActivitiesService.getById(sendOfflineActivities.getId());
			Notice notice = new Notice();
			// notice.setMemberId(sendOfflineActivities1.getSendMemberId());
			// notice.setNickName(sendOfflineActivities1.getSendMemberNickName());
			// notice.setHead(sendOfflineActivities1.getSendMemberHead());
			// notice.setSex(sendOfflineActivities1.getSendMemberSex());
			notice.setTitle("新商品\""+shopManage.getShopName()+"\"增加");
			notice.setShenqingTime(new Timestamp(System.currentTimeMillis()));
			notice.setType(4);
			notice.setContext("商品名称："+shopManage.getShopName()+",商品价格："+shopManage.getShopPrice()+"增加时间："+new Date());
			notice.setAddTime(new Date());
//			notice.setOfMember(2);
//			notice.setOfMember(sendOfflineActivities1.getSendMemberId());
//			notice.setDaochangTime(sendOfflineActivities.getStartTime());
			iNoticeService.save(notice);
		}else{
			resultUtils.setStatus(200);
			resultUtils.setMessage("添加失败");
		}
		return resultUtils;
    }

    @Override
    public ResultUtils delete(Long id) {
         ResultUtils resultUtils = new ResultUtils();
		Integer i =  baseMapper.deleteById(id);
		if(i > 0){
			resultUtils.setStatus(200);
			resultUtils.setMessage("删除成功");
		}else{
			resultUtils.setStatus(200);
			resultUtils.setMessage("删除失败");
		}
		return resultUtils;
    }

    @Override
    public ResultUtils updateData(ShopManage shopManage) {
         ResultUtils resultUtils = new ResultUtils();
		shopManage.setUpdateTime(new Date());
		Integer i =  baseMapper.updateById(shopManage);
		if(i > 0){
			resultUtils.setStatus(200);
			resultUtils.setMessage("更新成功");
		}else{
			resultUtils.setStatus(200);
			resultUtils.setMessage("更新失败");
		}
		return resultUtils;
    }
}
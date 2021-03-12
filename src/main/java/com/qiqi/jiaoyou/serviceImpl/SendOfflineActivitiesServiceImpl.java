package com.qiqi.jiaoyou.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.mapper.SendOfflineActivitiesMapper;
import com.qiqi.jiaoyou.pojo.AcceptOfflineActivities;
import com.qiqi.jiaoyou.pojo.MemberAssets;
import com.qiqi.jiaoyou.pojo.RechargeRecord;
import com.qiqi.jiaoyou.pojo.SendOfflineActivities;
import com.qiqi.jiaoyou.service.IAcceptOfflineActivitiesService;
import com.qiqi.jiaoyou.service.IMemberAssetsService;
import com.qiqi.jiaoyou.service.IRechargeRecordService;
import com.qiqi.jiaoyou.service.ISendOfflineActivitiesService;
import com.qiqi.jiaoyou.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 线下活动列表 服务实现类
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
@Service
public class SendOfflineActivitiesServiceImpl extends ServiceImpl<SendOfflineActivitiesMapper, SendOfflineActivities> implements ISendOfflineActivitiesService
{

    @Autowired
    private IAcceptOfflineActivitiesService iAcceptOfflineActivitiesService;
    @Autowired
    private IMemberAssetsService iMemberAssetsServicel;
    @Autowired
    private IRechargeRecordService iRechargeRecordService;
    @Override
    public ResultUtils findListByPage(Integer page, Integer limit, Map<String, String> map)
    {
	  ResultUtils resultUtils = new ResultUtils();
	  IPage<SendOfflineActivities> wherePage = new Page<>(page, limit);
	  QueryWrapper<SendOfflineActivities> wrapper = Wrappers.query();
	  for (String key : map.keySet())
	  {
		wrapper.like(key, map.get(key));
	  }
	  wrapper.orderByDesc("id");

	  IPage<SendOfflineActivities> list = baseMapper.selectPage(wherePage, wrapper);
	  resultUtils.setData(list.getRecords());
	  resultUtils.setMessage("查询成功");
	  resultUtils.setStatus(200);
	  resultUtils.setCode(0);
	  resultUtils.setCount((int) list.getTotal());
	  return resultUtils;
    }

    @Override
    public ResultUtils updateData(SendOfflineActivities sendOfflineActivities)
    {

	  if (sendOfflineActivities.getState() == 5)
	  {
		SendOfflineActivities sendOfflineActivities1 = baseMapper.selectById(sendOfflineActivities.getId());
		QueryWrapper<AcceptOfflineActivities> wrapper = new QueryWrapper<>();
		wrapper.eq("keepAnAppointmentState", 4);
		List<AcceptOfflineActivities> list = iAcceptOfflineActivitiesService.list(wrapper);
		if (sendOfflineActivities1.getPerSize() > list.size())
		{
		    QueryWrapper<MemberAssets> wrapper1 = new QueryWrapper<>();
		    wrapper1.eq("memberId", sendOfflineActivities1.getSendMemberId());
		    MemberAssets one = iMemberAssetsServicel.getOne(wrapper1);
		    one.setMemberDiamondsizeOfGold(one.getMemberDiamondsizeOfGold() + Long.valueOf(sendOfflineActivities1.getAverageDiamondsSize() * (sendOfflineActivities1.getPerSize() - list.size())));
		    iMemberAssetsServicel.updateById(one);

		    RechargeRecord rechargeRecord = new RechargeRecord();
		    rechargeRecord.setMemberId(one.getMemberId());
		    rechargeRecord.setName("聚会退回金钻");
		    rechargeRecord.setCurrency(3);
		    rechargeRecord.setMode(4);
		    rechargeRecord.setType(1);
		    rechargeRecord.setRunSize(Long.valueOf(sendOfflineActivities1.getAverageDiamondsSize() * (sendOfflineActivities1.getPerSize() - list.size())));
		    rechargeRecord.setSurplus(one.getMemberDiamondsizeOfGold());
		    rechargeRecord.setAddTime(new Timestamp(System.currentTimeMillis()));
		    iRechargeRecordService.save(rechargeRecord);
		}
	  }
	  ResultUtils resultUtils = new ResultUtils();
	  int i = baseMapper.updateById(sendOfflineActivities);
	  if (i <= 0)
	  {
		resultUtils.setMessage("审核失败");
		resultUtils.setStatus(500);
	  }
	  else
	  {

		resultUtils.setMessage("审核成功");
		resultUtils.setStatus(200);
	  }
	  return resultUtils;
    }

    @Override
    public SendOfflineActivities getReadById(Integer id)
    {
	  QueryWrapper<SendOfflineActivities> wrapper = new QueryWrapper<>();
	  wrapper.eq("id", id);
	  SendOfflineActivities sendOfflineActivities = baseMapper.selectOne(wrapper);

	  if (sendOfflineActivities != null)
	  {
		return sendOfflineActivities;
	  }
	  return null;
    }
}

package com.qiqi.jiaoyou.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.mapper.*;
import com.qiqi.jiaoyou.pojo.*;
import com.qiqi.jiaoyou.service.*;
import com.qiqi.jiaoyou.util.InvertCodeGenerator;
import com.qiqi.jiaoyou.util.ResultUtils;
import com.qiqi.jiaoyou.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * app会员表 服务实现类 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Service("IMemberService")
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService
{

	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private CarMapper carMapper;
	@Autowired
	private MemberAssetsMapper memberAssetsMapper;
	@Autowired
	private MembershipSettingsMapper membershipSettingsMapper;
	@Autowired
	private LableMapper lableMapper;
	@Autowired
	private IRechargeRecordService iRechargeRecordService;
	@Resource
	private IMemberAssetsService iMemberAssetsService;
	@Autowired
	private MemberMatchingLogMapper memberMatchingLogMapper;
	@Autowired
	private RechargeRecordMapper rechargeRecordMapper;
	@Autowired
	private PlatformParameterSettingMapper platformParameterSettingMapper;
	@Autowired
	private ClubService clubService;
	@Autowired
	private ClubBuddyService clubBuddyService;
	@Autowired
	private IGoodFriendService iGoodFriendService;
	@Autowired
	private ICircleOfFriendsService iCircleOfFriendsService;
	@Autowired
	private FabulousService fabulousService;
	@Autowired
	private IDynamicReviewOfFriendsCircleService iDynamicReviewOfFriendsCircleService;
	@Autowired
	private AdvanceOrderDao advanceOrderDao;
	@Autowired
	private IMemberService iMemberService;
	@Autowired
	private AdvanceOrderService advanceOrderService;


	/*更新审核的状态*/
	@Override
	public ResultUtils updateShitInfo(Member member)
	{
		ResultUtils resultUtils = new ResultUtils();
		PlatformParameterSetting platformParameterSetting = platformParameterSettingMapper.selectById(1);
		Member member1 = baseMapper.selectById(member.getId());
//        /*限制在这里，不需要动*/
		if ((member1.getSex() == 1 && member1.getRegistrationChannel() == 1) || member1.getRegistrationChannel() == 2)
		{
			Date yesterday = Yesterday(new Date(), platformParameterSetting.getMemberUsageTime());
			member.setIsvip(1);
			member.setMemberExpirationDate(yesterday);
		}

		if (member.getUserYes() != null && member.getUserYes())
		{
			member.setExamineState(1);
			if(member1.getRegistrationChannel() == 2) {
				// 审核通过，新增一条数据到车辆表里
				Car car1 = new Car();
				car1.setMemberId(member1.getId());
				car1.setDrivingLicensePhoto(member1.getDrivingLicensePhoto());
				car1.setModel(member1.getCarModel());
				car1.setAddTime(new Date());
				//1:待審核  2：審核通過 3：審核未通過
				car1.setAuditState(2);
				car1.setReason("车友注册，系统自动审核！");
				carMapper.insert(car1);
			}
		}
		else
		{
			member.setExamineState(2);
		}
		System.out.println(member);
		Integer i = memberMapper.updateById(member);
		if (i > 0)
		{
			resultUtils.setStatus(200);
			resultUtils.setMessage("编辑成功");
			return resultUtils;
		}
		else
		{
			resultUtils.setStatus(200);
			resultUtils.setMessage("编辑失败");
		}
		return resultUtils;
	}

	@Override
	public ResultUtils findListByPage(Integer page, Integer limit, Map<String, String> map)
	{
		ResultUtils resultUtils = new ResultUtils();
		IPage<Member> wherePage = new Page<>(page, limit);
		QueryWrapper<Member> wrapper = Wrappers.query();
		for (String key : map.keySet())
		{
			if (key.equals("province"))
			{
				wrapper.like("province", map.get("province")).or().like("city", map.get("province")).or().like("area", map.get("province"));
			}
			wrapper.like(key, map.get(key));
		}
		wrapper.eq("delUserStatus", 0);
		wrapper.orderByDesc("id");

		IPage<Member> list = baseMapper.selectPage(wherePage, wrapper);
		List<Member> records = list.getRecords();
		if (map.containsKey("registrationChannel") && map.get("registrationChannel").equals("2"))
		{
			for (Member member : records)
			{
				List<Car> memberId = carMapper.selectList(new QueryWrapper<Car>().eq("memberId", member.getId()));
				if (memberId.size() > 0)
				{
					member.setCar(memberId.get(0));
				}
				else
				{
					member.setCar(new Car());
				}
			}
		}
		resultUtils.setData(records);
		resultUtils.setMessage("查询成功");
		resultUtils.setStatus(200);
		resultUtils.setCode(0);
		resultUtils.setCount((int) list.getTotal());
		return resultUtils;
	}

	@Override
	public ResultUtils findListByPageRes(Integer page, Integer limit, Map<String, String> map)
	{
		ResultUtils resultUtils = new ResultUtils();
		IPage<AdvanceOrder> wherePage = new Page<>(page, limit);
		QueryWrapper<AdvanceOrder> wrapper = Wrappers.query();
//        for (String key : map.keySet()) {
//            if (key.equals("province")){
//            }
//            wrapper.like(key,map.get(key));
//        }
//        wrapper.orderByDesc("create_time");

		QueryWrapper<AdvanceOrder> wrappers = new QueryWrapper<>();
//		wrappers.orderByDesc("create_time");
		IPage<AdvanceOrder> list = advanceOrderDao.selectPage(wherePage, wrapper);
		List<AdvanceOrder> addresses = list.getRecords();

		/*查询的是所有账户的信息*/
		List<AdvanceOrder> addresses1 = advanceOrderDao.selectListInfo();
		if (addresses.size() > 0)
		{
//            resultUtils.setMessage("查询成功");
//            resultUtils.setCode(200);

			/*这里为每条数据拼接上用户的手机号*/
			for (int i = 0; i < addresses.size(); i++)
			{

				for (int b = 0; b < addresses1.size(); b++)
				{
					if (addresses.get(i).getId().equals(addresses1.get(b).getId()))
					{
						addresses.get(i).setCall(addresses1.get(b).getCall());
					}

				}

				Member member = iMemberService.findByMember(Long.parseLong(addresses.get(i).getUserId().toString()));
				if (member != null)
				{
					addresses.get(i).setPhone(member.getPhone());
					addresses.get(i).setNickName(member.getNickName());
//                    性别 1：男2：女
					addresses.get(i).setSex(member.getSex());
				}
			}
			resultUtils.setData(addresses);
//            return  resultUtils;
		}


//        if (map.containsKey("registrationChannel") && map.get("registrationChannel").equals("2")){
//            for (Member member : records){
//                List<Car> memberId = carMapper.selectList(new QueryWrapper<Car>().eq("memberId", member.getId()));
//                if (memberId.size() > 0){
//                    member.setCar(memberId.get(0));
//                }else {
//                    member.setCar(new Car());
//                }
//            }
//        }
		resultUtils.setData(addresses);
		resultUtils.setMessage("查询成功");
		resultUtils.setStatus(200);
		resultUtils.setCode(0);
		resultUtils.setCount((int) list.getTotal());
		return resultUtils;
	}
	/*更新预约是否已完成操作
	 * 20210108
	 * 没错，这个接口就一个作用，就是把传来的id的数据的已修改的值改为已修改
	 * isDealWith 客服是否已处理（0：已处理，1：未处理）
	 * */

	@Override
	public ResultUtils update(Integer id)
	{
		ResultUtils resultUtils = new ResultUtils();
		AdvanceOrder advanceOrder = advanceOrderDao.selectById(id);
		advanceOrder.setIsDealWith(0);
		Integer integer = advanceOrderDao.updateById(advanceOrder);
		if (integer > 0)
		{
			resultUtils.setCode(200);
			resultUtils.setMessage("更新成功");
			return resultUtils;
		}
		resultUtils.setCode(500);
		resultUtils.setMessage("更新失败");
		return resultUtils;
	}

	/* author：nan
	 * time:*************
	 * connect:根据客户的要求，需要删除所有的账户下的信息，所以这里就需要删除账户下的所有信息，不是状态删除，是真实删除
	 *  time: 20200106
	 *  很多天之后，我发现，这是状态删除，不需要真实删除了。。。。。。。
	 * */
	@Override
	@Transactional
	public ResultUtils delMore(String array)
	{
		String[] array1 = array.split(",");
		int back = 0;
		ResultUtils resultUtils = new ResultUtils();
		for (int i = 0; i < array1.length; i++)
		{
			Member member = baseMapper.selectById(array1[i]);
			/*0未删除 1 删除*/
			member.setDelUserStatus("1");
			/*启用状态 1：启用2：禁用*/
			member.setEnableSate(2);
			member.setOnLine("0");
			member.setPhone(member.getPhone() + "124");
			back = baseMapper.updateById(member);
//            back = baseMapper.deleteById(member);
		}
		if (back > 0)
		{
			/**
			 *账户删除成之后，在这里删除账户下的
			 * 俱乐部 好友表
			 * 好友表
			 * 朋友圈动态 朋友圈点赞信息 朋友圈动态评论
			 * 世界圈信息删除
			 */

			for (int i = 0; i < array1.length; i++)
			{
				/**
				 * 删除俱乐部信息
				 */
				//删除此用户的俱乐部信息
				clubService.deleteInfo(array1[i]);
				/**
				 * 删除俱乐部的好友表，删除自身id和会员id都是自己id的数据
				 */
				clubBuddyService.deleteInfoById(array1[i]);
				/**
				 * 删除好友的列表信息
				 */
				iGoodFriendService.deleteMemberInfo(array1[i]);
				/**
				 * 删除盆友圈的动态
				 */
				iCircleOfFriendsService.deleteMemberInfo(array1[i]);
				/**
				 * 删除朋友圈点赞信息
				 */
				fabulousService.deleteInfo(array1[i]);
				/**
				 * 删除评论信息
				 */
				iDynamicReviewOfFriendsCircleService.deleteInfo(array1[i]);

			}
			resultUtils.setStatus(200);
			resultUtils.setMessage("批量删除账户信息操作成功");
			return resultUtils;
		}
		resultUtils.setStatus(400);
		resultUtils.setMessage("批量删除账户信息操作失败");
		return resultUtils;
	}

	@Override
	public ResultUtils add(Member member)
	{
		ResultUtils resultUtils = new ResultUtils();
		Integer i = baseMapper.insert(member);
		if (i > 0)
		{
			resultUtils.setStatus(200);
			resultUtils.setMessage("添加成功");
		}
		else
		{
			resultUtils.setStatus(200);
			resultUtils.setMessage("添加失败");
		}
		return resultUtils;
	}

	@Override
//    @Transactional
	/*注释什么的没删除 是有原因的*/
	public ResultUtils updateGold(Integer userId, Integer gold, Integer silver, String endTime)
	{
		ResultUtils resultUtils = new ResultUtils();
		Member member = new Member();
		member.setId(userId);

		int i = 0;

		if (endTime != "")
		{
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try
			{
				Date parse = sdf1.parse(endTime);
				if (parse.after(new Date()))
				{
					member.setIsvip(1);
				}else {
					member.setIsvip(2);
				}
				member.setMemberExpirationDate(sdf1.parse(endTime));
			}
			catch (ParseException e)
			{
				e.printStackTrace();
			}
			i = baseMapper.updateById(member);
		}
		ResultUtils b = null;

		MemberAssets memberAssetsa = null;
		memberAssetsa = iMemberAssetsService.findByMemberId(Long.parseLong(userId.toString()));
		MemberAssets memberAssets = null;
		//*这里加判断，防止数字是负*/
//        if(gold.toString().indexOf('-') >= 0){
//            b.setStatus(400);
//            b.setMessage("编辑失败,金钻数不能包含负数");
//            return b;
//        }
//        if(silver.toString().indexOf('-') >= 0){
//            b.setStatus(400);
//            b.setMessage("编辑失败，金钻数不能包含负数");
//            return b;
//        }

		String notes = "";

		if (endTime != "" && i > 0)
		{
			memberAssets = iMemberAssetsService.findByMemberId(Long.parseLong(userId.toString()));
			Long startTs = System.currentTimeMillis();
//                notes = "会员ID："+member.getId()+",当前时间："+startTs+",当前金钻："+memberAssets.getMemberDiamondsizeOfGold().toString()+",当前银钻："+memberAssets.getMemberDiamondsizeOfSilver().toString()+",";
			memberAssets.setMemberDiamondsizeOfGold(Long.parseLong(gold.toString()));
			memberAssets.setMemberDiamondsizeOfSilver(Long.parseLong(silver.toString()));
			b = iMemberAssetsService.updateData(memberAssets);
		}

		if (endTime == "")
		{
			memberAssets = iMemberAssetsService.findByMemberId(Long.parseLong(userId.toString()));
			Long startTs = System.currentTimeMillis();
//            notes = "会员ID："+member.getId()+",当前时间："+startTs+",当前金钻："+memberAssets.getMemberDiamondsizeOfGold().toString()+",当前银钻："+memberAssets.getMemberDiamondsizeOfSilver().toString()+",";
			memberAssets.setMemberDiamondsizeOfGold(Long.parseLong(gold.toString()));
			memberAssets.setMemberDiamondsizeOfSilver(Long.parseLong(silver.toString()));
			b = iMemberAssetsService.updateData(memberAssets);
		}

		/*判断用户进行了什么操作，若是新增减少都有操作，那么就是插入两条信息*/
		/*首先获取当前金钻和银钻的数量，判断是否进行了增减减少操作*/

		RechargeRecord rechargeRecord = null;

		Integer isa = null;
		int pis = 0;

		/*金钻*/
		if (memberAssetsa.getMemberDiamondsizeOfGold() != Long.parseLong(gold.toString()) && b.getMessage() == "编辑成功")
		{
			pis += 1;
			//编辑成功之后，需要在记录表新增一条记录，记录记录失败的话再试一次，一共是两次,记录消息不作为返回信息处理
			rechargeRecord = new RechargeRecord();
			rechargeRecord.setMemberId(member.getId());
			rechargeRecord.setCurrency(3);
			rechargeRecord.setMode(4);
			rechargeRecord.setName("平台修改");
			rechargeRecord.setAddTime(new Date());

			/*金钻增加*/
			if (gold > memberAssetsa.getMemberDiamondsizeOfGold())
			{
				rechargeRecord.setType(1);
				/*设置增加了几个*/
				rechargeRecord.setRunSize((gold - memberAssetsa.getMemberDiamondsizeOfGold()));
				rechargeRecord.setSurplus(Long.parseLong(gold.toString()));
			}
			/*金钻消耗*/
			if (gold < memberAssetsa.getMemberDiamondsizeOfGold())
			{
				rechargeRecord.setType(2);
				/*设置减少了几个*/
				rechargeRecord.setRunSize((memberAssetsa.getMemberDiamondsizeOfGold() - gold));
				rechargeRecord.setSurplus(Long.parseLong(gold.toString()));
			}
			isa = rechargeRecordMapper.insert(rechargeRecord);
		}


		/*银钻*/
		if (memberAssetsa.getMemberDiamondsizeOfSilver() != Long.parseLong(silver.toString()) && b.getMessage() == "编辑成功")
		{
			pis += 1;
			//编辑成功之后，需要在记录表新增一条记录，记录记录失败的话再试一次，一共是两次,记录消息不作为返回信息处理
			rechargeRecord = new RechargeRecord();
			rechargeRecord.setMemberId(member.getId());
			rechargeRecord.setCurrency(4);
			rechargeRecord.setMode(4);
			rechargeRecord.setName("平台修改");
			rechargeRecord.setAddTime(new Date());

			/*银钻增加*/
			if (gold > memberAssetsa.getMemberDiamondsizeOfSilver())
			{
				rechargeRecord.setType(1);
				/*设置增加了几个*/
				rechargeRecord.setRunSize(silver - memberAssetsa.getMemberDiamondsizeOfSilver());
				rechargeRecord.setSurplus(Long.parseLong(silver.toString()));
			}
			/*银钻消耗*/
			if (gold < memberAssetsa.getMemberDiamondsizeOfSilver())
			{
				rechargeRecord.setType(2);
				/*设置减少了几个*/
				rechargeRecord.setRunSize(memberAssetsa.getMemberDiamondsizeOfSilver() - silver);
				rechargeRecord.setSurplus(Long.parseLong(silver.toString()));
			}
			isa = rechargeRecordMapper.insert(rechargeRecord);
		}


//        if(b.getMessage() == "编辑成功" && i > 0){
//            //编辑成功之后，需要在记录表新增一条记录，记录记录失败的话再试一次，一共是两次,记录消息不作为返回信息处理
//            RechargeRecord rechargeRecord = new RechargeRecord();
//            rechargeRecord.setMemberId(member.getId());
//
//            /*3：金钻  4：银钻*/
//            /*增加*/
//            if(gold > memberAssetsa.getMemberDiamondsizeOfGold()){
////                rechargeRecord.setCurrency(3);
////                rechargeRecord.setType(1);
////                rechargeRecord.setRunSize();
//                notes += ("金钻增加："+(gold - memberAssetsa.getMemberDiamondsizeOfGold())+",");
//            }
//            if(silver > memberAssetsa.getMemberDiamondsizeOfSilver()){
////                rechargeRecord.setCurrency(4);
////                rechargeRecord.setType(1);
////                rechargeRecord.setRunSize();
//                notes += ("银钻增加："+(silver - memberAssetsa.getMemberDiamondsizeOfSilver())+",");
//            }
//            /*减少*/
//            if(gold < memberAssetsa.getMemberDiamondsizeOfGold()){
////                rechargeRecord.setCurrency(3);
////                rechargeRecord.setType(2);
////                rechargeRecord.setRunSize();
//                notes += ("金钻减少："+(memberAssetsa.getMemberDiamondsizeOfGold() - silver)+",");
//            }
//            if(silver < memberAssetsa.getMemberDiamondsizeOfSilver()){
////                rechargeRecord.setCurrency(4);
////                rechargeRecord.setType(2);
////                rechargeRecord.setRunSize();
//                notes += ("银钻减少："+(memberAssetsa.getMemberDiamondsizeOfSilver() - silver)+",");
//            }
//            notes += ("修改之后的金钻数为："+memberAssets.getMemberDiamondsizeOfGold()+",银钻数为："+memberAssets.getMemberDiamondsizeOfSilver());
//            /*放描述信息*/
//            rechargeRecord.setName(notes);
//            /*系统*/
//            rechargeRecord.setMode(4);
//            rechargeRecord.setAddTime(new Date());
//            Integer isa = rechargeRecordMapper.insert(rechargeRecord);
//            if(isa <= 0){
//                rechargeRecordMapper.insert(rechargeRecord);
//            }
//             return b;
//        }
//        Integer isa = rechargeRecordMapper.insert(rechargeRecord);
		if (pis > 0)
		{
			if (isa <= 0)
			{
				rechargeRecordMapper.insert(rechargeRecord);
			}
			if (isa > 0)
			{
				b.setStatus(200);
				b.setMessage("编辑成功");
				return b;
			}
		}
		if (i > 0)
		{
			b.setStatus(200);
			b.setMessage("编辑成功");
			return b;
		}
		b.setStatus(400);
		b.setMessage("编辑失败");
		return b;


	}

	@Override
	public ResultUtils delete(Integer id)
	{
		ResultUtils resultUtils = new ResultUtils();
		Integer i = baseMapper.deleteById(id);
		if (i > 0)
		{
			resultUtils.setStatus(200);
			resultUtils.setMessage("编辑成功");
		}
		else
		{
			resultUtils.setStatus(200);
			resultUtils.setMessage("编辑失败");
		}
		return resultUtils;
	}

	@Override
	public ResultUtils updateDataA(Member member)
	{
		ResultUtils resultUtils = new ResultUtils();
		PlatformParameterSetting platformParameterSetting = platformParameterSettingMapper.selectById(1);
		Member member1 = baseMapper.selectById(member.getId());
//        /*限制在这里，不需要动*/
		if ((member.getSex() == 1 && member1.getRegistrationChannel() == 1) || member1.getRegistrationChannel() == 2)
		{
			Date yesterday = Yesterday(new Date(), platformParameterSetting.getMemberUsageTime());
			member.setIsvip(1);
			member.setMemberExpirationDate(yesterday);
		}

		/**
		 * update 20201224
		 * author nan
		 * want look notes ?
		 * do dream!!!! HaHa
		 */
//        if(member.getExamineState() == 1){
//            member1.setReason(member.getReason());
//            member1.setExamineState(1);
//            member1.setCarLable(member.getCarLable());
////            member1.setBackgroundImages(member1.getBackgroundImages());
//        }
//        if(member.getExamineState() == 2){
//            member1.setReason(member.getReason());
//            member1.setExamineState(2);
////            member1.setCarLable(member.getCarLable());
////            member1.setBackgroundImages(member1.getBackgroundImages());
//        }

//        member1.setId(member.getId());

		Integer i = baseMapper.updateById(member);
		if (i > 0)
		{
			resultUtils.setStatus(200);
			resultUtils.setMessage("编辑成功");
			return resultUtils;
		}
		else
		{
			resultUtils.setStatus(200);
			resultUtils.setMessage("编辑失败");
		}
		return resultUtils;
	}

	public Member getCode(Member member)
	{
		String s = InvertCodeGenerator.genCodes(6);
		List<Member> invitationCode = baseMapper.selectList(new QueryWrapper<Member>().eq("invitationCode", s));
		if (invitationCode.size() > 0)
		{
			getCode(member);
		}
		else
		{
			member.setInvitationCode(s);
		}
		return member;
	}

	@Override
	public ResultUtils findById(Long id)
	{
		ResultUtils resultUtils = new ResultUtils();
		Member obj = baseMapper.selectById(id);
		List<Car> memberId = carMapper.selectList(new QueryWrapper<Car>().eq("memberId", obj.getId()));
		if (memberId.size() <= 0)
		{
			obj.setCar(new Car());
		}
		else
		{
			obj.setCar(memberId.get(0));
		}
		List<MemberAssets> memberId1 = memberAssetsMapper.selectList(new QueryWrapper<MemberAssets>().eq("memberId", obj.getId()));
		if (memberId1.size() <= 0)
		{
			obj.setMemberAssets(new MemberAssets());
		}
		else
		{
			obj.setMemberAssets(memberId1.get(0));
		}
		resultUtils.setData(obj);
		resultUtils.setStatus(200);
		resultUtils.setMessage("查询成功");
		return resultUtils;
	}

	@Override
	public Member findByMember(Long id)
	{
		Member wrapper = baseMapper.selectById(id);
		if (wrapper != null)
		{
			return wrapper;
		}
		return null;
	}

	@Override
	public MemberVo findUserInfo(Long id)
	{
		Member obj = baseMapper.selectById(id);
		MemberAssets memberAssets1 = iMemberAssetsService.findByMemberId(id);

		MemberVo memberVo = new MemberVo();
		if (obj != null)
		{
			memberVo.setId(obj.getId());
			memberVo.setUserIsvIP(obj.getIsvip());
			memberVo.setVipEndTime(obj.getMemberExpirationDate());
		}

		if (memberAssets1 != null)
		{
			//        memberVo.setHornNumber(memberAssets.getMemberhornSize());
			memberVo.setGoldNumber(memberAssets1.getMemberDiamondsizeOfGold());
			memberVo.setSilverNumber(memberAssets1.getMemberDiamondsizeOfSilver());
		}
		return memberVo;
	}

	/**
	 * 修改启用状态
	 *
	 * @param id
	 * @param enableState
	 */
	@Override
	public ResultUtils updateEnable(Integer id, Integer enableState)
	{
		ResultUtils resultUtils = new ResultUtils();
		Member member = new Member();
		member.setId(id);
		member.setEnableSate(enableState);
		int i = baseMapper.updateById(member);
		if (i > 0)
		{
			List<MemberMatchingLog> memberMatchingLogs = memberMatchingLogMapper.selectList(new QueryWrapper<MemberMatchingLog>());
			if (enableState == 2)
			{
				for (MemberMatchingLog memberMatchingLog : memberMatchingLogs)
				{
					if (memberMatchingLog.getMemberMatchingLogMemberIdsSoul() == null || "".equals(memberMatchingLog.getMemberMatchingLogMemberIdsSoul()))
					{

					}
					else
					{
						StringBuffer stringBuffer = new StringBuffer();
						String[] split = memberMatchingLog.getMemberMatchingLogMemberIdsSoul().split(",");
						for (int j = 0; j < split.length; j++)
						{
							if (!String.valueOf(id).equals(split[j]))
							{
								stringBuffer.append(split[j]);
								stringBuffer.append(",");
							}
						}
						memberMatchingLog.setMemberMatchingLogMemberIdsSoul(stringBuffer.toString());
					}

					if (memberMatchingLog.getMemberMatchingLogMemberIdsCar() == null || "".equals(memberMatchingLog.getMemberMatchingLogMemberIdsCar()))
					{

					}
					else
					{
						StringBuffer stringBuffer = new StringBuffer();
						String[] split = memberMatchingLog.getMemberMatchingLogMemberIdsCar().split(",");
						for (int j = 0; j < split.length; j++)
						{
							if (!String.valueOf(id).equals(split[j]))
							{
								stringBuffer.append(split[j]);
								stringBuffer.append(",");
							}
						}
						memberMatchingLog.setMemberMatchingLogMemberIdsCar(stringBuffer.toString());
					}

					memberMatchingLogMapper.updateById(memberMatchingLog);
				}
			}
			resultUtils.setMessage("修改成功");
			resultUtils.setStatus(200);
		}
		else
		{
			resultUtils.setMessage("修改失败");
			resultUtils.setStatus(500);
		}
		return resultUtils;
	}

	@Override
	public ResultUtils updateIsCustomer(Integer id, Integer isCustomer)
	{
		ResultUtils resultUtils = new ResultUtils();
		Member member = baseMapper.selectById(id);
		if (isCustomer == 1)
		{
			member.setNickName(member.getNickName() + "【官方】");
		}
		else
		{
			member.setNickName(member.getNickName().replaceAll("【官方】", ""));
		}
		member.setId(id);
		member.setIsCustomer(isCustomer);
		int i = baseMapper.updateById(member);
		if (i > 0)
		{
			resultUtils.setMessage("修改成功");
			resultUtils.setStatus(200);
		}
		else
		{
			resultUtils.setMessage("修改失败");
			resultUtils.setStatus(500);
		}
		return resultUtils;
	}

	public static Date Yesterday(Date date, Integer hour)
	{
		//获取当前时间指定小时后的时间
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY) + hour);
		Date time = c.getTime();
		return time;
	}
}

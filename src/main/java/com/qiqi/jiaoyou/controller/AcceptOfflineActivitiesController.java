package com.qiqi.jiaoyou.controller;


import com.qiqi.jiaoyou.pojo.AcceptOfflineActivities;
import com.qiqi.jiaoyou.pojo.Notice;
import com.qiqi.jiaoyou.pojo.SendOfflineActivities;
import com.qiqi.jiaoyou.service.INoticeService;
import com.qiqi.jiaoyou.serviceImpl.AcceptOfflineActivitiesServiceImpl;
import com.qiqi.jiaoyou.serviceImpl.SendOfflineActivitiesServiceImpl;
import com.qiqi.jiaoyou.util.ResultUtils;
import com.qiqi.jiaoyou.vo.Param;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;

/**
 * <p>
 * 线下活动列表 前端控制器
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
//@RestController
@Api(tags = {"取消赴约申请"})
@Controller
@RequestMapping("/active")

public class AcceptOfflineActivitiesController {
    private final AcceptOfflineActivitiesServiceImpl service;

    @Autowired
    private INoticeService iNoticeService;
    @Autowired
    private SendOfflineActivitiesServiceImpl sendOfflineActivitiesService;

    public AcceptOfflineActivitiesController(AcceptOfflineActivitiesServiceImpl service) {
        this.service = service;
    }

    @ApiOperation(value = "取消申请列表")
    @GetMapping("/list")
    @ResponseBody
    public ResultUtils list(Param param)
    {
        return service.acceptList(param);
    }

    @GetMapping("/editStatus")
    @ResponseBody
    public ResultUtils editStatus(Integer id,Integer status)
    {

	  AcceptOfflineActivities acceptOfflineActivities = service.getById(id);
	  /*查询用户参与的聚会主题*/
	  SendOfflineActivities sendOfflineActivities1 =  sendOfflineActivitiesService.getById(acceptOfflineActivities.getSendOfflineActivities());

	  // 参与者
	  Notice notice = new Notice();
	  // notice.setShenqingId(acceptOfflineActivities.getId());
	  notice.setMemberId(sendOfflineActivities1.getSendMemberId());
	  notice.setNickName(sendOfflineActivities1.getSendMemberNickName());
	  notice.setHead(sendOfflineActivities1.getSendMemberHead());
	  notice.setSex(sendOfflineActivities1.getSendMemberSex());
	  notice.setShenqingTime(new Timestamp(System.currentTimeMillis()));
	  notice.setDaochangTime(acceptOfflineActivities.getKeepAnAppointmentTime());
	  //		  1:通过 2：未通过
	  if(status == 1){
		notice.setTitle("您申请取消参加\""+sendOfflineActivities1.getSendMemberNickName()+"\"发起的\"" + sendOfflineActivities1.getActivityTheme() + "\"聚会已被通过审核");
	  }
	  if(status == 2){
		notice.setTitle("您申请取消参加\""+sendOfflineActivities1.getSendMemberNickName()+"\"发起的\"" + sendOfflineActivities1.getActivityTheme() + "\"聚会未通过审核, 若有任何疑问可拨打客服热线0731-85206798");

	  }
	  //		notice.setTitle(acceptOfflineActivities.getAcceptMemberNickName() + "发起了\"" + sendOfflineActivities.getActivityTheme() + "\"报名申请");
	  notice.setPerSize(sendOfflineActivities1.getPerSize());
	  notice.setStartTime(sendOfflineActivities1.getStartTime());
	  notice.setAddress(sendOfflineActivities1.getAddress());
	   notice.setOfMember(acceptOfflineActivities.getAcceptMemberId());
	  notice.setType(2);
	  notice.setAddTime(new Timestamp(System.currentTimeMillis()));
	  iNoticeService.save(notice);


	  // 发起者
	  //		  1:通过 2：未通过
	  if(status == 1){
		Notice notice1 = new Notice();
		// notice.setShenqingId(acceptOfflineActivities.getId());
		// notice1.setMemberId(acceptOfflineActivities.getAcceptMemberId());
		// notice1.setNickName(acceptOfflineActivities.getAcceptMemberNickName());
		// notice1.setHead(acceptOfflineActivities.getAcceptMemberHead());
		// notice1.setSex(acceptOfflineActivities.getAcceptMemberSex());
		notice1.setShenqingTime(new Timestamp(System.currentTimeMillis()));
		notice1.setDaochangTime(acceptOfflineActivities.getKeepAnAppointmentTime());
		notice1.setTitle("用户\""+acceptOfflineActivities.getAcceptMemberNickName()+"\"申请取消参加您发起的\"" + sendOfflineActivities1.getActivityTheme() + "\"聚会已被通过审核, 若有任何疑问可拨打客服热线0731-85206798");
		notice1.setPerSize(sendOfflineActivities1.getPerSize());
		notice1.setStartTime(sendOfflineActivities1.getStartTime());
		notice1.setAddress(sendOfflineActivities1.getAddress());
		notice1.setOfMember(sendOfflineActivities1.getSendMemberId());
		notice1.setType(2);
		notice1.setAddTime(new Timestamp(System.currentTimeMillis()));
		iNoticeService.save(notice1);
	  }

        return service.acceptAlterStatus(id,status);
    }

    /**
     * 跳转列表页面
     * @return String
     */
    @GetMapping("/pages/Index1")
    public String index(){
        return "/pages/AcceptOfflineActivities/Index1";
    }
}


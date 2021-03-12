package com.qiqi.jiaoyou.controller;


import com.qiqi.jiaoyou.pojo.Notice;
import com.qiqi.jiaoyou.pojo.SendOfflineActivities;
import com.qiqi.jiaoyou.service.INoticeService;
import com.qiqi.jiaoyou.serviceImpl.SendOfflineActivitiesServiceImpl;
import com.qiqi.jiaoyou.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 线下活动列表 前端控制器
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
@Controller
@RequestMapping("/sendOfflineActivities")
public class SendOfflineActivitiesController
{

    @Autowired
    private SendOfflineActivitiesServiceImpl sendOfflineActivitiesService;
    @Autowired
    private INoticeService iNoticeService;

    @GetMapping("/findListByPage")
    @ResponseBody
    public ResultUtils findListByPage(@RequestParam Integer page, @RequestParam Integer limit, @RequestParam String json) throws UnsupportedEncodingException
    {
	  Map<String, String> map = new HashMap<>();
	  if (json != null && !"".equals(json))
	  {
		String[] split = json.split("&");
		for (String str : split)
		{
		    String[] split1 = str.split("=");
		    if (split1.length == 1)
		    {
			  continue;
		    }
		    else
		    {
			  map.put(split1[0], split1[1]);
		    }
		}
	  }
	  return sendOfflineActivitiesService.findListByPage(page, limit, map);
    }


    @PostMapping("/update")
    @ResponseBody
    public ResultUtils update(@ModelAttribute SendOfflineActivities sendOfflineActivities)
    {
	  if (sendOfflineActivities.getState() == 5)
	  {
		SendOfflineActivities sendOfflineActivities1 = sendOfflineActivitiesService.getById(sendOfflineActivities.getId());
		Notice notice = new Notice();
		// notice.setMemberId(sendOfflineActivities1.getSendMemberId());
		// notice.setNickName(sendOfflineActivities1.getSendMemberNickName());
		// notice.setHead(sendOfflineActivities1.getSendMemberHead());
		// notice.setSex(sendOfflineActivities1.getSendMemberSex());
		notice.setTitle("聚会审核通过，祝您相处愉快！有任何疑问可拨打客服热线0731-85206798。");
		notice.setShenqingTime(new Timestamp(System.currentTimeMillis()));
		notice.setOfMember(sendOfflineActivities1.getSendMemberId());
		notice.setDaochangTime(sendOfflineActivities.getStartTime());
		iNoticeService.save(notice);
	  }

	  return sendOfflineActivitiesService.updateData(sendOfflineActivities);
    }


    /**
     * 跳转单条信息详情页面
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/OfflineActivitiesRead"})
    public String readPages(@RequestParam Integer id, Model model)
    {
	  model.addAttribute("offlineActivities", sendOfflineActivitiesService.getReadById(id));
	  return "/pages/OfflineActivities/OfflineActivitiesRead";
    }



    /**
     * 跳转列表页面
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/OfflineActivitiesList"})
    public String index()
    {
	  return "/pages/OfflineActivities/OfflineActivitiesList";
    }


    /**
     * 跳转审核页面
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/OfflineActivitiesUpdate"})
    public String edit(Integer id, Model model)
    {
	  model.addAttribute("offlineActivities", sendOfflineActivitiesService.getById(id));
	  return "/pages/OfflineActivities/OfflineActivitiesUpdate";
    }
}


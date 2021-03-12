package com.qiqi.jiaoyou.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.qiqi.jiaoyou.mapper.AdvanceOrderDao;
import com.qiqi.jiaoyou.service.IMemberService;
import com.qiqi.jiaoyou.service.OrderManageService;
import com.qiqi.jiaoyou.util.ResultUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * 订单信息表(OrderManage)表控制层
 *
 * @author nan
 * @since 2020-12-03 15:38:18
 */
@Controller
@RequestMapping("/orderManage")
public class OrderManageController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private OrderManageService orderManageService;
    @Autowired
	private AdvanceOrderDao advanceOrderDao;
    @Autowired
	private IMemberService iMemberService;

@ApiOperation(value = "查询表分页数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", value = "页码"),
			@ApiImplicitParam(name = "pageCount", value = "每页条数")
	})
	@GetMapping("/findListByPage")
	@ResponseBody
	public ResultUtils findListByPage(@RequestParam Integer page,
									  @RequestParam Integer limit,
									  @RequestParam String json) throws UnsupportedEncodingException {
		Map<String, String> map = new HashMap<>();
		if (json != null && !"".equals(json)) {
			String[] split = json.split("&");
			for (String str : split) {
				String[] split1 = str.split("=");
				if (split1.length == 1) {
					continue;
				} else {
					map.put(split1[0],split1[1]);
				}
			}
		}
		return orderManageService.findListByPage(page, limit,map);
	}
  /**
	 * 跳转列表页面
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = {"/pages/OrderManageList"})
	public String index(){
		return "/pages/OrderManage/OrderManageList";
	}

	/**
	 * 跳转显示页面
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = {"/pages/OrderManageShow"})
	public String indexShow(Long id, Model model){
	    model.addAttribute("orderManage",orderManageService.findById(id).getData());
		return "/pages/OrderManage/OrderManageShow";
	}



/**
	 * 跳转显示页面
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = {"/pages/OrderManageDeliver"})
	public String indexDeliver(Long id, Model model){
       model.addAttribute("orderManage",orderManageService.findById(id).getData());
        return "/pages/OrderManage/OrderManageDeliver";
	}



	/**
	 * 跳转预约商品显示页面
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = {"/pages/ResOrderManager"})
	public String indexDel(){
		return "/pages/OrderManage/ResOrderManager";
	}



	@GetMapping("/findListByPageRes")
	@ResponseBody
	public ResultUtils findListByPageRes(@RequestParam Integer page,
										 @RequestParam Integer limit,
										 @RequestParam String json) throws UnsupportedEncodingException{
		Map<String, String> map = new HashMap<>();
		if (json != null && !"".equals(json)) {
			String[] split = json.split("&");
			for (String str : split) {
				String[] split1 = str.split("=");
				if (split1.length == 1) {
					continue;
				} else {
					map.put(split1[0],split1[1]);
				}
			}
		}
		return iMemberService.findListByPageRes(page, limit,map);

//	ResultUtils resultUtils = new ResultUtils();
//		QueryWrapper<AdvanceOrder> wrapper = new QueryWrapper<>();
//		wrapper.orderByDesc("create_time");
//		List<AdvanceOrder> addresses = advanceOrderDao.selectList(wrapper);
//		if(addresses.size() > 0){
//			resultUtils.setMessage("查询成功");
//			resultUtils.setCode(200);
//
//			/*这里为每条数据拼接上用户的手机号*/
//			for(int i = 0;i<addresses.size();i++){
//			Member member = iMemberService.findByMember( Long.parseLong(addresses.get(i).getUserId().toString()));
//			if(member != null){
//				addresses.get(i).setPhone(member.getPhone());
//			}
//			}
//			resultUtils.setData(addresses);
//			return  resultUtils;
//		}
//		resultUtils.setMessage("查询失败");
//		resultUtils.setCode(400);
//		return resultUtils;
	}
	@GetMapping("/update")
	@ResponseBody
	public ResultUtils update(Integer id){
		return iMemberService.update(id);
	}

}
package com.qiqi.jiaoyou.controller;

import com.baomidou.mybatisplus.extension.api.ApiController;
import com.qiqi.jiaoyou.pojo.LoveHeartDonation;
import com.qiqi.jiaoyou.service.LoveHeartDonationService;
import com.qiqi.jiaoyou.util.ResultUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nan
 * 爱心捐赠
 * @date 2020/11/30 10:40
 */
@Controller
@RequestMapping("/loveDonation")
public class LoveDonationController extends ApiController {

    @Autowired
    private LoveHeartDonationService loveHeartDonationService;


    	@ApiOperation(value = "新增爱心捐赠")
	@PostMapping("/add")
	@ResponseBody
	public ResultUtils add(@ModelAttribute LoveHeartDonation loveHeartDonation){
		return loveHeartDonationService.add(loveHeartDonation);
	}

	@ApiOperation(value = "删除爱心捐赠信息")
	@GetMapping("/delete")
	@ResponseBody
	public ResultUtils delete(Long id){
		return loveHeartDonationService.delete(id);
	}

	@ApiOperation(value = "更新爱心捐赠标签")
	@PostMapping("/update")
	@ResponseBody
	public ResultUtils update(@ModelAttribute LoveHeartDonation loveHeartDonation){
		return loveHeartDonationService.updateData(loveHeartDonation);
	}

@ApiOperation(value = "查询爱心捐赠表分页数据")
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
		return loveHeartDonationService.findListByPage(page, limit,map);
	}




	/**
	 * 跳转列表页面
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = {"/pages/LoveDonationList"})
	public String index(){
		return "/pages/LoveDonation/LoveDonationList";
	}


	/**
	 * 跳转新增页面
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = {"/pages/LoveDonationAdd"})
	public String loveAdd(){
		return "/pages/LoveDonation/LoveDonationAdd";
	}


	/**
	 * 跳转更新页面
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = {"/pages/LoveDonationUpdate"})
	public String indexUpdate(Long id, Model model){
    model.addAttribute("loveDonation",loveHeartDonationService.findById(id).getData());
    return "/pages/LoveDonation/LoveDonationUpdate";
	}
	/**
	 * 跳转显示页面
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = {"/pages/LoveDonationShow"})
	public String indexShow(Long id,Model model){
	    model.addAttribute("loveDonation",loveHeartDonationService.findById(id).getData());
		return "/pages/LoveDonation/LoveDonationShow";
	}


}


package com.qiqi.jiaoyou.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.qiqi.jiaoyou.service.LoveHeartDonationLogsService;
import com.qiqi.jiaoyou.util.ResultUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

/**
 * (LoveHeartDonationLogs)表控制层
 *
 * @author makejava
 * @since 2020-12-01 11:02:16
 */
@Controller
@RequestMapping("/loveDonationLogs")
public class LoveHeartDonationLogsController extends ApiController {
    /**
     * 服务对象
     */
    @Autowired
    private LoveHeartDonationLogsService loveHeartDonationLogsService;


  @ApiOperation(value = "查询爱心捐赠表捐赠记录分页数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", value = "页码"),
			@ApiImplicitParam(name = "pageCount", value = "每页条数")
	})
	@GetMapping("/findListByLogs")
	@ResponseBody
	public ResultUtils findListByPage(@RequestParam Integer page,
                                      @RequestParam Integer limit,
                                       @RequestParam Integer userId) throws UnsupportedEncodingException {
		return loveHeartDonationLogsService.findListByLogs(page, limit,userId);
	}
	/**
	 * 跳转捐赠信息记录页面，需要查询出详细的捐赠信息列表并返回
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = {"/pages/LoveDonationLogs"})
	public String indexLogs(Long id, Model model){
	    model.addAttribute("loveDonationLogs",id);
		return "/pages/LoveDonation/LoveDonationLogs";
	}
}
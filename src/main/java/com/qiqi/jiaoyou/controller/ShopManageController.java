package com.qiqi.jiaoyou.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.qiqi.jiaoyou.pojo.ShopManage;
import com.qiqi.jiaoyou.service.ShopManageService;
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
 * 商品管理(ShopManage)表控制层
 *
 * @author nan
 * @since 2020-12-02 17:19:53
 */
@Controller
@RequestMapping("/shopManage")
public class ShopManageController extends ApiController {
    @Autowired
	private ShopManageService shopManageService;


    @ApiOperation(value = "置顶")
	@GetMapping("/utop")
	@ResponseBody
	public ResultUtils utop(Long id){
		return shopManageService.utop(id);
	}


@ApiOperation(value = "取消置顶")
	@GetMapping("/ntop")
	@ResponseBody
	public ResultUtils ntop(Long id){
		return shopManageService.ntop(id);
	}


	@ApiOperation(value = "新增选项标签")
	@PostMapping("/add")
	@ResponseBody
	public ResultUtils add(@ModelAttribute ShopManage shopManage){
		return shopManageService.add(shopManage);
	}

	@ApiOperation(value = "删除选项标签")
	@GetMapping("/delete")
	@ResponseBody
	public ResultUtils delete(Long id){
		return shopManageService.delete(id);
	}

	@ApiOperation(value = "更新选项标签")
	@PostMapping("/update")
	@ResponseBody
	public ResultUtils update(@ModelAttribute ShopManage shopManage){
		return shopManageService.updateData(shopManage);
	}

@ApiOperation(value = "查询游戏题库表分页数据")
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
		return shopManageService.findListByPage(page, limit,map);
	}
/**
	 * 跳转列表页面
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = {"/pages/ShopManageList"})
	public String index(){
		return "/pages/ShopManage/ShopManageList";
	}


	/**
	 * 跳转新增页面
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = {"/pages/ShopManageAdd"})
	public String loveAdd(){
		return "/pages/ShopManage/ShopManageAdd";
	}


	/**
	 * 跳转更新页面
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = {"/pages/ShopManageUpdate"})
	public String indexUpdate(Long id, Model model){
    model.addAttribute("shopManage",shopManageService.findById(id).getData());
    return "/pages/ShopManage/ShopManageUpdate";
	}
	/**
	 * 跳转显示页面
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = {"/pages/ShopManageShow"})
	public String indexShow(Long id,Model model){
	    model.addAttribute("shopManage",shopManageService.findById(id).getData());
		return "/pages/ShopManage/ShopManageShow";
	}

}
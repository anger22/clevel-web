package com.qiqi.jiaoyou.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qiqi.jiaoyou.pojo.GameBank;
import com.qiqi.jiaoyou.pojo.GameSelectLabel;
import com.qiqi.jiaoyou.service.GameSelectLabelService;
import com.qiqi.jiaoyou.util.ResultUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 答题游戏库选项标签(GameSelectLabel)表控制层
 *
 * @author nan
 * @since 2020-11-27 11:25:35
 */
@Controller
@RequestMapping("/gameLabel")
public class GameSelectLabelController extends ApiController {
	/**
	 * 服务对象
	 */
	@Resource
	private GameSelectLabelService gameSelectLabelService;



	@ApiOperation(value = "新增选项标签")
	@PostMapping("/add")
	@ResponseBody
	public ResultUtils add(@ModelAttribute GameSelectLabel gameSelectLabel){
		return gameSelectLabelService.add(gameSelectLabel);
	}

	@ApiOperation(value = "删除选项标签")
	@GetMapping("/delete")
	@ResponseBody
	public ResultUtils delete(Long id){
		return gameSelectLabelService.delete(id);
	}

	@ApiOperation(value = "更新选项标签")
	@PostMapping("/update")
	@ResponseBody
	public ResultUtils update(@ModelAttribute GameSelectLabel gameSelectLabel){
		return gameSelectLabelService.updateData(gameSelectLabel);
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
		return gameSelectLabelService.findListByPage(page, limit,map);
	}

	@GetMapping("/findListByAll")
	@ResponseBody
	public ResultUtils findListByAll(){
		return gameSelectLabelService.findListByAll();
	}	/**
	 *
	 * 跳转列表页面
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = {"/pages/GameLabelList"})
	public String index(){
		return "/pages/GameLabel/GameLabelList";
	}

	/**
	 * 跳转添加页面
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/pages/GameLabelAdd")
	public String accountAdd(){

		return"/pages/GameLabel/GameLabelAdd";
	}



	/**
	 * 跳转修改页面
	 * @param id  实体ID
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/pages/GameLabelUpdate")
	public String accountUpdate(Long id, Model model){
		model.addAttribute("gameLabel", gameSelectLabelService.findById(id).getData());
		return"/pages/GameLabel/GameLabelUpdate";
	}}
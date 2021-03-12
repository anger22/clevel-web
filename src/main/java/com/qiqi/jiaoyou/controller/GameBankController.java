package com.qiqi.jiaoyou.controller;

import com.baomidou.mybatisplus.extension.api.ApiController;
import com.qiqi.jiaoyou.pojo.GameBank;
import com.qiqi.jiaoyou.pojo.Gift;
import com.qiqi.jiaoyou.service.GameBankService;
import com.qiqi.jiaoyou.util.ResultUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * 答题游戏题库(GameBank)表控制层
 *
 * @author nan
 * @since 2020-11-27 11:12:55
 */
@Controller
@RequestMapping("/gameBank")
public class GameBankController extends ApiController {
	/**
	 * 服务对象
	 */
	@Resource
	private GameBankService gameBankService;


	@ApiOperation(value = "新增游戏标签")
	@PostMapping("/add")
	@ResponseBody
	public ResultUtils add(@ModelAttribute GameBank gameBank){
		return gameBankService.add(gameBank);
	}

	@ApiOperation(value = "删除游戏标签")
	@GetMapping("/delete")
	@ResponseBody
	public ResultUtils delete(Long id){
		return gameBankService.delete(id);
	}

	@ApiOperation(value = "更新游戏标签")
	@PostMapping("/update")
	@ResponseBody
	public ResultUtils update(@ModelAttribute GameBank gameBank){
		return gameBankService.updateData(gameBank);
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
		return gameBankService.findListByPage(page, limit,map);
	}

    /*查询所有*/
	@GetMapping("/findListByAll")
	@ResponseBody
	public ResultUtils findListByAll() {
		return gameBankService.findListByAll();
	}


	/**
	 * 跳转列表页面
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = {"/pages/GameBankList"})
	public String index(){
		return "/pages/GameBank/GameBankList";
	}

	/**
	 * 跳转添加页面
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/pages/GameBankAdd")
	public String accountAdd(){
		return"/pages/GameBank/GameBankAdd";
	}


	/**
	 * 跳转修改页面
	 * @param id  实体ID
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/pages/GameBankUpdate")
	public String accountUpdate(Long id, Model model){
		model.addAttribute("gameBank",gameBankService.findById(id).getData());
		return"/pages/GameBank/GameBankUpdate";
	}
}
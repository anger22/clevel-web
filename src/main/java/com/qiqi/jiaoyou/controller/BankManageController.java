package com.qiqi.jiaoyou.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.qiqi.jiaoyou.pojo.BankManage;
import com.qiqi.jiaoyou.service.BankManageService;
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
 * 银行卡管理(BankManage)表控制层
 *
 * @author nan
 * @since 2020-12-04 18:38:35
 */
@Controller
@RequestMapping("/bankManage")
public class BankManageController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private BankManageService bankManageService;

@ApiOperation(value = "新增标签")
	@PostMapping("/add")
	@ResponseBody
	public ResultUtils add(@ModelAttribute BankManage bankManage){
		return bankManageService.add(bankManage);
	}

	@ApiOperation(value = "删除标签")
	@GetMapping("/delete")
	@ResponseBody
	public ResultUtils delete(Long id){
		return bankManageService.delete(id);
	}

	@ApiOperation(value = "更新标签")
	@PostMapping("/update")
	@ResponseBody
	public ResultUtils update(@ModelAttribute BankManage bankManage){
		return bankManageService.updateData(bankManage);
	}

	@ApiOperation(value = "查询分页数据")
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
		return bankManageService.findListByPage(page, limit,map);
	}

	@GetMapping("/findListByAll")
	@ResponseBody
	public ResultUtils findListByAll(){
		return bankManageService.findListByAll();
	}	/**
	 *
	 * 跳转列表页面
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = {"/pages/BankManageList"})
	public String index(){
		return "/pages/BankManage/BankManageList";
	}

	/**
	 * 跳转添加页面
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/pages/BankManageAdd")
	public String accountAdd(){

		return"/pages/BankManage/BankManageAdd";
	}



	/**
	 * 跳转修改页面
	 * @param id  实体ID
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/pages/BankManageUpdate")
	public String accountUpdate(Long id, Model model){
		model.addAttribute("bankManage", bankManageService.findById(id).getData());
		return"/pages/BankManage/BankManageUpdate";
	}
}

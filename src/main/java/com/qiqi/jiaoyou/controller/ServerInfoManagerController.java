package com.qiqi.jiaoyou.controller;

import com.qiqi.jiaoyou.pojo.ServerInfoManager;
import com.qiqi.jiaoyou.service.ServerInfoManagerService;
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
 * 服务管理信息表(ServerInfoManager)表控制层
 *
 * @author nan
 * @since 2020-12-01 17:19:34
 */
@Controller
@RequestMapping("/serverManager")
public class ServerInfoManagerController {
    /**
     * 服务对象
     */
    @Resource
    private ServerInfoManagerService serverInfoManagerService;

    @ApiOperation(value = "置顶")
	@GetMapping("/utop")
	@ResponseBody
	public ResultUtils utop(Long id){
		return serverInfoManagerService.utop(id);
	}


@ApiOperation(value = "取消置顶")
	@GetMapping("/ntop")
	@ResponseBody
	public ResultUtils ntop(Long id){
		return serverInfoManagerService.ntop(id);
	}


	@ApiOperation(value = "新增选项标签")
	@PostMapping("/add")
	@ResponseBody
	public ResultUtils add(@ModelAttribute ServerInfoManager serverInfoManager){
		return serverInfoManagerService.add(serverInfoManager);
	}

	@ApiOperation(value = "删除选项标签")
	@GetMapping("/delete")
	@ResponseBody
	public ResultUtils delete(Long id){
		return serverInfoManagerService.delete(id);
	}

	@ApiOperation(value = "更新选项标签")
	@PostMapping("/update")
	@ResponseBody
	public ResultUtils update(@ModelAttribute ServerInfoManager serverInfoManager){
		return serverInfoManagerService.updateData(serverInfoManager);
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
		return serverInfoManagerService.findListByPage(page, limit,map);
	}
/**
	 * 跳转列表页面
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = {"/pages/ServerManageList"})
	public String index(){
		return "/pages/ServerManage/ServerManageList";
	}


	/**
	 * 跳转新增页面
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = {"/pages/ServerManageAdd"})
	public String loveAdd(){
		return "/pages/ServerManage/ServerManageAdd";
	}


	/**
	 * 跳转更新页面
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = {"/pages/ServerManageUpdate"})
	public String indexUpdate(Long id, Model model){
    model.addAttribute("serverManage",serverInfoManagerService.findById(id).getData());
    return "/pages/ServerManage/ServerManageUpdate";
	}
	/**
	 * 跳转显示页面
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = {"/pages/ServerManageShow"})
	public String indexShow(Long id,Model model){
	    model.addAttribute("serverManage",serverInfoManagerService.findById(id).getData());
		return "/pages/ServerManage/ServerManageShow";
	}}
package com.qiqi.jiaoyou.controller;

import com.qiqi.jiaoyou.pojo.ServerInfoType;
import com.qiqi.jiaoyou.service.ServerInfoTypeService;
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
import java.util.List;
import java.util.Map;

/**
 * 服务信息管理类型表(ServerInfoType)表控制层
 *
 * @author nan
 * @since 2020-12-01 17:19:38
 */
@Controller
@RequestMapping("/serverType")
public class ServerInfoTypeController {
    /**
     * 服务对象
     */
    @Resource
    private ServerInfoTypeService serverInfoTypeService;

	@ApiOperation(value = "新增选项标签")
	@PostMapping("/add")
	@ResponseBody
	public ResultUtils add(@ModelAttribute ServerInfoType serverInfoType){
		return serverInfoTypeService.add(serverInfoType);
	}

	@ApiOperation(value = "删除选项标签")
	@GetMapping("/delete")
	@ResponseBody
	public ResultUtils delete(Long id){
		return serverInfoTypeService.delete(id);
	}

	@ApiOperation(value = "获取所有的标签")
	@GetMapping("/getAll")
	@ResponseBody
	public List<ServerInfoType> getAll(){
		return serverInfoTypeService.getAllInfo();
	}

	@ApiOperation(value = "更新选项标签")
	@PostMapping("/update")
	@ResponseBody
	public ResultUtils update(@ModelAttribute ServerInfoType serverInfoType){
		return serverInfoTypeService.updateData(serverInfoType);
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
		return serverInfoTypeService.findListByPage(page, limit,map);
	}


    /**
     * 跳转列表页面
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/ServerTypeList"})
    public String index(){
        return "/pages/ServerType/ServerTypeList";
    }


    /**
     * 跳转新增页面
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/ServerTypeAdd"})
    public String loveAdd(){

        return "/pages/ServerType/ServerTypeAdd";
    }

      /**
     * 跳转更新页面
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/ServerTypeUpdate"})
   public String indexUpdate(Long id, Model model){
    model.addAttribute("serverType",serverInfoTypeService.findById(id).getData());
        return "/pages/ServerType/ServerTypeUpdate";
    }
}
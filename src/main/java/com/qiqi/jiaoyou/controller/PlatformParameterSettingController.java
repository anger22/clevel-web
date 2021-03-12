package com.qiqi.jiaoyou.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.qiqi.jiaoyou.service.IPlatformParameterSettingService;
import com.qiqi.jiaoyou.pojo.PlatformParameterSetting;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qiqi.jiaoyou.util.ResultUtils;
import java.util.HashMap;
import java.util.Map;
import java.io.UnsupportedEncodingException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 平台参数设置 前端控制器
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Api(tags = {"平台参数设置"})
@Controller
@RequestMapping("/platformParameterSetting")
public class PlatformParameterSettingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IPlatformParameterSettingService platformParameterSettingService;


    @ApiOperation(value = "新增平台参数设置")
    @PostMapping("/add")
    @ResponseBody
    public ResultUtils add(@RequestBody PlatformParameterSetting platformParameterSetting){
        return platformParameterSettingService.add(platformParameterSetting);
    }

    @ApiOperation(value = "删除平台参数设置")
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultUtils delete(@PathVariable("id") Long id){
        return platformParameterSettingService.delete(id);
    }

    @ApiOperation(value = "更新平台参数设置")
    @PostMapping("/update")
    @ResponseBody
    public ResultUtils update(@ModelAttribute PlatformParameterSetting platformParameterSetting){
        return platformParameterSettingService.updateData(platformParameterSetting);
    }

    @ApiOperation(value = "查询平台参数设置分页数据")
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
        return platformParameterSettingService.findListByPage(page, limit,map);
    }

    @ApiOperation(value = "id查询平台参数设置")
    @GetMapping("/findById")
    @ResponseBody
    public ResultUtils findById(@PathVariable Long id){
        return platformParameterSettingService.findById(id);
    }

    /**
    * 跳转列表页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/PlatformParameterSettingList"})
    public String index(){
        return "/pages/PlatformParameterSetting/PlatformParameterSettingList";
    }

    /**
    * 跳转添加页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/PlatformParameterSettingAdd")
    public String accountAdd(){
        return"/pages/PlatformParameterSetting/PlatformParameterSettingAdd";
    }

    /**
    * 跳转修改页面
    * @param id  实体ID
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/PlatformParameterSettingUpdate")
    public String accountUpdate(Model model){
        model.addAttribute("platformParameterSetting", (PlatformParameterSetting)platformParameterSettingService.findById(1L).getData());
        return"/pages/PlatformParameterSetting/PlatformParameterSettingUpdate";
    }

}

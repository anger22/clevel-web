package com.qiqi.jiaoyou.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.qiqi.jiaoyou.service.ISystemMessageService;
import com.qiqi.jiaoyou.pojo.SystemMessage;
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
 * 系统消息表 前端控制器
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Api(tags = {"系统消息表"})
@Controller
@RequestMapping("/system-message")
public class SystemMessageController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ISystemMessageService systemMessageService;


    @ApiOperation(value = "新增系统消息表")
    @PostMapping("/add")
    @ResponseBody
    public ResultUtils add(@ModelAttribute SystemMessage systemMessage){
        return systemMessageService.add(systemMessage);
    }

    @ApiOperation(value = "删除系统消息表")
    @GetMapping("/delete")
    @ResponseBody
    public ResultUtils delete(Long id){
        return systemMessageService.delete(id);
    }

    @ApiOperation(value = "更新系统消息表")
    @PostMapping("/update")
    @ResponseBody
    public ResultUtils update(@ModelAttribute SystemMessage systemMessage){
        return systemMessageService.updateData(systemMessage);
    }

    @ApiOperation(value = "查询系统消息表分页数据")
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
        return systemMessageService.findListByPage(page, limit,map);
    }

    @ApiOperation(value = "id查询系统消息表")
    @GetMapping("/findById")
    @ResponseBody
    public ResultUtils findById(@PathVariable Long id){
        return systemMessageService.findById(id);
    }

    /**
    * 跳转列表页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/SystemMessageList"})
    public String index(){
        return "/pages/SystemMessage/SystemMessageList";
    }

    /**
    * 跳转添加页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/SystemMessageAdd")
    public String accountAdd(){
        return"/pages/SystemMessage/SystemMessageAdd";
    }

    /**
    * 跳转修改页面
    * @param id  实体ID
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/SystemMessageUpdate")
    public String accountUpdate(Long id,Model model){
        model.addAttribute("systemMessage", (SystemMessage)systemMessageService.findById(id).getData());
        return"/pages/SystemMessage/SystemMessageUpdate";
    }

    /**
     * 修改启用状态
     */
    @ApiOperation(value = "修改启用状态")
    @RequestMapping(method = RequestMethod.GET, value = "/updateEnable")
    @ResponseBody
    public ResultUtils updateEnable(Integer id,Integer enableState){
        return systemMessageService.updateEnable(id,enableState);
    }

}

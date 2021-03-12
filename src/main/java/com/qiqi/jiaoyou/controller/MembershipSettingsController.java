package com.qiqi.jiaoyou.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.qiqi.jiaoyou.service.IMembershipSettingsService;
import com.qiqi.jiaoyou.pojo.MembershipSettings;
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
 * 会员设置表 前端控制器
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Api(tags = {"会员设置表"})
@Controller
@RequestMapping("/membership-settings")
public class MembershipSettingsController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IMembershipSettingsService membershipSettingsService;


    @ApiOperation(value = "新增会员设置表")
    @PostMapping("/add")
    @ResponseBody
    public ResultUtils add(@RequestBody MembershipSettings membershipSettings){
        return membershipSettingsService.add(membershipSettings);
    }

    @ApiOperation(value = "删除会员设置表")
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultUtils delete(@PathVariable("id") Long id){
        return membershipSettingsService.delete(id);
    }

    @ApiOperation(value = "更新会员设置表")
    @PutMapping("/update")
    @ResponseBody
    public ResultUtils update(@RequestBody MembershipSettings membershipSettings){
        return membershipSettingsService.updateData(membershipSettings);
    }

    @ApiOperation(value = "查询会员设置表分页数据")
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
        return membershipSettingsService.findListByPage(page, limit,map);
    }

    @ApiOperation(value = "id查询会员设置表")
    @GetMapping("/findById")
    @ResponseBody
    public ResultUtils findById(@PathVariable Long id){
        return membershipSettingsService.findById(id);
    }

    /**
    * 跳转列表页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/MembershipSettingsList"})
    public String index(){
        return "/pages/MembershipSettings/MembershipSettingsList";
    }

    /**
    * 跳转添加页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/MembershipSettingsAdd")
    public String accountAdd(){
        return"/pages/MembershipSettings/MembershipSettingsAdd";
    }

    /**
    * 跳转修改页面
    * @param id  实体ID
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/MembershipSettingsUpdate")
    public String accountUpdate(Long id,Model model){
        model.addAttribute("membershipSettings", (MembershipSettings)membershipSettingsService.findById(id).getData());
        return"/pages/MembershipSettings/MembershipSettingsUpdate";
    }

}

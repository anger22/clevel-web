package com.qiqi.jiaoyou.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.qiqi.jiaoyou.service.INewFriendService;
import com.qiqi.jiaoyou.pojo.NewFriend;
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
 * .新朋友列表 前端控制器
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Api(tags = {".新朋友列表"})
@Controller
@RequestMapping("/new-friend")
public class NewFriendController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private INewFriendService newFriendService;


    @ApiOperation(value = "新增.新朋友列表")
    @PostMapping("/add")
    @ResponseBody
    public ResultUtils add(@RequestBody NewFriend newFriend){
        return newFriendService.add(newFriend);
    }

    @ApiOperation(value = "删除.新朋友列表")
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultUtils delete(@PathVariable("id") Long id){
        return newFriendService.delete(id);
    }

    @ApiOperation(value = "更新.新朋友列表")
    @PutMapping("/update")
    @ResponseBody
    public ResultUtils update(@RequestBody NewFriend newFriend){
        return newFriendService.updateData(newFriend);
    }

    @ApiOperation(value = "查询.新朋友列表分页数据")
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
        return newFriendService.findListByPage(page, limit,map);
    }

    @ApiOperation(value = "id查询.新朋友列表")
    @GetMapping("/findById")
    @ResponseBody
    public ResultUtils findById(@PathVariable Long id){
        return newFriendService.findById(id);
    }

    /**
    * 跳转列表页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/NewFriendList"})
    public String index(){
        return "/pages/NewFriend/NewFriendList";
    }

    /**
    * 跳转添加页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/NewFriendAdd")
    public String accountAdd(){
        return"/pages/NewFriend/NewFriendAdd";
    }

    /**
    * 跳转修改页面
    * @param id  实体ID
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/NewFriendUpdate")
    public String accountUpdate(Long id,Model model){
        model.addAttribute("newFriend", (NewFriend)newFriendService.findById(id).getData());
        return"/pages/NewFriend/NewFriendUpdate";
    }

}

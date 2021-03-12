package com.qiqi.jiaoyou.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.qiqi.jiaoyou.service.ICircleOfFriendsService;
import com.qiqi.jiaoyou.pojo.CircleOfFriends;
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
 * 朋友圈动态 前端控制器
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Api(tags = {"朋友圈动态"})
@Controller
@RequestMapping("/circle-of-friends")
public class CircleOfFriendsController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ICircleOfFriendsService circleOfFriendsService;


    @ApiOperation(value = "新增朋友圈动态")
    @PostMapping("/add")
    @ResponseBody
    public ResultUtils add(@RequestBody CircleOfFriends circleOfFriends){
        return circleOfFriendsService.add(circleOfFriends);
    }

    @ApiOperation(value = "删除朋友圈动态")
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultUtils delete(@PathVariable("id") Long id){
        return circleOfFriendsService.delete(id);
    }

    @ApiOperation(value = "更新朋友圈动态")
    @PutMapping("/update")
    @ResponseBody
    public ResultUtils update(@RequestBody CircleOfFriends circleOfFriends){
        return circleOfFriendsService.updateData(circleOfFriends);
    }

    @ApiOperation(value = "查询朋友圈动态分页数据")
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
        return circleOfFriendsService.findListByPage(page, limit,map);
    }

    @ApiOperation(value = "id查询朋友圈动态")
    @GetMapping("/findById")
    @ResponseBody
    public ResultUtils findById(@PathVariable Long id){
        return circleOfFriendsService.findById(id);
    }

    /**
    * 跳转列表页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/CircleOfFriendsList"})
    public String index(){
        return "/pages/CircleOfFriends/CircleOfFriendsList";
    }

    /**
    * 跳转添加页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/CircleOfFriendsAdd")
    public String accountAdd(){
        return"/pages/CircleOfFriends/CircleOfFriendsAdd";
    }

    /**
    * 跳转修改页面
    * @param id  实体ID
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/CircleOfFriendsUpdate")
    public String accountUpdate(Long id,Model model){
        model.addAttribute("circleOfFriends", (CircleOfFriends)circleOfFriendsService.findById(id).getData());
        return"/pages/CircleOfFriends/CircleOfFriendsUpdate";
    }

}

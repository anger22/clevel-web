package com.qiqi.jiaoyou.controller;

import com.qiqi.jiaoyou.pojo.DynamicReviewOfFriendsCircle;
import com.qiqi.jiaoyou.service.IDynamicReviewOfFriendsCircleService;
import com.qiqi.jiaoyou.util.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 朋友圈动态评论表 前端控制器
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Api(tags = {"朋友圈动态评论表"})
@Controller
@RequestMapping("/dynamic-review-of-friends-circle")
public class DynamicReviewOfFriendsCircleController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IDynamicReviewOfFriendsCircleService dynamicReviewOfFriendsCircleService;


    @ApiOperation(value = "新增朋友圈动态评论表")
    @PostMapping("/add")
    @ResponseBody
    public ResultUtils add(@RequestBody DynamicReviewOfFriendsCircle dynamicReviewOfFriendsCircle){
        return dynamicReviewOfFriendsCircleService.add(dynamicReviewOfFriendsCircle);
    }

    @ApiOperation(value = "删除朋友圈动态评论表")
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultUtils delete(@PathVariable("id") Long id){
        return dynamicReviewOfFriendsCircleService.delete(id);
    }

    @ApiOperation(value = "更新朋友圈动态评论表")
    @PutMapping("/update")
    @ResponseBody
    public ResultUtils update(@RequestBody DynamicReviewOfFriendsCircle dynamicReviewOfFriendsCircle){
        return dynamicReviewOfFriendsCircleService.updateData(dynamicReviewOfFriendsCircle);
    }

    @ApiOperation(value = "查询朋友圈动态评论表分页数据")
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
        return dynamicReviewOfFriendsCircleService.findListByPage(page, limit,map);
    }
 @ApiOperation(value = "查询记录用来查看信息的地方")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping("/findListByPageS")
    @ResponseBody
    public ResultUtils findListByPageS(@RequestParam Integer page,
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
        return dynamicReviewOfFriendsCircleService.findListByPageS(page, limit,map);
    }
    @ApiOperation(value = "id查询朋友圈动态评论表")
    @GetMapping("/findById")
    @ResponseBody
    public ResultUtils findById(@PathVariable Long id){
        return dynamicReviewOfFriendsCircleService.findById(id);
    }

    /**
    * 跳转列表页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/DynamicReviewOfFriendsCircleList"})
    public String index(){
        return "/pages/DynamicReviewOfFriendsCircle/DynamicReviewOfFriendsCircleList";
    }

    /**
    * 跳转添加页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/DynamicReviewOfFriendsCircleAdd")
    public String accountAdd(){
        return"/pages/DynamicReviewOfFriendsCircle/DynamicReviewOfFriendsCircleAdd";
    }

    /**
    * 跳转修改页面
    * @param id  实体ID
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/DynamicReviewOfFriendsCircleUpdate")
    public String accountUpdate(Long id,Model model){
        model.addAttribute("dynamicReviewOfFriendsCircle", (DynamicReviewOfFriendsCircle)dynamicReviewOfFriendsCircleService.findById(id).getData());
        return"/pages/DynamicReviewOfFriendsCircle/DynamicReviewOfFriendsCircleUpdate";
    }

}

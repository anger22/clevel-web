package com.qiqi.jiaoyou.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.qiqi.jiaoyou.service.IDynamicCommentsOfCarUsersService;
import com.qiqi.jiaoyou.pojo.DynamicCommentsOfCarUsers;
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
 * 车友动态评论表 前端控制器
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Api(tags = {"车友动态评论表"})
@Controller
@RequestMapping("/dynamic-comments-of-car-users")
public class DynamicCommentsOfCarUsersController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IDynamicCommentsOfCarUsersService dynamicCommentsOfCarUsersService;


    @ApiOperation(value = "新增车友动态评论表")
    @PostMapping("/add")
    @ResponseBody
    public ResultUtils add(@RequestBody DynamicCommentsOfCarUsers dynamicCommentsOfCarUsers){
        return dynamicCommentsOfCarUsersService.add(dynamicCommentsOfCarUsers);
    }

    @ApiOperation(value = "删除车友动态评论表")
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultUtils delete(@PathVariable("id") Long id){
        return dynamicCommentsOfCarUsersService.delete(id);
    }

    @ApiOperation(value = "更新车友动态评论表")
    @PutMapping("/update")
    @ResponseBody
    public ResultUtils update(@RequestBody DynamicCommentsOfCarUsers dynamicCommentsOfCarUsers){
        return dynamicCommentsOfCarUsersService.updateData(dynamicCommentsOfCarUsers);
    }

    @ApiOperation(value = "查询车友动态评论表分页数据")
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
        return dynamicCommentsOfCarUsersService.findListByPage(page, limit,map);
    }

    @ApiOperation(value = "id查询车友动态评论表")
    @GetMapping("/findById")
    @ResponseBody
    public ResultUtils findById(@PathVariable Long id){
        return dynamicCommentsOfCarUsersService.findById(id);
    }

    /**
    * 跳转列表页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/DynamicCommentsOfCarUsersList"})
    public String index(){
        return "/pages/DynamicCommentsOfCarUsers/DynamicCommentsOfCarUsersList";
    }

    /**
    * 跳转添加页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/DynamicCommentsOfCarUsersAdd")
    public String accountAdd(){
        return"/pages/DynamicCommentsOfCarUsers/DynamicCommentsOfCarUsersAdd";
    }

    /**
    * 跳转修改页面
    * @param id  实体ID
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/DynamicCommentsOfCarUsersUpdate")
    public String accountUpdate(Long id,Model model){
        model.addAttribute("dynamicCommentsOfCarUsers", (DynamicCommentsOfCarUsers)dynamicCommentsOfCarUsersService.findById(id).getData());
        return"/pages/DynamicCommentsOfCarUsers/DynamicCommentsOfCarUsersUpdate";
    }

}

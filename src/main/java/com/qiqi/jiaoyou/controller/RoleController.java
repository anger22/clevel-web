package com.qiqi.jiaoyou.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.qiqi.jiaoyou.service.IRoleService;
import com.qiqi.jiaoyou.pojo.Role;
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
 * 角色表 前端控制器
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Api(tags = {"角色表"})
@Controller
@RequestMapping("/role")
public class RoleController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IRoleService roleService;


    @ApiOperation(value = "新增角色表")
    @PostMapping("/add")
    @ResponseBody
    public ResultUtils add(@ModelAttribute Role role){
        return roleService.add(role);
    }

    @ApiOperation(value = "删除角色表")
    @GetMapping("/delete")
    @ResponseBody
    public ResultUtils delete(Long id){
        return roleService.delete(id);
    }

    @ApiOperation(value = "更新角色表")
    @PostMapping("/update")
    @ResponseBody
    public ResultUtils update(@ModelAttribute Role role){
        return roleService.updateData(role);
    }

    @ApiOperation(value = "查询角色表分页数据")
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
        return roleService.findListByPage(page, limit,map);
    }

    @ApiOperation(value = "id查询角色表")
    @GetMapping("/findById")
    @ResponseBody
    public ResultUtils findById(@PathVariable Long id){
        return roleService.findById(id);
    }

    @ApiOperation(value = "查询所有可用角色，用于下拉框")
    @GetMapping("/selectAllRole")
    @ResponseBody
    public ResultUtils selectAllRole(){
        return roleService.selectAllRole();
    }

    /**
    * 跳转列表页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/RoleList"})
    public String index(){
        return "/pages/Role/RoleList";
    }

    /**
    * 跳转添加页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/RoleAdd")
    public String accountAdd(){
        return"/pages/Role/RoleAdd";
    }

    /**
    * 跳转修改页面
    * @param id  实体ID
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/RoleUpdate")
    public String accountUpdate(Long id,Model model){
        model.addAttribute("role", (Role)roleService.findById(id).getData());
        return"/pages/Role/RoleUpdate";
    }

    /**
     * 修改启用状态
     */
    @ApiOperation(value = "修改启用状态")
    @RequestMapping(method = RequestMethod.GET, value = "/updateEnable")
    @ResponseBody
    public ResultUtils updateEnable(Integer id,Integer enableState){
        return roleService.updateEnable(id,enableState);
    }

}

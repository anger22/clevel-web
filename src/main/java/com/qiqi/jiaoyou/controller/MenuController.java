package com.qiqi.jiaoyou.controller;

import com.qiqi.jiaoyou.config.MybatisRedisCache;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.ibatis.annotations.CacheNamespace;
import org.springframework.web.bind.annotation.*;
import com.qiqi.jiaoyou.service.IMenuService;
import com.qiqi.jiaoyou.pojo.Menu;
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
 * 菜单表 前端控制器
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Api(tags = {"菜单表"})
@Controller
@RequestMapping("/menu")
public class MenuController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IMenuService menuService;


    @ApiOperation(value = "新增菜单表")
    @PostMapping("/add")
    @ResponseBody
    public ResultUtils add(@ModelAttribute Menu menu){
        System.out.println(menu.toString());
        return menuService.add(menu);
    }

    @ApiOperation(value = "删除菜单表")
    @GetMapping("/delete")
    @ResponseBody
    public ResultUtils delete(Long id){
        return menuService.delete(id);
    }

    @ApiOperation(value = "更新菜单表")
    @PostMapping("/update")
    @ResponseBody
    public ResultUtils update(@ModelAttribute Menu menu){
        System.out.println(menu.toString());
        return menuService.updateData(menu);
    }

    @ApiOperation(value = "查询所有一级菜单")
    @GetMapping("/selectLevelIsOne")
    @ResponseBody
    public ResultUtils selectLevelIsOne(){
        return menuService.selectLevelIsOne();
    }


    @ApiOperation(value = "根据一级菜单查询二级菜单")
    @PostMapping("/selectLevelIsTwo")
    @ResponseBody
    public ResultUtils selectLevelIsTwo( @RequestParam Long id){
        return menuService.selectLevelIsTwo(id);
    }

    @ApiOperation(value = "查询所有一及以及二级")
    @GetMapping("/selectLevelIsOneAndTwo")
    @ResponseBody
    public ResultUtils selectLevelIsOneAndTwo(){
        return menuService.selectLevelIsOneAndTwo();
    }

    @ApiOperation(value = "查询菜单表分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "limit", value = "每页条数")
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
        return menuService.findListByPage(page, limit,map);
    }

    @ApiOperation(value = "id查询菜单表")
    @GetMapping("/findById")
    @ResponseBody
    public ResultUtils findById(@PathVariable Long id){
        return menuService.findById(id);
    }

    /**
    * 跳转列表页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/MenuList"})
    public String index(){
        return "/pages/Menu/MenuList";
    }

    /**
    * 跳转添加页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/MenuAdd")
    public String accountAdd(){
        return"/pages/Menu/MenuAdd";
    }

    /**
    * 跳转修改页面
    * @param id  实体ID
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/MenuUpdate")
    public String accountUpdate(Long id,Model model){
        model.addAttribute("menu", (Menu)menuService.findById(id).getData());
        return"/pages/Menu/MenuUpdate";
    }

}

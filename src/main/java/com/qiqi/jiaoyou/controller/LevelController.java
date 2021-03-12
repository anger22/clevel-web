package com.qiqi.jiaoyou.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.qiqi.jiaoyou.service.ILevelService;
import com.qiqi.jiaoyou.pojo.Level;
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
 * 等级表 前端控制器
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Api(tags = {"等级表"})
@Controller
@RequestMapping("/level")
public class LevelController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ILevelService levelService;


    @ApiOperation(value = "新增等级表")
    @PostMapping("/add")
    @ResponseBody
    public ResultUtils add(@ModelAttribute Level level){
        return levelService.add(level);
    }

    @ApiOperation(value = "删除等级表")
    @GetMapping("/delete")
    @ResponseBody
    public ResultUtils delete(Long id){
        return levelService.delete(id);
    }

    @ApiOperation(value = "更新等级表")
    @PostMapping("/update")
    @ResponseBody
    public ResultUtils update(@ModelAttribute Level level){
        return levelService.updateData(level);
    }

    @ApiOperation(value = "查询等级表分页数据")
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
        return levelService.findListByPage(page, limit,map);
    }

    @ApiOperation(value = "id查询等级表")
    @GetMapping("/findById")
    @ResponseBody
    public ResultUtils findById(@PathVariable Long id){
        return levelService.findById(id);
    }

    /**
    * 跳转列表页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/LevelList"})
    public String index(){
        return "/pages/Level/LevelList";
    }

    /**
    * 跳转添加页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/LevelAdd")
    public String accountAdd(){
        return"/pages/Level/LevelAdd";
    }

    /**
    * 跳转修改页面
    * @param id  实体ID
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/LevelUpdate")
    public String accountUpdate(Long id,Model model){
        model.addAttribute("level", (Level)levelService.findById(id).getData());
        return"/pages/Level/LevelUpdate";
    }

}

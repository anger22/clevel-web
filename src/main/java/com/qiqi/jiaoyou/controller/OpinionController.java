package com.qiqi.jiaoyou.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.qiqi.jiaoyou.service.IOpinionService;
import com.qiqi.jiaoyou.pojo.Opinion;
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
 * 意见表 前端控制器
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Api(tags = {"意见表"})
@Controller
@RequestMapping("/opinion")
public class OpinionController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IOpinionService opinionService;


    @ApiOperation(value = "新增意见表")
    @PostMapping("/add")
    @ResponseBody
    public ResultUtils add(@ModelAttribute Opinion opinion){
        return opinionService.add(opinion);
    }

    @ApiOperation(value = "删除意见表")
    @GetMapping("/delete")
    @ResponseBody
    public ResultUtils delete(@PathVariable("id") Long id){
        return opinionService.delete(id);
    }

    @ApiOperation(value = "更新意见表")
    @PostMapping("/update")
    @ResponseBody
    public ResultUtils update(@ModelAttribute Opinion opinion){
        return opinionService.updateData(opinion);
    }

    @ApiOperation(value = "查询意见表分页数据")
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
        return opinionService.findListByPage(page, limit,map);
    }

    @ApiOperation(value = "id查询意见表")
    @GetMapping("/findById")
    @ResponseBody
    public ResultUtils findById(@PathVariable Long id){
        return opinionService.findById(id);
    }

    /**
    * 跳转列表页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/OpinionList"})
    public String index(){
        return "/pages/Opinion/OpinionList";
    }

    /**
    * 跳转查看反馈内容页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/OpinionRead")
    public String accountAdd(String context,Model model){
        model.addAttribute("context",context);
        return"/pages/Opinion/OpinionRead";
    }

    /**
    * 跳转修改页面
    * @param id  实体ID
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/OpinionUpdate")
    public String accountUpdate(Long id,Model model){
        model.addAttribute("opinion", (Opinion)opinionService.findById(id).getData());
        return"/pages/Opinion/OpinionUpdate";
    }

}

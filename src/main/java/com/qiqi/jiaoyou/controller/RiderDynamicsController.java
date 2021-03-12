package com.qiqi.jiaoyou.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.qiqi.jiaoyou.service.IRiderDynamicsService;
import com.qiqi.jiaoyou.pojo.RiderDynamics;
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
 * 车友圈动态 前端控制器
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Api(tags = {"车友圈动态"})
@Controller
@RequestMapping("/rider-dynamics")
public class RiderDynamicsController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IRiderDynamicsService riderDynamicsService;


    @ApiOperation(value = "新增车友圈动态")
    @PostMapping("/add")
    @ResponseBody
    public ResultUtils add(@RequestBody RiderDynamics riderDynamics){
        return riderDynamicsService.add(riderDynamics);
    }

    @ApiOperation(value = "删除车友圈动态")
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultUtils delete(@PathVariable("id") Long id){
        return riderDynamicsService.delete(id);
    }

    @ApiOperation(value = "更新车友圈动态")
    @PutMapping("/update")
    @ResponseBody
    public ResultUtils update(@RequestBody RiderDynamics riderDynamics){
        return riderDynamicsService.updateData(riderDynamics);
    }

    @ApiOperation(value = "查询车友圈动态分页数据")
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
        return riderDynamicsService.findListByPage(page, limit,map);
    }

    @ApiOperation(value = "id查询车友圈动态")
    @GetMapping("/findById")
    @ResponseBody
    public ResultUtils findById(@PathVariable Long id){
        return riderDynamicsService.findById(id);
    }

    /**
    * 跳转列表页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/RiderDynamicsList"})
    public String index(){
        return "/pages/RiderDynamics/RiderDynamicsList";
    }

    /**
    * 跳转添加页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/RiderDynamicsAdd")
    public String accountAdd(){
        return"/pages/RiderDynamics/RiderDynamicsAdd";
    }

    /**
    * 跳转修改页面
    * @param id  实体ID
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/RiderDynamicsUpdate")
    public String accountUpdate(Long id,Model model){
        model.addAttribute("riderDynamics", (RiderDynamics)riderDynamicsService.findById(id).getData());
        return"/pages/RiderDynamics/RiderDynamicsUpdate";
    }

}

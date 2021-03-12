package com.qiqi.jiaoyou.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.qiqi.jiaoyou.service.IProportionofwithdrawalService;
import com.qiqi.jiaoyou.pojo.Proportionofwithdrawal;
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
 * 提现比例表 前端控制器
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Api(tags = {"提现比例表"})
@Controller
@RequestMapping("/proportionofwithdrawal")
public class ProportionofwithdrawalController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IProportionofwithdrawalService proportionofwithdrawalService;


    @ApiOperation(value = "新增提现比例表")
    @PostMapping("/add")
    @ResponseBody
    public ResultUtils add(@ModelAttribute Proportionofwithdrawal proportionofwithdrawal){
        return proportionofwithdrawalService.add(proportionofwithdrawal);
    }

    @ApiOperation(value = "删除提现比例表")
    @GetMapping("/delete")
    @ResponseBody
    public ResultUtils delete(Long id){
        return proportionofwithdrawalService.delete(id);
    }

    @ApiOperation(value = "更新提现比例表")
    @PostMapping("/update")
    @ResponseBody
    public ResultUtils update(@ModelAttribute Proportionofwithdrawal proportionofwithdrawal){
        return proportionofwithdrawalService.updateData(proportionofwithdrawal);
    }

    @ApiOperation(value = "查询提现比例表分页数据")
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
        return proportionofwithdrawalService.findListByPage(page, limit,map);
    }

    @ApiOperation(value = "id查询提现比例表")
    @GetMapping("/findById")
    @ResponseBody
    public ResultUtils findById(@PathVariable Long id){
        return proportionofwithdrawalService.findById(id);
    }

    /**
    * 跳转列表页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/ProportionofwithdrawalList"})
    public String index(){
        return "/pages/Proportionofwithdrawal/ProportionofwithdrawalList";
    }

    /**
    * 跳转添加页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/ProportionofwithdrawalAdd")
    public String accountAdd(){
        return"/pages/Proportionofwithdrawal/ProportionofwithdrawalAdd";
    }

    /**
    * 跳转修改页面
    * @param id  实体ID
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/ProportionofwithdrawalUpdate")
    public String accountUpdate(Long id,Model model){
        model.addAttribute("proportionofwithdrawal", (Proportionofwithdrawal)proportionofwithdrawalService.findById(id).getData());
        return"/pages/Proportionofwithdrawal/ProportionofwithdrawalUpdate";
    }

}

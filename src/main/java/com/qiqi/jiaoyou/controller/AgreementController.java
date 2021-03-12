package com.qiqi.jiaoyou.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;
import com.qiqi.jiaoyou.service.IAgreementService;
import com.qiqi.jiaoyou.pojo.Agreement;
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
 * 协议表 前端控制器
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Api(tags = {"协议表"})
@Controller
@RequestMapping("/agreement")
public class AgreementController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IAgreementService agreementService;


    @ApiOperation(value = "新增协议表")
    @PostMapping("/add")
    @ResponseBody
    public ResultUtils add(@ModelAttribute Agreement agreement){
        return agreementService.add(agreement);
    }

    @ApiOperation(value = "删除协议表")
    @GetMapping("/delete")
    @ResponseBody
    public ResultUtils delete(@PathVariable("id") Long id){
        return agreementService.delete(id);
    }

    @ApiOperation(value = "更新协议表")
    @PostMapping("/update")
    @ResponseBody
    public ResultUtils update(@ModelAttribute Agreement agreement){
        return agreementService.updateData(agreement);
    }

    @ApiOperation(value = "查询协议表分页数据")
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
        return agreementService.findListByPage(page, limit,map);
    }

    @ApiOperation(value = "id查询协议表")
    @GetMapping("/findById")
    @ResponseBody
    public ResultUtils findById(@PathVariable Long id){
        return agreementService.findById(id);
    }

    /**
    * 跳转列表页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/AgreementList"})
    public String index(){
        return "/pages/Agreement/AgreementList";
    }

    /**
    * 跳转添加页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/AgreementAdd")
    public String accountAdd(){
        return"/pages/Agreement/AgreementAdd";
    }

    /**
    * 跳转修改页面
    * @param id  实体ID
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/AgreementUpdate")
    public String accountUpdate(Long id, Integer type ,Model model){
        model.addAttribute("agreement", (Agreement)agreementService.findById(id).getData());
        model.addAttribute("type", type);
        return"/pages/Agreement/AgreementUpdate";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/registrationAgreement")
    public String registrationAgreement(Model model){
        return "/pages/registration";
    }

}

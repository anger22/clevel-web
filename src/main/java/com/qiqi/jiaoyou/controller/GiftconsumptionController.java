package com.qiqi.jiaoyou.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.qiqi.jiaoyou.service.IGiftconsumptionService;
import com.qiqi.jiaoyou.pojo.Giftconsumption;
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
 * 礼物记录表 前端控制器
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Api(tags = {"礼物记录表"})
@Controller
@RequestMapping("/giftconsumption")
public class GiftconsumptionController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IGiftconsumptionService giftconsumptionService;


    @ApiOperation(value = "新增礼物记录表")
    @PostMapping("/add")
    @ResponseBody
    public ResultUtils add(@RequestBody Giftconsumption giftconsumption){
        return giftconsumptionService.add(giftconsumption);
    }

    @ApiOperation(value = "删除礼物记录表")
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultUtils delete(@PathVariable("id") Long id){
        return giftconsumptionService.delete(id);
    }

    @ApiOperation(value = "更新礼物记录表")
    @PutMapping("/update")
    @ResponseBody
    public ResultUtils update(@RequestBody Giftconsumption giftconsumption){
        return giftconsumptionService.updateData(giftconsumption);
    }

    @ApiOperation(value = "查询礼物记录表分页数据")
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
        return giftconsumptionService.findListByPage(page, limit,map);
    }

    @ApiOperation(value = "id查询礼物记录表")
    @GetMapping("/findById")
    @ResponseBody
    public ResultUtils findById(@PathVariable Long id){
        return giftconsumptionService.findById(id);
    }

    /**
    * 跳转列表页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/GiftconsumptionList"})
    public String index(){
        return "/pages/Giftconsumption/GiftconsumptionList";
    }

    /**
    * 跳转添加页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/GiftconsumptionAdd")
    public String accountAdd(){
        return"/pages/Giftconsumption/GiftconsumptionAdd";
    }

    /**
    * 跳转修改页面
    * @param id  实体ID
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/GiftconsumptionUpdate")
    public String accountUpdate(Long id,Model model){
        model.addAttribute("giftconsumption", (Giftconsumption)giftconsumptionService.findById(id).getData());
        return"/pages/Giftconsumption/GiftconsumptionUpdate";
    }

}

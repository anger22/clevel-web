package com.qiqi.jiaoyou.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.qiqi.jiaoyou.service.ISpeakerconsumptionrecordService;
import com.qiqi.jiaoyou.pojo.Speakerconsumptionrecord;
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
 * 喇叭消费记录 前端控制器
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Api(tags = {"喇叭消费记录"})
@Controller
@RequestMapping("/speakerconsumptionrecord")
public class SpeakerconsumptionrecordController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ISpeakerconsumptionrecordService speakerconsumptionrecordService;


    @ApiOperation(value = "新增喇叭消费记录")
    @PostMapping("/add")
    @ResponseBody
    public ResultUtils add(@RequestBody Speakerconsumptionrecord speakerconsumptionrecord){
        return speakerconsumptionrecordService.add(speakerconsumptionrecord);
    }

    @ApiOperation(value = "删除喇叭消费记录")
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultUtils delete(@PathVariable("id") Long id){
        return speakerconsumptionrecordService.delete(id);
    }

    @ApiOperation(value = "更新喇叭消费记录")
    @PutMapping("/update")
    @ResponseBody
    public ResultUtils update(@RequestBody Speakerconsumptionrecord speakerconsumptionrecord){
        return speakerconsumptionrecordService.updateData(speakerconsumptionrecord);
    }

    @ApiOperation(value = "查询喇叭消费记录分页数据")
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
        return speakerconsumptionrecordService.findListByPage(page, limit,map);
    }

    @ApiOperation(value = "id查询喇叭消费记录")
    @GetMapping("/findById")
    @ResponseBody
    public ResultUtils findById(@PathVariable Long id){
        return speakerconsumptionrecordService.findById(id);
    }

    /**
    * 跳转列表页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/SpeakerconsumptionrecordList"})
    public String index(){
        return "/pages/Speakerconsumptionrecord/SpeakerconsumptionrecordList";
    }

    /**
    * 跳转添加页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/SpeakerconsumptionrecordAdd")
    public String accountAdd(){
        return"/pages/Speakerconsumptionrecord/SpeakerconsumptionrecordAdd";
    }

    /**
    * 跳转修改页面
    * @param id  实体ID
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/SpeakerconsumptionrecordUpdate")
    public String accountUpdate(Long id,Model model){
        model.addAttribute("speakerconsumptionrecord", (Speakerconsumptionrecord)speakerconsumptionrecordService.findById(id).getData());
        return"/pages/Speakerconsumptionrecord/SpeakerconsumptionrecordUpdate";
    }

}

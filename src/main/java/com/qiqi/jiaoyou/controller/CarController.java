package com.qiqi.jiaoyou.controller;

import com.qiqi.jiaoyou.pojo.Member;
import com.qiqi.jiaoyou.service.IMemberService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.qiqi.jiaoyou.service.ICarService;
import com.qiqi.jiaoyou.pojo.Car;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * 车辆表 前端控制器
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Api(tags = {"车辆表"})
@Controller
@RequestMapping("/car")
public class CarController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ICarService carService;
    @Resource
    private IMemberService memberService;


    @ApiOperation(value = "新增车辆表")
    @PostMapping("/add")
    @ResponseBody
    public ResultUtils add(@ModelAttribute Car car){
        return carService.add(car);
    }

    @ApiOperation(value = "删除车辆表")
    @GetMapping("/delete")
    @ResponseBody
    public ResultUtils delete(Long id){
        return carService.delete(id);
    }

    @ApiOperation(value = "更新车辆表")
    @PostMapping("/update")
    @ResponseBody
    public ResultUtils update(@ModelAttribute Car car){
        return carService.updateData(car);
    }

    @ApiOperation(value = "查询车辆表分页数据")
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
        return carService.findListByPage(page, limit,map);
    }

    @ApiOperation(value = "id查询车辆表")
    @GetMapping("/findById")
    @ResponseBody
    public ResultUtils findById(@PathVariable Long id){
        return carService.findById(id);
    }

    /**
    * 跳转列表页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/CarList"})
    public String index(){
        return "/pages/Car/CarList";
    }

    /**
    * 跳转添加页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/CarAdd")
    public String accountAdd(){
        return"/pages/Car/CarAdd";
    }

    /**
    * 跳转修改页面
    * @param id  实体ID
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/CarUpdate")
    public String accountUpdate(Long id,Model model){
        Car car = (Car)carService.findById(id).getData();
        model.addAttribute("car", car);
        model.addAttribute("member",(Member)memberService.findById(Long.valueOf(car.getMemberId())).getData());
        return"/pages/Car/CarUpdate";
    }

}

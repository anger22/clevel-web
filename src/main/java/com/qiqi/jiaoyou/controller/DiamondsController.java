package com.qiqi.jiaoyou.controller;


import com.qiqi.jiaoyou.mapper.PlatformParameterSettingMapper;
import com.qiqi.jiaoyou.pojo.Diamonds;
import com.qiqi.jiaoyou.pojo.PlatformParameterSetting;
import com.qiqi.jiaoyou.service.IDiamondsService;
import com.qiqi.jiaoyou.util.ResultUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author GR123
 * @since 2020-07-15
 */
@Controller
@RequestMapping("/diamonds")
public class DiamondsController {

    @Resource
    private IDiamondsService diamondsService;
    @Autowired
    private PlatformParameterSettingMapper platformParameterSettingMapper;


    @ApiOperation(value = "新增app会员表")
    @PostMapping("/add")
    @ResponseBody
    public ResultUtils add(@ModelAttribute Diamonds diamonds) {
        return diamondsService.add(diamonds);
    }

    @ApiOperation(value = "删除app会员表")
    @GetMapping("/delete")
    @ResponseBody
    public ResultUtils delete(Integer id) {
        return diamondsService.delete(id);
    }

    @ApiOperation(value = "更新app会员表")
    @PostMapping("/update")
    @ResponseBody
    public ResultUtils update(@ModelAttribute Diamonds diamonds) {
        return diamondsService.updateData(diamonds);
    }


    @ApiOperation(value = "查询金额分页数据")
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
                    map.put(split1[0], split1[1]);
                }
            }
        }
        return diamondsService.findListByPage(page, limit, map);
    }

    @ApiOperation(value = "id查询金额表")
    @GetMapping("/findById")
    @ResponseBody
    public ResultUtils findById(@PathVariable Long id) {
        return diamondsService.findById(id);
    }


    /**
     * 跳转列表页面
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/AndroidDiamondsList"})
    public String index() {
        return "/pages/Diamonds/AndroidDiamondsList";
    }

    /**
     * 跳转列表页面
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/AppleDiamondsList"})
    public String index2() {
        return "/pages/Diamonds/AppleDiamondsList";
    }

    /**
     * 跳转列表页面
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/AndroidMemberList"})
    public String index3() {
        return "/pages/Diamonds/AndroidMemberList";
    }

    /**
     * 跳转列表页面
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/AppleMemberList"})
    public String index4() {
        return "/pages/Diamonds/AppleMemberList";
    }

    /**
     * 跳转列表页面
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/AndroidBlackList"})
    public String index5() {
        return "/pages/Diamonds/AndroidBlackList";
    }

    /**
     * 跳转列表页面
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/AppleBlackList"})
    public String index6() {
        return "/pages/Diamonds/AppleBlackList";
    }


    /**
     * 跳转修改页面
     *
     * @param id 实体ID
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/DiamondsUpdate")
    public String accountUpdate(Long id, Model model) {
        Diamonds diamonds = (Diamonds) diamondsService.findById(id).getData();
        model.addAttribute("diamonds", diamonds);
        PlatformParameterSetting platformParameterSetting = platformParameterSettingMapper.selectById(1);
        Integer goldDiamondsPerYuan = platformParameterSetting.getGoldDiamondsPerYuan();
        model.addAttribute("yuan", goldDiamondsPerYuan);
        return "/pages/Diamonds/DiamondsUpdate";
    }


    /**
     * 跳转新增页面
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/DiamondsAdd")
    public String accountUpdate(Integer terminal, Integer type, Model model) {
        model.addAttribute("terminal", terminal);
        model.addAttribute("type", type);
        PlatformParameterSetting platformParameterSetting = platformParameterSettingMapper.selectById(1);
        Integer goldDiamondsPerYuan = platformParameterSetting.getGoldDiamondsPerYuan();
        model.addAttribute("yuan", goldDiamondsPerYuan);
        return "/pages/Diamonds/DiamondsAdd";
    }

}


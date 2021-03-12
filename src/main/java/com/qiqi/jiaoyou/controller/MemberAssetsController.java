package com.qiqi.jiaoyou.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.qiqi.jiaoyou.service.IMemberAssetsService;
import com.qiqi.jiaoyou.pojo.MemberAssets;
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
 * 会员资产表 前端控制器
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Api(tags = {"会员资产表"})
@Controller
@RequestMapping("/member-assets")
public class MemberAssetsController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IMemberAssetsService memberAssetsService;


    @ApiOperation(value = "新增会员资产表")
    @PostMapping("/add")
    @ResponseBody
    public ResultUtils add(@RequestBody MemberAssets memberAssets){
        return memberAssetsService.add(memberAssets);
    }

    @ApiOperation(value = "删除会员资产表")
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultUtils delete(@PathVariable("id") Long id){
        return memberAssetsService.delete(id);
    }

    @ApiOperation(value = "更新会员资产表")
    @PutMapping("/update")
    @ResponseBody
    public ResultUtils update(@RequestBody MemberAssets memberAssets){
        return memberAssetsService.updateData(memberAssets);
    }

    @ApiOperation(value = "查询会员资产表分页数据")
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
        return memberAssetsService.findListByPage(page, limit,map);
    }

    @ApiOperation(value = "id查询会员资产表")
    @GetMapping("/findById")
    @ResponseBody
    public ResultUtils findById(@PathVariable Long id){
        return memberAssetsService.findById(id);
    }

    /**
    * 跳转列表页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/MemberAssetsList"})
    public String index(){
        return "/pages/MemberAssets/MemberAssetsList";
    }

    /**
    * 跳转添加页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/MemberAssetsAdd")
    public String accountAdd(){
        return"/pages/MemberAssets/MemberAssetsAdd";
    }

    /**
    * 跳转修改页面
    * @param id  实体ID
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/MemberAssetsUpdate")
    public String accountUpdate(Long id,Model model){
        model.addAttribute("memberAssets", (MemberAssets)memberAssetsService.findById(id).getData());
        return"/pages/MemberAssets/MemberAssetsUpdate";
    }

}

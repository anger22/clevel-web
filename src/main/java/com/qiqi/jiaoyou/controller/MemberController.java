package com.qiqi.jiaoyou.controller;

import com.qiqi.jiaoyou.pojo.Member;
import com.qiqi.jiaoyou.service.IMemberService;
import com.qiqi.jiaoyou.util.ResultUtils;
import com.qiqi.jiaoyou.vo.MemberVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * app会员表 前端控制器
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Api(tags = {"app会员表"})
@Controller
@RequestMapping("/member")
public class MemberController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IMemberService memberService;


    @ApiOperation(value = "新增app会员表")
    @PostMapping("/add")
    @ResponseBody
    public ResultUtils add(@ModelAttribute Member member){
        return memberService.add(member);
    }

    @ApiOperation(value = "删除app会员表")
    @GetMapping("/delete")
    @ResponseBody
    public ResultUtils delete(Integer id){
        return memberService.delete(id);
    }

    @ApiOperation(value = "更新app会员表")
    @PostMapping("/update")
    @ResponseBody
//    public ResultUtils update(Member member){
    public ResultUtils update(@ModelAttribute Member member){
//        return memberService.updateDataA(member);
        return memberService.updateShitInfo(member);
    }

    /*这是批量删除的操作*/
    @ApiOperation(value = "批量删除账户的所有信息")
    @PostMapping("/delMore")
    @ResponseBody
    public ResultUtils delMore(String array){
        return memberService.delMore(array);
    }


 @ApiOperation(value = "更新用户钻石数和会员时间")
    @PostMapping("/updateGlod")
    @ResponseBody
    public ResultUtils update(@RequestParam("id") Integer userId,
                              @RequestParam("GoldNumber") Integer glod,
                              @RequestParam("silverNumber") Integer silver,
                              @RequestParam("vipEndTime") String endTime){
        return memberService.updateGold(userId,glod,silver,endTime);
    }
    @ApiOperation(value = "查询app会员表分页数据")
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
        return memberService.findListByPage(page, limit,map);
    }

    @ApiOperation(value = "id查询app会员表")
    @GetMapping("/findById")
    @ResponseBody
    public ResultUtils findById(@PathVariable Long id){
        return memberService.findById(id);
    }

    /**
    * 跳转列表页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/MemberList"})
    public String index(){
        return "/pages/Member/MemberList";
    }

    /**
     * 跳转交易页面
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/TransactionDetails"})
    public String TransactionDetails(Integer id,Model model){
        model.addAttribute("id",id);
        return "/pages/Member/TransactionDetails";
    }

    /**
     * 跳转颜值注册审核页面
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/LooksList"})
    public String index1(){
        return "/pages/Member/LooksList";
    }

    /**
     * 跳转车友注册审核页面
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/RidersList"})
    public String index2(){
        return "/pages/Member/RidersList";
    }

    /**
    * 跳转详情页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/MemberDetail")
    public String accountAdd(Long id,Model model){
        model.addAttribute("member", (Member)memberService.findById(id).getData());
        return "/pages/Member/MemberDetail";
    }

    /**
    * 跳转修改页面
    * @param id  实体ID
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/MemberUpdate")
    public String accountUpdate(Long id,Model model){
        Member member = (Member)memberService.findById(id).getData();
        model.addAttribute("member", member);
        return"/pages/Member/MemberUpdate";
    }

    /**
     * 修改启用状态
     */
    @ApiOperation(value = "修改启用状态")
    @RequestMapping(method = RequestMethod.GET, value = "/updateEnable")
    @ResponseBody
    public ResultUtils updateEnable(Integer id,Integer enableState){
        return memberService.updateEnable(id,enableState);
    }
    /**
     * 修改会员身份
     */
    @ApiOperation(value = "修改会员身份")
    @RequestMapping(method = RequestMethod.GET, value = "/updateIsCustomer")
    @ResponseBody
    public ResultUtils updateIsCustomer(Integer id,Integer isCustomer){
        return memberService.updateIsCustomer(id,isCustomer);
    }

    /**
     * 修改钻石信息和会员时间页面跳转
     */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/MemberEdit")
    public String updateEdit(Long id,Model model){
        MemberVo member = memberService.findUserInfo(id);
        model.addAttribute("member", member);
       return"/pages/Member/MemberEdit";
    }
}

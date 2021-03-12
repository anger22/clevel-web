package com.qiqi.jiaoyou.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qiqi.jiaoyou.mapper.MemberAssetsMapper;
import com.qiqi.jiaoyou.mapper.MemberMapper;
import com.qiqi.jiaoyou.pojo.MemberAssets;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.qiqi.jiaoyou.service.IWithdrawService;
import com.qiqi.jiaoyou.pojo.Withdraw;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qiqi.jiaoyou.util.ResultUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.UnsupportedEncodingException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 提现申请表 前端控制器
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Api(tags = {"提现申请表"})
@Controller
@RequestMapping("/withdraw")
public class WithdrawController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IWithdrawService withdrawService;

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private MemberAssetsMapper memberAssetsMapper;


    @ApiOperation(value = "新增提现申请表")
    @PostMapping("/add")
    @ResponseBody
    public ResultUtils add(@ModelAttribute Withdraw withdraw){
        return withdrawService.add(withdraw);
    }

    @ApiOperation(value = "删除提现申请表")
    @GetMapping("/delete")
    @ResponseBody
    public ResultUtils delete(Long id){
        return withdrawService.delete(id);
    }

    @ApiOperation(value = "更新提现申请表")
    @PostMapping("/update")
    @ResponseBody
    public ResultUtils update(@ModelAttribute Withdraw withdraw){
        return withdrawService.updateData(withdraw);
    }

    @ApiOperation(value = "查询提现申请表分页数据")
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
        return withdrawService.findListByPage(page, limit,map);
    }

    @ApiOperation(value = "id查询提现申请表")
    @GetMapping("/findById")
    @ResponseBody
    public ResultUtils findById(@PathVariable Long id){
        return withdrawService.findById(id);
    }

    /**
    * 跳转列表页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/WithdrawList"})
    public String index(){
        return "/pages/Withdraw/WithdrawList";
    }

    /**
    * 跳转添加页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/WithdrawAdd")
    public String accountAdd(){
        return"/pages/Withdraw/WithdrawAdd";
    }

    /**
    * 跳转修改页面
    * @param id  实体ID
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/WithdrawUpdate")
    public String accountUpdate(Long id,Model model){
        //判断此用户的账户是否存在风险
        Withdraw withdraw = (Withdraw)withdrawService.findById(id).getData();
        List<MemberAssets> memberId = memberAssetsMapper.selectList(new QueryWrapper<MemberAssets>().eq("memberId", withdraw.getMemberId()));
        /*if (memberId.size() > 0){
            MemberAssets memberAssets = memberId.get(0);
            String str = memberAssets.getMemberId() + "," + memberAssets.getMemberDiamondsize() + "," + memberAssets.getMemberhornSize() + "," + memberAssets.getMeberExperienceSize();
            String str1 = EncryptUtil.AESdecode(memberAssets.getCiphertext(), PathParam.key);
            if (str.equals(str1)){
                model.addAttribute("msg", 1);
            }else {
                model.addAttribute("msg", 2);
            }
        }else {
            model.addAttribute("msg", 2);
        }*/
        model.addAttribute("withdraw", withdraw);
        return"/pages/Withdraw/WithdrawUpdate";
    }

}

package com.qiqi.jiaoyou.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.qiqi.jiaoyou.service.IAccountService;
import com.qiqi.jiaoyou.pojo.Account;
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
 * 后台管理员表 前端控制器
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Api(tags = {"后台管理员表"})
@Controller
@RequestMapping("/account")
public class AccountController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IAccountService accountService;


    @ApiOperation(value = "新增后台管理员表")
    @PostMapping("/add")
    @ResponseBody
    public ResultUtils add(@ModelAttribute Account account){
        return accountService.add(account);
    }

    @ApiOperation(value = "删除后台管理员表")
    @GetMapping("/delete")
    @ResponseBody
    public ResultUtils delete(Long id){
        return accountService.delete(id);
    }

    @ApiOperation(value = "更新后台管理员表")
    @PostMapping("/update")
    @ResponseBody
    public ResultUtils update(@ModelAttribute Account account){
        return accountService.updateData(account);
    }

    @ApiOperation(value = "查询后台管理员表分页数据")
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
        return accountService.findListByPage(page, limit,map);
    }

    @ApiOperation(value = "id查询后台管理员表")
    @GetMapping("/findById")
    @ResponseBody
    public ResultUtils findById(@PathVariable Long id){
        return accountService.findById(id);
    }

    /**
    * 跳转列表页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/AccountList"})
    public String index(){
        return "/pages/Account/AccountList";
    }

    /**
    * 跳转添加页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/AccountAdd")
    public String accountAdd(){
        return"/pages/Account/AccountAdd";
    }

    /**
    * 跳转修改页面
    * @param id  实体ID
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/AccountUpdate")
    public String accountUpdate(Long id,Model model){
        model.addAttribute("account", (Account)accountService.findById(id).getData());
        return"/pages/Account/AccountUpdate";
    }

    /**
     * 修改启用状态
     */
    @ApiOperation(value = "修改启用状态")
    @RequestMapping(method = RequestMethod.GET, value = "/updateEnable")
    @ResponseBody
    public ResultUtils updateEnable(Integer id,Integer enableState){
        return accountService.updateEnable(id,enableState);
    }

    /**
     * 跳转修改密码
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/updatePassword")
    public String updatePassword(){
        return"/pages/password";
    }

    /**
     * 修改密码
     */
    @ApiOperation(value = "修改密码")
    @RequestMapping(method = RequestMethod.POST, value = "/updatePwd")
    @ResponseBody
    public ResultUtils updatePwd(@ModelAttribute Account account){
        return accountService.updatePwd(account);
    }

    /**
     * 登录（后台）
     */
    @ApiOperation(value = "登录")
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    @ResponseBody
    public ResultUtils login(@ModelAttribute Account account){
        return accountService.login(account);
    }

    @ApiOperation(value = "解锁")
    @RequestMapping(method = RequestMethod.POST, value = "/unLock")
    @ResponseBody
    public ResultUtils unLock(@ModelAttribute Account account){
        return accountService.unLock(account);
    }


}

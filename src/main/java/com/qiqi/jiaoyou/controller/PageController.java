package com.qiqi.jiaoyou.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qiqi.jiaoyou.mapper.*;
import com.qiqi.jiaoyou.pojo.*;
import com.qiqi.jiaoyou.util.ResultUtils;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PageController {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private CircleOfFriendsMapper circleOfFriendsMapper;
    @Autowired
    private RiderDynamicsMapper riderDynamicsMapper;
    @Autowired
    private DynamicReviewOfFriendsCircleMapper dynamicReviewOfFriendsCircleMapper;
    @Autowired
    private DynamicCommentsOfCarUsersMapper dynamicCommentsOfCarUsersMapper;


    @RequestMapping("/")
    public String showIndex() {
        return "/pages/index";
    }

    /**
     * 跳转登录页面
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String accountUpdate() {
        return "/pages/login";
    }

    /**
     * 跳转分享页面
     *
     * @return
     */
    @RequestMapping("/dynamic")
    public String showDynamic(Integer id,Integer type,Model model) {
        //根据ID查询动态
        if (type == 1){
            CircleOfFriends circleOfFriends = circleOfFriendsMapper.selectById(id);
            //查询出一级评论
            List<DynamicReviewOfFriendsCircle> dynamicReviewOfFriendsCircles = dynamicReviewOfFriendsCircleMapper.selectList(new QueryWrapper<DynamicReviewOfFriendsCircle>().eq("dynamicIdOrCommentId", id).eq("level", 1));
            //查询下级评论
            for (DynamicReviewOfFriendsCircle dynamicReviewOfFriendsCircle : dynamicReviewOfFriendsCircles) {
                dynamicReviewOfFriendsCircle.setLowerList(getChild1(dynamicReviewOfFriendsCircles));
            }
            circleOfFriends.setDynamicReviewOfFriendsCircleList(dynamicReviewOfFriendsCircles);
            circleOfFriends.setImg(Arrays.asList(circleOfFriends.getImages().split(",")));
            model.addAttribute("circleOfFriends",circleOfFriends);
        }else {
            RiderDynamics riderDynamics = riderDynamicsMapper.selectById(id);
            //查询出一级评论
            List<DynamicCommentsOfCarUsers> dynamicCommentsOfCarUsersList = dynamicCommentsOfCarUsersMapper.selectList(new QueryWrapper<DynamicCommentsOfCarUsers>().eq("dynamicIdOrCommentId", id).eq("level", 1));
            //查询下级评论
            for (DynamicCommentsOfCarUsers dynamicCommentsOfCarUsers : dynamicCommentsOfCarUsersList) {
                dynamicCommentsOfCarUsers.setLowerList(getChild(dynamicCommentsOfCarUsersList));
            }
            riderDynamics.setDynamicCommentsOfCarUsers(dynamicCommentsOfCarUsersList);
            riderDynamics.setImg(Arrays.asList(riderDynamics.getImages().split(",")));
            model.addAttribute("riderDynamics",riderDynamics);
        }
        model.addAttribute("type",type);
        return "/pages/dynamic";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/selectMenu")
    @ResponseBody
    public ResultUtils selectMenu(HttpServletRequest request) {
        String token = request.getHeader("token");
        List<Account> token1 = accountMapper.selectList(new QueryWrapper<Account>().eq("token", token));
        Role role = roleMapper.selectById(token1.get(0).getRoleId());
        String[] split = role.getMenus().split(",");
        List<Menu> f_id = menuMapper.selectList(new QueryWrapper<Menu>().eq("f_clasid", 1).in("f_id", split).orderByDesc("f_weight"));
        for (Menu menu : f_id) {
            List<Menu> f_id2 = menuMapper.selectList(new QueryWrapper<Menu>().eq("f_clasid", 2).eq("f_oid", menu.getfId()).in("f_id", split).orderByDesc("f_weight"));
            menu.setList(f_id2);
        }
        String html = "";
        for (Menu menu : f_id) {
            html += "<li data-name=\"home\" class=\"layui-nav-item\">\n" +
                    "                        <a href=\"javascript:;\" lay-tips=\"" + menu.getfName() + "\" lay-direction=\"2\">\n" +
                    "                            <i class=\"layui-icon layui-icon-table\"></i>\n" +
                    "                            <cite>" + menu.getfName() + "</cite>\n" +
                    "                        </a>\n" +
                    "                        <dl class=\"layui-nav-child\">\n";
            int i = 0;
            for (Menu menu1 : menu.getList()) {
                html += "                            <dd data-name=\"console\">\n" +
                        "                                <a lay-href=\"" + menu1.getfAddress() + "\">" + menu1.getfName() + "</a>\n" +
                        "                            </dd>\n";
            }
            html += "                        </dl>\n" +
                    "                    </li>";
        }
        ResultUtils resultUtils = new ResultUtils();
        resultUtils.setMessage("查询成功");
        resultUtils.setData(html);
        resultUtils.setCode(200);
        return resultUtils;
    }

    private List<DynamicReviewOfFriendsCircle> getChild1(List<DynamicReviewOfFriendsCircle> dynamicReviewOfFriendsCircles) {
        // 子菜单(遍历2级)
        List<DynamicReviewOfFriendsCircle> dynamicReviewOfFriendsCircles1 = new ArrayList<>();
        for (DynamicReviewOfFriendsCircle dynamicReviewOfFriendsCircle : dynamicReviewOfFriendsCircles) {
            dynamicReviewOfFriendsCircles1 = dynamicReviewOfFriendsCircleMapper.selectList(new QueryWrapper<DynamicReviewOfFriendsCircle>().eq("dynamicIdOrCommentId", dynamicReviewOfFriendsCircle.getId()).eq("level", 2));
            // 递归
            dynamicReviewOfFriendsCircle.setLowerList(getChild1(dynamicReviewOfFriendsCircles1));
            if (dynamicReviewOfFriendsCircle.getLowerList() == null || dynamicReviewOfFriendsCircle.getLowerList().size() == 0){
                dynamicReviewOfFriendsCircle.setLowerList(dynamicReviewOfFriendsCircles1);
            }
        }
        // 递归退出条件
        if (dynamicReviewOfFriendsCircles1.size() == 0) {
            return null;
        }
        return dynamicReviewOfFriendsCircles1;
    }


    private List<DynamicCommentsOfCarUsers> getChild(List<DynamicCommentsOfCarUsers> dynamicCommentsOfCarUsers) {
        // 子菜单(遍历2级)
        List<DynamicCommentsOfCarUsers> dynamicReviewOfFriendsCircles1 = new ArrayList<>();
        for (DynamicCommentsOfCarUsers dynamicCommentsOfCarUsers1 : dynamicCommentsOfCarUsers) {
            dynamicReviewOfFriendsCircles1 = dynamicCommentsOfCarUsersMapper.selectList(new QueryWrapper<DynamicCommentsOfCarUsers>().eq("dynamicIdOrCommentId", dynamicCommentsOfCarUsers1.getId()).eq("level", 2));
            // 递归
            dynamicCommentsOfCarUsers1.setLowerList(getChild(dynamicReviewOfFriendsCircles1));
            if (dynamicCommentsOfCarUsers1.getLowerList() == null || dynamicCommentsOfCarUsers1.getLowerList().size() == 0){
                dynamicCommentsOfCarUsers1.setLowerList(dynamicReviewOfFriendsCircles1);
            }
        }
        // 递归退出条件
        if (dynamicReviewOfFriendsCircles1.size() == 0) {
            return null;
        }
        return dynamicReviewOfFriendsCircles1;
    }
}

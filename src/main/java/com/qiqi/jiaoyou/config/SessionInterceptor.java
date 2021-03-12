package com.qiqi.jiaoyou.config;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qiqi.jiaoyou.mapper.AccountMapper;
import com.qiqi.jiaoyou.mapper.MenuMapper;
import com.qiqi.jiaoyou.mapper.RoleMapper;
import com.qiqi.jiaoyou.pojo.Account;
import com.qiqi.jiaoyou.pojo.Menu;
import com.qiqi.jiaoyou.pojo.Role;
import com.qiqi.jiaoyou.util.JsonUtils;
import com.qiqi.jiaoyou.util.ResultUtils;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * 自定义拦截器，实现校验用户是否登陆，未登录返回错误信息：尚未登陆。登陆成功则放行
 *
 * @author zhanglf
 * @date 2019-04-29
 */
@Service
public class SessionInterceptor implements HandlerInterceptor {
    //请求处理前调用,我们只需要在这里写验证登陆状态的业务逻辑，就可以在用户调用指定接口之前验证登陆状态了

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MenuMapper menuMapper;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("token");
        if (StringUtils.isEmpty(authorization)) {
            return false;
        } else {
            List<Account> accounts = accountMapper.selectList(new QueryWrapper<Account>().eq("token", authorization).eq("enableState", 1).eq("deleteState", 2));
            if (accounts.size() > 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    //请求处理后，渲染ModelAndView前调用
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    //渲染ModelAndView后调用
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}


package com.qiqi.jiaoyou.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 来注册拦截器
 * @author zhanglf
 * @date 2019-04-29
 */
@Configuration
public class WebConfigurer extends WebMvcConfigurerAdapter {

    /**登陆校验的拦截器注入*/
    @Autowired
    private SessionInterceptor sessionInterceptor;

    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns("/**") 表示拦截所有的请求，
        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
        // 注册拦截器
        InterceptorRegistration loginRegistry = registry.addInterceptor(sessionInterceptor);
        // 拦截路径
        loginRegistry.addPathPatterns("/**");
        // 排除路径
        //登录
        loginRegistry.excludePathPatterns("/account/login");
        loginRegistry.excludePathPatterns("/agreement/registrationAgreement");
        loginRegistry.excludePathPatterns("/account/updatePassword");
        loginRegistry.excludePathPatterns("/deliverLogs/orderBackUrl");
        loginRegistry.excludePathPatterns("/swagger-ui.html",
                "/v2/api-docs", // swagger api json
                "/swagger-resources/configuration/ui", // 用来获取支持的动作
                "/swagger-resources", // 用来获取api-docs的URI
                "/swagger-resources/configuration/security", // 安全选项
                "/swagger-resources/**");

        //进入登录页
        loginRegistry.excludePathPatterns("/login");
        loginRegistry.excludePathPatterns("/dynamic");
        loginRegistry.excludePathPatterns("/");
        loginRegistry.excludePathPatterns("/**/pages/**");

        //修改密码
        loginRegistry.excludePathPatterns("/party/administrators/editPassword");
        // 排除资源请求
        loginRegistry.excludePathPatterns("/layuiadmin/**");
        loginRegistry.excludePathPatterns("/favicon.ico");
        loginRegistry.excludePathPatterns("/upload/**/**.png");
    }

    // 这个方法是用来配置静态资源的，比如html，js，css，等等
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }
}


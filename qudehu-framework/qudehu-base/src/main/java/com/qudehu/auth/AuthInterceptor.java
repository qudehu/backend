package com.qudehu.auth;

import cn.dev33.satoken.fun.SaParamFunction;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.qudehu.auth.err.AuthErrEnum;
import com.qudehu.exception.ServiceException;
import com.qudehu.web.LoginUserHolder;
import org.springframework.core.env.Environment;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 自定义拦截器
 * @author qudehu
 * @date 2023/9/20
 */
public class AuthInterceptor extends SaInterceptor {
    public AuthInterceptor(SaParamFunction<Object> auth) {
        super(auth);
    }
    private static final Environment environment = SpringUtil.getBean(Environment.class);
    private static final AntPathMatcher antPathMatcher = new AntPathMatcher();
    private static final String profileActive = environment.getProperty("spring.profiles.active",String.class);
    private static final List<String> blacklist = environment.getProperty("blacklist",List.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(ObjectUtil.equals(profileActive,"demo")) {
            // 演示环境，无权限操作
            String uri = request.getRequestURI();
            if(CollectionUtil.isNotEmpty(blacklist) && blacklist.stream().anyMatch(s -> antPathMatcher.match(s,uri))) {
                ServiceException.throwBiz(AuthErrEnum.NO_RESOURCE_AUTH);
            }
        }
        LoginUser loginUser = LoginUserHolder.me();
        if(loginUser!=null && loginUser.isSuperAdmin()) {
            // 超级管理员直接放行
            return true;
        }
        return super.preHandle(request, response, handler);
    }
}

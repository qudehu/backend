package com.qudehu.web;


import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.json.JSONUtil;
import com.qudehu.auth.LoginUser;
import com.qudehu.consts.CommonConstant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author qudehu
 * @date 2023/9/20
 */
public class MldongFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        MldongRequestWrapper mldongRequestWrapper = new MldongRequestWrapper((HttpServletRequest) servletRequest);
        String body = mldongRequestWrapper.getBody();
        if(JSONUtil.isTypeJSONObject(body)) {
            QueryParamHolder.set(JSONUtil.toBean(body, Dict.class));
        } else {
            QueryParamHolder.set(Dict.create());
        }
        if(StpUtil.isLogin()) {
            LoginUser loginUser = BeanUtil.toBean(StpUtil.getExtra(CommonConstant.LOGIN_USER_KEY),LoginUser.class);
            LoginUserHolder.set(loginUser);
        }
        filterChain.doFilter(mldongRequestWrapper, servletResponse);
        LoginUserHolder.remove();
    }
}

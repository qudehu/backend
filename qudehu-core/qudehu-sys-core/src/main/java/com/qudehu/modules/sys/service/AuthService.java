package com.qudehu.modules.sys.service;

import com.qudehu.auth.LoginToken;
import com.qudehu.auth.LoginUser;
import com.qudehu.modules.sys.dto.LoginParam;
import com.qudehu.modules.sys.entity.User;

/**
 * 权限服务
 * @author qudehu
 * @date 2023/9/20
 */
public interface AuthService {

    /**
     * 登录
     * @param param
     * @return
     */
    LoginToken login(LoginParam param);

    /**
     * 退出
     * @param token
     */
    void logout(String token);
    /**
     * user转成LoginUser
     * @param user
     * @return
     */
    LoginUser toLoginUser(User user);

    /**
     * 扮演某个用户
     * @param userId
     * @return
     */
    LoginToken playUser(Long userId);

    /**
     * 退出扮演
     * @return
     */
    LoginToken unPlayUser();
}

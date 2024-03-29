package com.qudehu.modules.sys.controller;


import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.hutool.core.lang.Dict;
import com.qudehu.base.CommonResult;
import com.qudehu.modules.sys.dto.LoginParam;
import com.qudehu.modules.sys.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 权限 前端控制器
 * </p>
 *
 * @author qudehu
 * @since 2023-09-20
 */
@RestController
@Api(tags = "授权管理")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/sys/login")
    @ApiOperation(value="登录")
    public CommonResult<?> login(@RequestBody @Validated LoginParam param) {
        return CommonResult.data(authService.login(param));
    }
    @PostMapping("/sys/logout")
    @ApiOperation(value="退出")
    public CommonResult<?> logout(@RequestHeader(name = "Authorization") String authorization) {
        String token = authorization.replace("Bearer ","");
        authService.logout(token);
        return CommonResult.ok();
    }
    @PostMapping("/sys/playUser")
    @ApiOperation(value="扮演用户")
    @SaCheckPermission("sys:playUser")
    public CommonResult<?> playUser(@RequestBody Dict dict) {
        Long userId = dict.getLong("userId");
        return CommonResult.data(authService.playUser(userId));
    }
    @PostMapping("/sys/unPlayUser")
    @ApiOperation(value="退出扮演用户")
    public CommonResult<?> unPlayUser() {
        return CommonResult.data(authService.unPlayUser());
    }
}

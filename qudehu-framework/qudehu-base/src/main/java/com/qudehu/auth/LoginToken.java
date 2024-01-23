package com.qudehu.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author qudehu
 * @date 2023/9/22
 */
@Data
@ApiModel(value = "LoginToken对象", description = "登录Token")
@Builder
public class LoginToken implements Serializable {
    @ApiModelProperty(value = "用户ID")
    private Long userId;
    @ApiModelProperty(value = "用户访问凭证")
    private String token;
}

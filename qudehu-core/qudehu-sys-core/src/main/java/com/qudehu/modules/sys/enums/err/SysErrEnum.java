package com.qudehu.modules.sys.enums.err;


import com.qudehu.base.ErrEnum;

/**
 * @author qudehu
 * @date 2022/9/8
 */
public enum SysErrEnum implements ErrEnum {
    USER_NOT_EXIST(10000001, "用户或密码错误"),
    PWS_ERROR(10000002, "旧密码错误"),
    GRANT_NOT_EXIST(10000003,"授权类型不存在"),
    USER_IS_LOCKED(10041003,"您的账号已被锁定，请联系管理员！"),

    /**
     * 新密码与原密码相同
     */
    USER_PWD_REPEAT(10000004, "新密码与原密码相同，请检查newPassword参数"),
    USER_PHONE_REPEAT(10000005, "手机号已存在，请检查phone参数"),

    ;
    private Integer code;
    private String message;
    SysErrEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

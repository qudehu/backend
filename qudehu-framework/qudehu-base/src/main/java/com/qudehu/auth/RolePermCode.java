package com.qudehu.auth;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qudehu
 * @date 2023/9/21
 */
@Data
public class RolePermCode implements Serializable {
    // 应用编码
    private String appCode;
    // 角色id
    private Long roleId;
    // 权限码集合
    private List<String> perms = new ArrayList<>();
}

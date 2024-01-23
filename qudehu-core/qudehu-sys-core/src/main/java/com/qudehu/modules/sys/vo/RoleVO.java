package com.qudehu.modules.sys.vo;

import com.qudehu.modules.sys.entity.Role;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author qudehu
 * @since 2023-09-20
 */
@Data
@ApiModel(value = "RoleVO对象", description = "角色VO")
public class RoleVO extends Role {
}

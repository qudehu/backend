package com.qudehu.modules.sys.dto;

import com.qudehu.base.PageParam;
import com.qudehu.modules.sys.entity.UserRole;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * r_用户角色关系
 * </p>
 *
 * @author qudehu
 * @since 2022-09-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="UserRolePageParam对象", description="r_用户角色关系分页参数实体类")
public class UserRolePageParam extends PageParam<UserRole> {
    @ApiModelProperty(value = "角色ID")
    private Long roleId;
}
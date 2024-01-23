package com.qudehu.modules.sys.dto;


import com.qudehu.base.PageParam;
import com.qudehu.modules.sys.entity.RoleMenu;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * r_角色菜单关系
 * </p>
 *
 * @author qudehu
 * @since 2022-09-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="RoleMenuPageParam对象", description="r_角色菜单关系分页参数实体类")
public class RoleMenuPageParam extends PageParam<RoleMenu> {
    @ApiModelProperty(value = "角色ID",position = 5)
    private Long roleId;
}
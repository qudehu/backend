package com.qudehu.modules.sys.vo;

import com.qudehu.modules.sys.entity.Menu;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * <p>
 * 菜单
 * </p>
 *
 * @author qudehu
 * @since 2023-09-20
 */
@Data
@ApiModel(value = "MenuVO对象", description = "菜单VO")
public class MenuVO extends Menu {
}

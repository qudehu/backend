package com.qudehu.modules.biz.vo;

import com.qudehu.modules.biz.entity.Demo;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * <p>
 * 演示
 * </p>
 *
 * @author qudehu
 * @since 2023-12-28
 */
@Data
@ApiModel(value = "DemoVO对象", description = "演示VO")
public class DemoVO extends Demo {
}

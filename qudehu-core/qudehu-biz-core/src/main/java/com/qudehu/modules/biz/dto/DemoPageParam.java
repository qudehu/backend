package com.qudehu.modules.biz.dto;

import com.qudehu.base.PageParam;
import com.qudehu.modules.biz.entity.Demo;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel
@Data
// ==
public class DemoPageParam extends PageParam<Demo> {
}
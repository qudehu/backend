package com.qudehu.modules.wf.vo;

import cn.hutool.json.JSONObject;
import com.qudehu.modules.wf.entity.ProcessDefine;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 流程定义
 * </p>
 *
 * @author qudehu
 * @since 2023-09-26
 */
@Data
@ApiModel(value = "ProcessDefineVO对象", description = "流程定义VO")
public class ProcessDefineVO extends ProcessDefine {
    @ApiModelProperty(value = "流程定义json对象")
    private JSONObject jsonObject;
}

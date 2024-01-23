package com.qudehu.modules.wf.vo;

import cn.hutool.json.JSONObject;
import com.qudehu.modules.wf.entity.ProcessDesign;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 流程设计
 * </p>
 *
 * @author qudehu
 * @since 2023-09-25
 */
@Data
@ApiModel(value = "ProcessDesignVO对象", description = "流程设计VO")
public class ProcessDesignVO extends ProcessDesign {
    @ApiModelProperty(value = "流程定义ID")
    private Long processDefineId;
    @ApiModelProperty(value = "流程设计json对象")
    private JSONObject jsonObject;
}

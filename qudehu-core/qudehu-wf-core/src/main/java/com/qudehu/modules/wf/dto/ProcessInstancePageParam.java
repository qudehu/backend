package com.qudehu.modules.wf.dto;

import com.qudehu.base.PageParam;
import com.qudehu.base.YesNoEnum;
import com.qudehu.modules.wf.entity.ProcessInstance;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel
@Data
// ==
public class ProcessInstancePageParam extends PageParam<ProcessInstance> {
    private YesNoEnum isCC=YesNoEnum.NO;
}
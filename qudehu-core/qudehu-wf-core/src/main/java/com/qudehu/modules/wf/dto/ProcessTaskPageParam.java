package com.qudehu.modules.wf.dto;

import com.qudehu.base.PageParam;
import com.qudehu.modules.wf.entity.ProcessTask;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel
@Data
// ==
public class ProcessTaskPageParam extends PageParam<ProcessTask> {
}
package com.qudehu.modules.wf.vo;

import com.qudehu.modules.wf.entity.ProcessTaskActor;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * <p>
 * 流程任务和参与人关系
 * </p>
 *
 * @author qudehu
 * @since 2023-09-26
 */
@Data
@ApiModel(value = "ProcessTaskActorVO对象", description = "流程任务和参与人关系VO")
public class ProcessTaskActorVO extends ProcessTaskActor {
}

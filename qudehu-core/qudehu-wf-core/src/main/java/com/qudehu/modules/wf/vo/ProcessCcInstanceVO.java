package com.qudehu.modules.wf.vo;

import com.qudehu.modules.wf.entity.ProcessCcInstance;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * <p>
 * 流程实例抄送
 * </p>
 *
 * @author qudehu
 * @since 2023-12-05
 */
@Data
@ApiModel(value = "ProcessCcInstanceVO对象", description = "流程实例抄送VO")
public class ProcessCcInstanceVO extends ProcessCcInstance {
}

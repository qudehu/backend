package com.qudehu.modules.wf.vo;

import com.qudehu.modules.wf.entity.ProcessDesignHis;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * <p>
 * 流程设计历史
 * </p>
 *
 * @author qudehu
 * @since 2023-09-25
 */
@Data
@ApiModel(value = "ProcessDesignHisVO对象", description = "流程设计历史VO")
public class ProcessDesignHisVO extends ProcessDesignHis {
}

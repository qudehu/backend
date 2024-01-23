package com.qudehu.modules.wf.engine.model;

import com.qudehu.modules.wf.engine.core.Execution;
import com.qudehu.modules.wf.engine.event.ProcessEvent;
import com.qudehu.modules.wf.engine.event.ProcessPublisher;
import com.qudehu.modules.wf.enums.ProcessEventTypeEnum;
import lombok.Data;
/**
 *
 * 开始模型
 * @author qudehu
 * @date 2023/4/25
 */
@Data
public class StartModel extends NodeModel {
    @Override
    public void exec(Execution execution) {
        // 执行开始节点自定义执行逻辑
        System.out.println(super.toString());
        // 发布流程实例开始事件
        ProcessPublisher.notify(ProcessEvent.builder().eventType(ProcessEventTypeEnum.PROCESS_INSTANCE_START).sourceId(execution.getProcessInstanceId()).build());
        runOutTransition(execution);
    }
}
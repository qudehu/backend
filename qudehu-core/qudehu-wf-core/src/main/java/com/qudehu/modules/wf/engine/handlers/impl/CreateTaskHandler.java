package com.qudehu.modules.wf.engine.handlers.impl;


import com.qudehu.modules.wf.engine.FlowInterceptor;
import com.qudehu.modules.wf.engine.core.Execution;
import com.qudehu.modules.wf.engine.core.ServiceContext;
import com.qudehu.modules.wf.engine.event.ProcessEvent;
import com.qudehu.modules.wf.engine.event.ProcessPublisher;
import com.qudehu.modules.wf.engine.handlers.IHandler;
import com.qudehu.modules.wf.engine.model.TaskModel;
import com.qudehu.modules.wf.entity.ProcessTask;
import com.qudehu.modules.wf.enums.ProcessEventTypeEnum;
import com.qudehu.modules.wf.enums.ProcessTaskPerformTypeEnum;

import java.util.List;

/**
 * 创建任务处理器
 * @author qudehu
 * @date 2023/5/16
 */
public class CreateTaskHandler implements IHandler {
    private TaskModel taskModel;
    public CreateTaskHandler(TaskModel taskModel) {
        this.taskModel = taskModel;
    }
    @Override
    public void handle(Execution execution) {
        List<ProcessTask> processTaskList;
        if(ProcessTaskPerformTypeEnum.COUNTERSIGN.equals(taskModel.getPerformType())) {
            // 会签类型，创建会签任务
            processTaskList = execution.getEngine().processTaskService().createCountersignTask(taskModel, execution);
        } else {
            // 创建普通任务
            processTaskList = execution.getEngine().processTaskService().createTask(taskModel, execution);
        }
        // 将任务添加到执行对象中
        execution.addTasks(processTaskList);
        // 从服务上下文中获取拦截器执行
        ServiceContext.findList(FlowInterceptor.class).forEach(flowInterceptor -> {
            flowInterceptor.intercept(execution);
        });
        // 发布流程任务开始事件
        processTaskList.forEach(processTask -> {
            ProcessPublisher.notify(ProcessEvent.builder().eventType(ProcessEventTypeEnum.PROCESS_TASK_START).sourceId(processTask.getId()).build());
        });
    }
}

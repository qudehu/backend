package com.qudehu.modules.wf.engine.handlers.impl;


import com.qudehu.modules.wf.engine.core.Execution;
import com.qudehu.modules.wf.engine.ex.JFlowException;
import com.qudehu.modules.wf.engine.handlers.IHandler;
import com.qudehu.modules.wf.engine.model.SubProcessModel;
import com.qudehu.modules.wf.entity.ProcessDefine;

/**
 * 启动子流程处理类
 * @author qudehu
 * @date 2023/12/7
 */
public class StartSubProcessHandler implements IHandler {
    private SubProcessModel model;
    public StartSubProcessHandler(SubProcessModel model) {
        this.model = model;
    }
    @Override
    public void handle(Execution execution) {
        ProcessDefine processDefine = execution.getEngine().processDefineService().getProcessDefineByVersion(model.getName(),model.getVersion());
        if(processDefine == null) {
            throw new JFlowException("子流程"+model.getName()+"定义不存在");
        }
        Long parentId = execution.getProcessInstanceId();
        String parentNodeName = model.getName();
        execution.getEngine().startProcessInstanceById(
                processDefine.getId(),
                execution.getOperator(),
                execution.getArgs(),
                parentId,parentNodeName);
    }
}

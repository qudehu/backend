package com.qudehu.modules.wf.engine.event;

/**
 * 流程事件监听接口
 * @author qudehu
 * @date 2023/12/5
 */
public interface ProcessEventListener {
    void onEvent(ProcessEvent event);
}

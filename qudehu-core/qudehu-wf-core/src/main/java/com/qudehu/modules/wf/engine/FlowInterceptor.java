package com.qudehu.modules.wf.engine;

import com.qudehu.modules.wf.engine.core.Execution;

/**
 *
 * 流程节点拦截器
 * @author qudehu
 * @date 2023/9/3
 */
public interface FlowInterceptor{
    /**
     * 拦截方法，参数为执行对象
     * @param execution 执行对象。可从中获取执行的数据
     */
    void intercept(Execution execution);
}

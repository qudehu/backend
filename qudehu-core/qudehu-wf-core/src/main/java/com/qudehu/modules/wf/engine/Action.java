package com.qudehu.modules.wf.engine;

import com.qudehu.modules.wf.engine.core.Execution;

/**
 *
 * 模型行为
 * @author qudehu
 * @date 2023/4/25
 */
public interface Action {
    public void execute(Execution execution);
}
package com.qudehu.modules.wf.engine.model;

import com.qudehu.modules.wf.engine.handlers.impl.MergeBranchHandler;
import com.qudehu.modules.wf.engine.core.Execution;
import lombok.Data;

/**
 *
 * 合并模型
 * @author qudehu
 * @date 2023/4/25
 */
@Data
public class JoinModel extends NodeModel {
    @Override
    public void exec(Execution execution) {
        // 执行合并节点自定义执行逻辑
        fire(new MergeBranchHandler(this),execution);
        if(execution.isMerged()) {
            runOutTransition(execution);
        }
    }
}
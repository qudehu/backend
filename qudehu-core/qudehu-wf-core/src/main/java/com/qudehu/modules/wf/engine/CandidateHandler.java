package com.qudehu.modules.wf.engine;

import com.qudehu.modules.wf.entity.Candidate;
import com.qudehu.modules.wf.engine.model.TaskModel;

import java.util.List;

/**
 *
 * 候选人处理接口
 * @author qudehu
 * @date 2023/6/26
 */
public interface CandidateHandler {
    /**
     * 根据任务模型参数获取候选人信息
     * @param model
     * @return
     */
    List<Candidate> handle(TaskModel model);
}

package com.qudehu.modules.wf.flow.handlers;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.qudehu.modules.sys.api.DeptApi;
import com.qudehu.modules.wf.api.WfUserApi;
import com.qudehu.modules.wf.engine.AssignmentHandler;
import com.qudehu.modules.wf.engine.core.Execution;
import com.qudehu.modules.wf.engine.core.ServiceContext;
import com.qudehu.modules.wf.engine.model.TaskModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取流程发起人部门领导
 * @author qudehu
 * @date 2023/9/28
 */
public class ApplicantDeptLeaderAssignmentHandler implements AssignmentHandler {
    private static DeptApi deptApi = SpringUtil.getBean(DeptApi.class);
    @Override
    public List<String> assign(TaskModel model, Execution execution) {
        List<String> ids = new ArrayList<>();
        String operator = execution.getProcessInstance().getOperator();
        WfUserApi wfUserApi = ServiceContext.find(WfUserApi.class);
        Long deptId = Convert.toLong(wfUserApi.getDeptId(operator));
        Dict dict = deptApi.findById(deptId);
        if(ObjectUtil.isNotEmpty(dict)) {
            String leaderIds = dict.getStr("leaderIds");
            if(ObjectUtil.isNotEmpty(leaderIds)) {
                ids.addAll(CollectionUtil.newArrayList(leaderIds.split(",")));
            }
        }
        return ids;
    }

    @Override
    public String getMessage() {
        return "发起人所属部门经理";
    }

    @Override
    public int getOrder() {
        return 10;
    }
}

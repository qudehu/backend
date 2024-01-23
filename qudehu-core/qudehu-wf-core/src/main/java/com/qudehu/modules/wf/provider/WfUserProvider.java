package com.qudehu.modules.wf.provider;

import cn.hutool.core.convert.Convert;
import com.qudehu.modules.sys.api.UserApi;
import com.qudehu.modules.wf.api.WfUserApi;
import com.qudehu.modules.wf.enums.FlowConst;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 工作流用户担任者
 * @author qudehu
 * @date 2023/10/7
 */
@Component
@RequiredArgsConstructor
public class WfUserProvider implements WfUserApi {
    private final UserApi userApi;
    @Override
    public String getRealName(String userId) {
        return userApi.findById(Convert.toLong(userId)).getStr(FlowConst.USER_REAL_NAME.replace("u_",""));
    }

    @Override
    public String getDeptId(String userId) {
        return userApi.findById(Convert.toLong(userId)).getStr(FlowConst.USER_DEPT_ID.replace("u_",""));
    }

    @Override
    public String getDeptName(String userId) {
        return userApi.findById(Convert.toLong(userId)).getStr(FlowConst.USER_DEPT_NAME.replace("u_",""));
    }

    @Override
    public String getPostId(String userId) {
        return userApi.findById(Convert.toLong(userId)).getStr(FlowConst.USER_POST_ID.replace("u_",""));
    }

    @Override
    public String getPostName(String userId) {
        return userApi.findById(Convert.toLong(userId)).getStr(FlowConst.USER_POST_NAME.replace("u_",""));
    }
}

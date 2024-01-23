package com.qudehu.modules.wf.engine.ex;


import com.qudehu.modules.wf.enums.err.WfErrEnum;

/**
 *
 * 工作流自定义异常
 * @author qudehu
 * @date 2023/5/1
 */
public class JFlowException extends RuntimeException {
    public JFlowException(WfErrEnum errEnum) {}
    public JFlowException(String msg) {
        super(msg);
    }
}

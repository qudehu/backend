package com.qudehu.modules.wf.engine.cfg;


import com.qudehu.modules.wf.engine.Context;
import com.qudehu.modules.wf.engine.core.ServiceContext;
import com.qudehu.modules.wf.engine.impl.SimpleContext;
import com.qudehu.modules.wf.engine.parser.impl.*;


/**
 *
 * 流程引擎配置类
 * @author qudehu
 * @date 2022/6/12
 */
public class Configuration {
    public Configuration() {
        this(new SimpleContext());
    }
    public Configuration(Context context) {
        ServiceContext.setContext(context);
        ServiceContext.put("decision", DecisionParser.class);
        ServiceContext.put("end", EndParser.class);
        ServiceContext.put("fork", ForkParser.class);
        ServiceContext.put("join", JoinParser.class);
        ServiceContext.put("start", StartParser.class);
        ServiceContext.put("task", TaskParser.class);
        ServiceContext.put("custom",CustomParser.class);
        ServiceContext.put("wfSubProcess", WfSubProcessParser.class);
    }

}

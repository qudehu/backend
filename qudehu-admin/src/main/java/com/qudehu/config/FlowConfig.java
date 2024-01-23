package com.qudehu.config;

import com.qudehu.modules.wf.engine.FlowEngine;
import com.qudehu.modules.wf.engine.core.FlowEngineImpl;
import com.qudehu.modules.wf.engine.impl.SpringContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 工作流引擎配置
 * @author qudehu
 * @date 2023/9/26
 */
@Configuration
public class FlowConfig {
    @Bean
    public FlowEngine flowEngine(SpringContext springContext) {
        FlowEngine engine = new FlowEngineImpl().configure(new com.qudehu.modules.wf.engine.cfg.Configuration(springContext));
        return engine;
    }
}

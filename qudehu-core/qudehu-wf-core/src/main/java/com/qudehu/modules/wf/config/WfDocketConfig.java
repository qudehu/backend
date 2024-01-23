package com.qudehu.modules.wf.config;



import com.qudehu.base.SwaggerDocket;
import com.qudehu.consts.CommonConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qudehu
 * @date 2023/12/18
 */
@Configuration
public class WfDocketConfig {
    @Bean
    public SwaggerDocket wfSwaggerDocket() {
        return SwaggerDocket.builder().groupName("02.工作流").basePackage(CommonConstant.DEFAULT_PACKAGE_NAME+".modules.wf").build();
    }
}

package com.qudehu.modules.sys.config;



import com.qudehu.base.SwaggerDocket;
import com.qudehu.consts.CommonConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qudehu
 * @date 2023/12/18
 */
@Configuration
public class SysDocketConfig {
    @Bean
    public SwaggerDocket sysSwaggerDocket() {
        return SwaggerDocket.builder().groupName("01.系统管理").basePackage(CommonConstant.DEFAULT_PACKAGE_NAME+".modules.sys").build();
    }
}

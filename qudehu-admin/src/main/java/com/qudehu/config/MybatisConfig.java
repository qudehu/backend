package com.qudehu.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.qudehu.mp.CustomMetaObjectHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * mybatis扩展插件配置
 * @author qudehu
 * @date 2023-09-21
 */
@Configuration
@MapperScan(basePackages = {"com.qudehu.**.mapper","com.qudehu.**.dao","com.qudehu.**.repository"}, sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisConfig {

    /**
     * mybatis-plus分页插件
     *
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }

    /**
     * 自定义公共字段自动注入
     *
     */
    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new CustomMetaObjectHandler();
    }

}

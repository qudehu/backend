package com.qudehu.config;


import com.qudehu.auth.RolePermCode;
import com.qudehu.auth.RolePermCodeCache;
import com.qudehu.redis.FastJson2JsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 缓存配置
 * @author qudehu
 * @date 2023/9/21
 */

@Configuration
public class CacheConfig {
    @Bean
    public RedisTemplate<String, RolePermCode> rolePermCodeRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, RolePermCode> userRedisTemplate = new RedisTemplate<>();
        userRedisTemplate.setConnectionFactory(redisConnectionFactory);
        userRedisTemplate.setKeySerializer(new StringRedisSerializer());
        userRedisTemplate.setValueSerializer(new FastJson2JsonRedisSerializer<>(RolePermCode.class));
        userRedisTemplate.afterPropertiesSet();
        return userRedisTemplate;
    }
    @Bean
    public RolePermCodeCache rolePermCodeCache(RedisTemplate<String, RolePermCode> redisTemplate) {
        return new RolePermCodeCache(redisTemplate);
    }
}

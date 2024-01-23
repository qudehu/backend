package com.qudehu.modules.sys.cache;

import com.qudehu.cache.base.AbstractRedisCacheOperator;
import com.qudehu.dict.model.DictModel;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author qudehu
 * @date 2023/7/26
 */
public class DictCache extends AbstractRedisCacheOperator<DictModel> {
    public DictCache(RedisTemplate<String, DictModel> redisTemplate) {
        super(redisTemplate);
    }

    @Override
    public String getCommonKeyPrefix() {
        return "sys_dict:";
    }
}

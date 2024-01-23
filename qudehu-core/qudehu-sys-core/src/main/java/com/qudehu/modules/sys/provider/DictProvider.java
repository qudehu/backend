package com.qudehu.modules.sys.provider;

import cn.hutool.core.lang.Dict;
import com.qudehu.modules.sys.api.DictApi;
import com.qudehu.modules.sys.service.DictService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author qudehu
 * @date 2023/10/12
 */
@Component
@RequiredArgsConstructor
public class DictProvider implements DictApi {
    private final DictService dictService;
    @Override
    public List<Dict> getByDictType(String dictType) {
        return dictService.getByDictType(dictType);
    }
}

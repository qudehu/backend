package com.qudehu.modules.sys.provider;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Dict;
import com.qudehu.base.MapToCamelCaseRowHandlerImpl;
import com.qudehu.modules.sys.api.DeptApi;
import com.qudehu.modules.sys.service.DeptService;
import com.qudehu.modules.sys.vo.DeptVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 部门接口提供者
 * @author qudehu
 * @date 2023/9/28
 */
@Component
@RequiredArgsConstructor
public class DeptProvider implements DeptApi {
    private final DeptService deptService;
    @Override
    public Dict findById(Long id) {
        DeptVO deptVO = deptService.findById(id);
        if(deptVO!=null) {
            Dict dict = BeanUtil.toBean(deptVO,Dict.class);
            new MapToCamelCaseRowHandlerImpl().handle(dict);
            return dict;
        }
        return null;
    }
}

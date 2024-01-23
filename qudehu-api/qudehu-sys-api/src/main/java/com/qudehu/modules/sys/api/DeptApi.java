package com.qudehu.modules.sys.api;

import cn.hutool.core.lang.Dict;

/**
 * 部门接口
 * @author qudehu
 * @date 2023/9/28
 */
public interface DeptApi {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    Dict findById(Long id);
}

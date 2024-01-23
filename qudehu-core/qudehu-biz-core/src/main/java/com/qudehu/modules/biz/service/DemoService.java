package com.qudehu.modules.biz.service;

import com.qudehu.base.CommonPage;
import com.qudehu.modules.biz.dto.DemoPageParam;
import com.qudehu.modules.biz.dto.DemoParam;
import com.qudehu.modules.biz.vo.DemoVO;
import com.qudehu.modules.biz.entity.Demo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 演示 服务类
 * </p>
 *
 * @author qudehu
 * @since 2023-12-28
 */
public interface DemoService extends IService<Demo> {
    /**
    * 添加演示
    * @param param
    * @return
    */
    boolean save(DemoParam param);

    /**
    * 更新演示
    * @param param
    * @return
    */
    boolean update(DemoParam param);

    /**
    * 自定义分页查询演示
    * @param param
    * @return
    */
    CommonPage<DemoVO> page(DemoPageParam param);
    /**
    * 通过id查询
    * @param id
    * @return
    */
    DemoVO findById(Long id);
}

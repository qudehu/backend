package com.qudehu.modules.sys.service;

import com.qudehu.base.CommonPage;
import com.qudehu.modules.sys.dto.ConfigPageParam;
import com.qudehu.modules.sys.dto.ConfigParam;
import com.qudehu.modules.sys.vo.ConfigVO;
import com.qudehu.modules.sys.entity.Config;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 配置 服务类
 * </p>
 *
 * @author qudehu
 * @since 2023-09-21
 */
public interface ConfigService extends IService<Config> {
  /**
  * 添加配置
  * @param param
  * @return
  */
  boolean save(ConfigParam param);

  /**
  * 更新配置
  * @param param
  * @return
  */
  boolean update(ConfigParam param);

  /**
  * 自定义分页查询配置
  * @param param
  * @return
  */
  CommonPage<ConfigVO> page(ConfigPageParam param);
  /**
  * 通过id查询
  * @param id
  * @return
  */
  ConfigVO findById(Long id);
}

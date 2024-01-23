package com.qudehu.modules.sys.service;

import cn.hutool.core.lang.Dict;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qudehu.base.CommonPage;
import com.qudehu.modules.sys.dto.MenuPageParam;
import com.qudehu.modules.sys.dto.MenuParam;
import com.qudehu.modules.sys.dto.SyncRouteParam;
import com.qudehu.modules.sys.entity.Menu;
import com.qudehu.modules.sys.vo.MenuVO;

import java.util.List;

/**
 * <p>
 * 菜单 服务类
 * </p>
 *
 * @author qudehu
 * @since 2023-09-20
 */
public interface MenuService extends IService<Menu> {
  /**
  * 添加菜单
  * @param param
  * @return
  */
  boolean save(MenuParam param);

  /**
  * 更新菜单
  * @param param
  * @return
  */
  boolean update(MenuParam param);

  /**
  * 自定义分页查询菜单
  * @param param
  * @return
  */
  CommonPage<MenuVO> page(MenuPageParam param);
  /**
  * 通过id查询
  * @param id
  * @return
  */
  MenuVO findById(Long id);
  /**
   * 获取菜单树
   * @param param
   * @return
   */
  List<MenuVO> tree(MenuPageParam param);
  /**
   * 同步前端路由
   * @param param
   * @return
   */
  boolean syncRoute(List<SyncRouteParam> param);
  /**
   * 应用列表
   * @return
   */
  List<Dict> appList();
}

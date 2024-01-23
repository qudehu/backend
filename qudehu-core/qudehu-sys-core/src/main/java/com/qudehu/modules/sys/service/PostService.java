package com.qudehu.modules.sys.service;

import com.qudehu.base.CommonPage;
import com.qudehu.modules.sys.dto.PostPageParam;
import com.qudehu.modules.sys.dto.PostParam;
import com.qudehu.modules.sys.vo.PostVO;
import com.qudehu.modules.sys.entity.Post;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 岗位 服务类
 * </p>
 *
 * @author qudehu
 * @since 2023-09-20
 */
public interface PostService extends IService<Post> {
  /**
  * 添加岗位
  * @param param
  * @return
  */
  boolean save(PostParam param);

  /**
  * 更新岗位
  * @param param
  * @return
  */
  boolean update(PostParam param);

  /**
  * 自定义分页查询岗位
  * @param param
  * @return
  */
  CommonPage<PostVO> page(PostPageParam param);
  /**
  * 通过id查询
  * @param id
  * @return
  */
  PostVO findById(Long id);

  /**
   * 从缓存中获取
   * @param id
   * @return
   */
  PostVO getInCache(Long id);
}

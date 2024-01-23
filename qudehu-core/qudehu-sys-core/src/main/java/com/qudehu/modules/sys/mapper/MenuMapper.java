package com.qudehu.modules.sys.mapper;

import com.qudehu.modules.sys.entity.Menu;
import com.qudehu.modules.sys.vo.MenuVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
/**
 * <p>
 * 菜单 Mapper 接口
 * </p>
 *
 * @author qudehu
 * @since 2023-09-20
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    List<MenuVO> selectCustom(IPage<MenuVO> page, @Param(Constants.WRAPPER) Wrapper<Menu> wrapper);
    MenuVO findById(@Param("id") Long id);
}

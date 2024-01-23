package com.qudehu.modules.sys.mapper;

import com.qudehu.modules.sys.entity.Role;
import com.qudehu.modules.sys.vo.RoleVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author qudehu
 * @since 2023-09-20
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    List<RoleVO> selectCustom(IPage<RoleVO> page, @Param(Constants.WRAPPER) Wrapper<Role> wrapper);
    RoleVO findById(@Param("id") Long id);
}

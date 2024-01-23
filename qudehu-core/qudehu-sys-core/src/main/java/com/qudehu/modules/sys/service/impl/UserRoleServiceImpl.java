package com.qudehu.modules.sys.service.impl;

import com.qudehu.modules.sys.entity.UserRole;
import com.qudehu.modules.sys.mapper.UserRoleMapper;
import com.qudehu.modules.sys.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * r_用户角色关系 服务实现类
 * </p>
 *
 * @author qudehu
 * @since 2023-09-21
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {
}

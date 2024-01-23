package com.qudehu.modules.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qudehu.base.CommonPage;
import com.qudehu.base.YesNoEnum;
import com.qudehu.modules.sys.dto.RolePageParam;
import com.qudehu.modules.sys.dto.RoleParam;
import com.qudehu.modules.sys.vo.RoleVO;
import com.qudehu.util.LowCodeServiceUtil;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.qudehu.modules.sys.entity.Role;
import com.qudehu.modules.sys.mapper.RoleMapper;
import com.qudehu.modules.sys.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author qudehu
 * @since 2023-09-21
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(RoleParam param) {
        LowCodeServiceUtil.checkUnique(baseMapper,"code",param.getCode(),null,"唯一编码已存在，请检查code参数");
        param.setId(null);
        Role role = new Role();
        BeanUtil.copyProperties(param, role);
        return super.save(role);
    }

    @Override
    public boolean update(RoleParam param) {
        LowCodeServiceUtil.checkUnique(baseMapper,"code",param.getCode(),param.getId(),"唯一编码已存在，请检查code参数");
        Role role = new Role();
        BeanUtil.copyProperties(param, role);
        return super.updateById(role);
    }

    @Override
    public CommonPage<RoleVO> page(RolePageParam param) {
        IPage<RoleVO> page = param.buildMpPage();
        QueryWrapper queryWrapper = param.buildQueryWrapper();
        queryWrapper.eq("t.is_deleted",YesNoEnum.NO);
        List<RoleVO> list = baseMapper.selectCustom(page, queryWrapper);
        page.setRecords(list);
        return CommonPage.toPage(page);
    }
    @Override
    public RoleVO findById(Long id) {
        return baseMapper.findById(id);
    }
}

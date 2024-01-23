package com.qudehu.modules.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qudehu.base.CommonPage;
import com.qudehu.base.YesNoEnum;
import com.qudehu.modules.sys.dto.PostPageParam;
import com.qudehu.modules.sys.dto.PostParam;
import com.qudehu.modules.sys.vo.PostVO;
import com.qudehu.util.LowCodeServiceUtil;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.qudehu.modules.sys.entity.Post;
import com.qudehu.modules.sys.mapper.PostMapper;
import com.qudehu.modules.sys.service.PostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 岗位 服务实现类
 * </p>
 *
 * @author qudehu
 * @since 2023-09-21
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(PostParam param) {
        param.setId(null);
        LowCodeServiceUtil.checkUnique(baseMapper,"code",param.getCode(),null,"唯一编码已存在，请检查code参数");
        Post post = new Post();
        BeanUtil.copyProperties(param, post);
        return super.save(post);
    }

    @Override
    public boolean update(PostParam param) {
        LowCodeServiceUtil.checkUnique(baseMapper,"code",param.getCode(),param.getId(),"唯一编码已存在，请检查code参数");
        Post post = new Post();
        BeanUtil.copyProperties(param, post);
        return super.updateById(post);
    }

    @Override
    public CommonPage<PostVO> page(PostPageParam param) {
        if(ObjectUtil.isEmpty(param.getOrderBy())){
            param.setOrderBy("t.sort asc");
        }
        IPage<PostVO> page = param.buildMpPage();
        QueryWrapper queryWrapper = param.buildQueryWrapper();
        queryWrapper.eq("t.is_deleted",YesNoEnum.NO);
        List<PostVO> list = baseMapper.selectCustom(page, queryWrapper);
        page.setRecords(list);
        return CommonPage.toPage(page);
    }
    @Override
    public PostVO findById(Long id) {
        return baseMapper.findById(id);
    }

    @Override
    public PostVO getInCache(Long id) {
        return findById(id);
    }
}

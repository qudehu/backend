package com.qudehu.modules.wf.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qudehu.base.CommonPage;
import com.qudehu.modules.wf.dto.ProcessDesignHisPageParam;
import com.qudehu.modules.wf.dto.ProcessDesignHisParam;
import com.qudehu.modules.wf.entity.ProcessDesignHis;
import com.qudehu.modules.wf.mapper.ProcessDesignHisMapper;
import com.qudehu.modules.wf.service.ProcessDesignHisService;
import com.qudehu.modules.wf.vo.ProcessDesignHisVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * <p>
 * 流程设计历史 服务实现类
 * </p>
 *
 * @author qudehu
 * @since 2023-09-25
 */
@Service
public class ProcessDesignHisServiceImpl extends ServiceImpl<ProcessDesignHisMapper, ProcessDesignHis> implements ProcessDesignHisService {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(ProcessDesignHisParam param) {
        param.setId(null);
        ProcessDesignHis processDesignHis = new ProcessDesignHis();
        BeanUtil.copyProperties(param, processDesignHis);
        return super.save(processDesignHis);
    }

    @Override
    public boolean update(ProcessDesignHisParam param) {
        ProcessDesignHis processDesignHis = new ProcessDesignHis();
        BeanUtil.copyProperties(param, processDesignHis);
        return super.updateById(processDesignHis);
    }

    @Override
    public CommonPage<ProcessDesignHisVO> page(ProcessDesignHisPageParam param) {
        IPage<ProcessDesignHisVO> page = param.buildMpPage();
        QueryWrapper queryWrapper = param.buildQueryWrapper();
        List<ProcessDesignHisVO> list = baseMapper.selectCustom(page, queryWrapper);
        page.setRecords(list);
        return CommonPage.toPage(page);
    }
    @Override
    public ProcessDesignHisVO findById(Long id) {
        return baseMapper.findById(id);
    }

    @Override
    public ProcessDesignHis getLatestByProcessDesignId(Long processDesignId) {
        return baseMapper.getLatestByProcessDesignId(processDesignId);
    }
}

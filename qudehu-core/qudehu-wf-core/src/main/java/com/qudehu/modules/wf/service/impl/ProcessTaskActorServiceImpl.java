package com.qudehu.modules.wf.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qudehu.base.CommonPage;
import com.qudehu.modules.wf.dto.ProcessTaskActorPageParam;
import com.qudehu.modules.wf.dto.ProcessTaskActorParam;
import com.qudehu.modules.wf.vo.ProcessTaskActorVO;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.qudehu.modules.wf.entity.ProcessTaskActor;
import com.qudehu.modules.wf.mapper.ProcessTaskActorMapper;
import com.qudehu.modules.wf.service.ProcessTaskActorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
/**
 * <p>
 * 流程任务和参与人关系 服务实现类
 * </p>
 *
 * @author qudehu
 * @since 2023-09-26
 */
@Service
public class ProcessTaskActorServiceImpl extends ServiceImpl<ProcessTaskActorMapper, ProcessTaskActor> implements ProcessTaskActorService {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(ProcessTaskActorParam param) {
        param.setId(null);
        ProcessTaskActor processTaskActor = new ProcessTaskActor();
        BeanUtil.copyProperties(param, processTaskActor);
        return super.save(processTaskActor);
    }

    @Override
    public boolean update(ProcessTaskActorParam param) {
        ProcessTaskActor processTaskActor = new ProcessTaskActor();
        BeanUtil.copyProperties(param, processTaskActor);
        return super.updateById(processTaskActor);
    }

    @Override
    public CommonPage<ProcessTaskActorVO> page(ProcessTaskActorPageParam param) {
        IPage<ProcessTaskActorVO> page = param.buildMpPage();
        QueryWrapper queryWrapper = param.buildQueryWrapper();
        List<ProcessTaskActorVO> list = baseMapper.selectCustom(page, queryWrapper);
        page.setRecords(list);
        return CommonPage.toPage(page);
    }
    @Override
    public ProcessTaskActorVO findById(Long id) {
        return baseMapper.findById(id);
    }
}

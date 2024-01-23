package com.qudehu.modules.sys.mapper;

import com.qudehu.modules.sys.entity.Config;
import com.qudehu.modules.sys.vo.ConfigVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
/**
 * <p>
 * 配置 Mapper 接口
 * </p>
 *
 * @author qudehu
 * @since 2023-09-21
 */
@Mapper
public interface ConfigMapper extends BaseMapper<Config> {
    List<ConfigVO> selectCustom(IPage<ConfigVO> page, @Param(Constants.WRAPPER) Wrapper<Config> wrapper);
    ConfigVO findById(@Param("id") Long id);
}

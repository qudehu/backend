package com.qudehu.modules.sys.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.hutool.core.lang.Dict;
import com.qudehu.base.CommonPage;
import com.qudehu.base.CommonResult;
import com.qudehu.base.IdParam;
import com.qudehu.base.IdsParam;
import com.qudehu.dict.DictScanner;
import com.qudehu.dict.model.DictModel;
import com.qudehu.modules.sys.dto.DictPageParam;
import com.qudehu.modules.sys.dto.DictParam;
import com.qudehu.modules.sys.service.DictService;
import com.qudehu.modules.sys.vo.DictVO;
import com.qudehu.validation.Groups;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* <p>
    * 字典 前端控制器
    * </p>
*
* @author qudehu
* @since 2023-09-21
*/
@RestController
@Api(tags = "字典管理")
@RequiredArgsConstructor
public class DictController {
    private final DictService dictService;
    private final DictScanner dictScanner;
    /**
     * 添加字典
     * @param param
     * @return
     */
    @PostMapping("/sys/dict/save")
    @ApiOperation(value = "添加字典")
    @SaCheckPermission("sys:dict:save")
    public CommonResult<?> save(@RequestBody @Validated({Groups.Save.class}) DictParam param) {
        dictService.save(param);
        return CommonResult.ok();
    }
    /**
     * 删除字典
     * @param param
     * @return
     */
    @PostMapping("/sys/dict/remove")
    @ApiOperation(value = "删除字典")
    @SaCheckPermission("sys:dict:remove")
    public CommonResult<?> remove(@RequestBody IdsParam param) {
        dictService.removeBatchByIds(param.getIds());
        return CommonResult.ok();
    }
    /**
     * 修改字典
     * @param param
     * @return
     */
    @PostMapping("/sys/dict/update")
    @ApiOperation(value = "修改字典")
    @SaCheckPermission("sys:dict:update")
    public CommonResult<?> update(@RequestBody @Validated({Groups.Update.class}) DictParam param) {
        dictService.update(param);
        return CommonResult.ok();
    }
    /**
     * 查询单个字典
     * @param param
     * @return
     */
    @PostMapping("/sys/dict/detail")
    @ApiOperation(value = "查询单个字典")
    @SaCheckPermission("sys:dict:detail")
    public CommonResult<DictVO> detail(@RequestBody IdParam param) {
        DictVO dict = dictService.findById(param.getId());
        return CommonResult.data(dict);
    }
    /**
     *分页查询字典列表
     * @param param
     * @return
     */
    @PostMapping("/sys/dict/page")
    @ApiOperation(value = "分页查询字典列表")
    @SaCheckPermission("sys:dict:page")
    public CommonResult<CommonPage<DictVO>> page(@RequestBody DictPageParam param) {
        return CommonResult.data(dictService.page(param));
    }
    @PostMapping("/sys/dict/getByDictType")
    @ApiOperation(value = "字典下拉", notes = "sys:dict:getByDictType")
    public CommonResult<List<Dict>> getByDictType(@RequestBody @Validated({DictParam.DictType.class}) DictParam param) {
        return CommonResult.data(dictService.getByDictType(param.getDictType()));
    }

    @PostMapping("/sys/dict/enumDictList")
    public CommonResult<List<DictModel>> enumDictList() {
        return CommonResult.data(dictScanner.getDictList());
    }
}

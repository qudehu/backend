package com.qudehu.modules.sys.vo;

import com.qudehu.modules.sys.entity.DictItem;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * <p>
 * 字典项
 * </p>
 *
 * @author qudehu
 * @since 2023-09-21
 */
@Data
@ApiModel(value = "DictItemVO对象", description = "字典项VO")
public class DictItemVO extends DictItem {
}

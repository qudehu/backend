package com.qudehu.base;

import cn.hutool.core.lang.Dict;
import lombok.Builder;
import lombok.Data;

/**
 * @author qudehu
 * @date 2022/7/22
 */
@Data
@Builder
public class LabelValueVO {
    private String label;
    private Object value;
    private Dict ext;
}

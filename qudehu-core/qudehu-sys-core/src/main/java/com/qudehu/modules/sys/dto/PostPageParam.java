package com.qudehu.modules.sys.dto;

import com.qudehu.base.PageParam;
import com.qudehu.modules.sys.entity.Post;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel
@Data
// ==
public class PostPageParam extends PageParam<Post> {
}
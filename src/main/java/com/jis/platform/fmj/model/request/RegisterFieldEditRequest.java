package com.jis.platform.fmj.model.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RegisterFieldEditRequest extends RegisterFieldCreateRequest {

    @ApiModelProperty(value="主键ID，和前端交互时为字符串")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
}

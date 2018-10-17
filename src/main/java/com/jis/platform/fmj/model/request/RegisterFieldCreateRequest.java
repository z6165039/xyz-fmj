package com.jis.platform.fmj.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RegisterFieldCreateRequest {

    @ApiModelProperty(value = "说明")
    private String comment;

    @ApiModelProperty(value = "字段值")
    private String fieldArray;

    @ApiModelProperty(value = "字段名称")
    private String name;

    @ApiModelProperty(value = "字段类型ID")
    private Long fieldTypeId;

}

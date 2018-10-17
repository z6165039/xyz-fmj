package com.jis.platform.fmj.model.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RegisterTemplateFieldRelCreateRequest implements TemplateRequestImpl{

    @ApiModelProperty(value = "字段名称")
    private String name;

    @ApiModelProperty(value = "字段类型名称")
    private String fieldTypeName;

    @ApiModelProperty(value = "主键，和前端交互时为字符串")
    @JsonSerialize(using = ToStringSerializer.class )
    private Long fieldId;

    @ApiModelProperty(value = "字段是否允许为空")
    private Boolean checkEmpty;

    @ApiModelProperty(value = "字段最大长度")
    private Integer maxLength;

    @ApiModelProperty(value = "字段显示名称")
    private String showName;

    @ApiModelProperty(value = "字段类型ID")
    private Integer fieldTypeId;

    @ApiModelProperty(value = "字段参数数组")
    private String fieldArray;

    @ApiModelProperty(value = "检查名称")
    private String checkName;
}

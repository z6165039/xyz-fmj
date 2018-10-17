package com.jis.platform.fmj.model.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

@Data
public class TemplateFieldsInfoResponse implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long skuId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long fieldId;

    private Long fieldTypeId;
    private String fieldArray;
    private Integer  sortNo;
    private Integer  maxLength;
    private String  showName;

}

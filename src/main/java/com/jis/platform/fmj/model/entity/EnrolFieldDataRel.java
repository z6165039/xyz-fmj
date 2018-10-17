package com.jis.platform.fmj.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class EnrolFieldDataRel {

    @JsonSerialize(using = ToStringSerializer.class)
    private Integer id;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long fieldId;

    private String columnName;

    private String comment;

}
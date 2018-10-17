package com.jis.platform.fmj.model.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class FindListEnrolFieldResponse {

    @JsonSerialize(
            using = ToStringSerializer.class
    )
    private Long id;

    private Long fieldTypeId;

    private String name;

    private String code;

    private String fieldArray;

    private String comment;

    private String fieldTypeName;

    private String checkName;

    private Boolean system;


}
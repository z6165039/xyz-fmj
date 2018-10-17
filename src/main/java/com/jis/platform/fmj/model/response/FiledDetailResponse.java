package com.jis.platform.fmj.model.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class FiledDetailResponse {

    @JsonSerialize(
            using = ToStringSerializer.class
    )
     private Long id;

    private Long fieldTypeId;

    private String fieldArray;

    private String comment;

    private String name;

    private String showName;

    private String fieldTypeName;

    private Boolean checkEmpty;

    private Integer sortNo;

    private Integer maxLength;
}

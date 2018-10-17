package com.jis.platform.fmj.model.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class ProductInfoEditRequest extends RegisterInfoCreateRequest {

    @JsonSerialize(using = ToStringSerializer.class )
    private Long id;


}

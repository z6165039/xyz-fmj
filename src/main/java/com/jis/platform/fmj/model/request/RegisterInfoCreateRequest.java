package com.jis.platform.fmj.model.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class RegisterInfoCreateRequest {
    private String commment;

    @JsonSerialize(using = ToStringSerializer.class )
    private Long eventId;

    private String eventName;
    private String name;
    private Long templateId;

}

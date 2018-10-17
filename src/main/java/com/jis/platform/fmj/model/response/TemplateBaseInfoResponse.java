package com.jis.platform.fmj.model.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

@Data
public class TemplateBaseInfoResponse implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long eventId;

    private String title;
    private String backgroundColor;
    private String comment;
    private String name;

}

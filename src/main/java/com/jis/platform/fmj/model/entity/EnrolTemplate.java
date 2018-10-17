package com.jis.platform.fmj.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.jis.platform.fmj.model.common.CommonEntity;
import lombok.Data;

@Data
public class EnrolTemplate  extends CommonEntity{
   
	public EnrolTemplate() {
		this.isDelete = false;
	}

    @JsonSerialize(using = ToStringSerializer.class)
    private Long enterpriseId;

    private String name;


    private String title;

    private String comment;

    private Boolean isDelete;

    private String template;

}
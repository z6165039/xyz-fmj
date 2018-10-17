package com.jis.platform.fmj.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.jis.platform.fmj.model.common.CommonEntity;
import lombok.Data;

@Data
public class EnrolField extends  CommonEntity{
	
	public EnrolField() {
		this.isDelete = false;
		this.system = false;
	}
	
    private Long fieldTypeId;

    @JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;

    private String name;

    private String code;

    private String fieldArray;

    private String comment;

    private Boolean isDelete;

    private Boolean system;

}
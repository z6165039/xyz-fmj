package com.jis.platform.fmj.model.entity;

import com.jis.platform.fmj.model.common.CommonEntity;
import lombok.Data;

@Data
public class EnrolFieldType extends CommonEntity{
	
    private String name;

    private String checkName;
    
    private String comment;

    private Boolean isDelete;
}
package com.jis.platform.fmj.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.Data;

@Data
public class EnrolTemplateFieldRel {

    @JsonSerialize(using = ToStringSerializer.class)
	private Long id;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long templateId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long fieldId;

    private Boolean checkEmpty;

    private Integer sortNo;
    
    private Integer maxLength;
    
    private String showName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public Boolean getCheckEmpty() {
        return checkEmpty;
    }

    public void setCheckEmpty(Boolean checkEmpty) {
        this.checkEmpty = checkEmpty;
    }

    public Long getFieldId() {
		return fieldId;
	}

	public void setFieldId(Long fieldId) {
		this.fieldId = fieldId;
	}

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

	public Integer getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}
    
}
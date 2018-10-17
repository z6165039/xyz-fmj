package com.jis.platform.fmj.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.jis.platform.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "enrol_product_normal_category")
@Data
public class ProductNormalCategory extends BaseEntity {

    private String categoryName;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;

    private String isValid;

    private String memo;

    private Date createTime;

    private Date updateTime;

    @Column(name = "enterprise_id")
    private Long enterpriseId;


}
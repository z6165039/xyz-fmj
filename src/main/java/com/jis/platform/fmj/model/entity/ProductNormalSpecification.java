package com.jis.platform.fmj.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.jis.platform.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Table(name = "enrol_product_normal_specification")
@Data
public class ProductNormalSpecification extends BaseEntity {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long enterpriseId;

    private Integer orders;

    private String name;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long productCategoryId;

    private Date createTime;

    private Date updateTime;

    private String options;

    @Transient
    private String value;

}
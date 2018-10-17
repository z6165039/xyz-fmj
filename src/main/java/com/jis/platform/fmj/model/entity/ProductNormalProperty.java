package com.jis.platform.fmj.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.jis.platform.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Table;
import java.util.Date;

@Table(name = "ent_product_normal_property")
@Data
public class ProductNormalProperty extends BaseEntity {

    private Integer orders;

    private String name;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long productCategoryId;

    private Date createTime;

    private Date updateTime;

    private String options;


}
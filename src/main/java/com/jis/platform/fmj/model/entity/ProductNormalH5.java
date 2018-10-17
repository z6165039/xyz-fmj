package com.jis.platform.fmj.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.jis.platform.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Table;

@Table(name = "enrol_product_normal")
@Data
public class ProductNormalH5 extends BaseEntity {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long productId;

    private String productName;
    private int categoryType;
    private String image;
    private boolean isCreditExchange;
    private Long minCredit;
    private Long minPrice;


    private String showMinPrice;

    public String getShowMinPrice() {
        return minPrice + ".00";
    }
}
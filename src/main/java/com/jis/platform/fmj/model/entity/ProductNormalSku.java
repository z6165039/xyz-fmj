package com.jis.platform.fmj.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.jis.platform.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "enrol_product_normal_sku")
@Data
public class ProductNormalSku extends BaseEntity {

    private Boolean isDefault;

    private Long originalPrice;

    private Long salesPrice;

    private Long deductionCredit;

    private Long rewardCredit;

    private String sn;

    private Integer stock;

    private Long lockingStock;

    private Long totalStock;

    private Long saleAmout;

    private Long cancelQuantity;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long enterpriseId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long productId;

    private Boolean isSales;

    private Integer version;

    private String specificationValues;

    private String specificationDatas;

    //活动名称
    @Transient
    private String activityName;

    /**
     * 商品分类ID
     */
    @Transient
    @JsonSerialize(using = ToStringSerializer.class)
    private Long categroyId;

    /**
     * 商品分类
     */
    @Transient
    private String categroyValue;

    /**
     * 商品名称
     */
    @Transient
    private String productName;

    /**
     * 展示图片
     */
    @Transient
    private String image;

    /**
     * 商品详情或活动详情
     */
    @Transient
    private String detail;

    /**
     * 类型 1：普通商品、2：积分商品
     */
    @Transient
    private Integer productType;

    private Integer inAmount;

    private Integer outAmount;

    /**
     * 商品编号
     */
    @Transient
    private String pid;

    private Long templateId;
}
package com.jis.platform.fmj.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.jis.platform.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Table(name = "enrol_product_normal")
@Data
public class ProductNormal extends BaseEntity {

    private String name;

    private String sn;

    private Integer type;

    private Integer limitType;

    private Integer limitNum;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long categroyId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long venueId;

    private String subTitle;

    private String image;

    private String keyword;

    private Long cost;

    private Integer hits;

    private Boolean isEnable;

    private Long marketPrice;

    private String memo;

    private Long price;

    private Long homePrice;

    private Long maxPrice;

    private Integer sales;

    private String brand;

    private String unit;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long activityId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long enterpriseId;

    private Date validStartDate;

    private Date validEndDate;

    private Boolean isValid;

    private Boolean isTmp;

    private Boolean isLogistics;

    private Boolean isCreditExchange;

    private Long creditMinExchange;

    private Long creditMaxExchange;

    private Boolean isReview;

    private Date createTime;

    private Date updateTime;

    private String introduction;

    private String parameterValues;

    private String propertyValues;

    private String specificationItem;

    private String specificationUsed;

    //积分商品首页字段
    //分类
    @Transient
    private Integer categoryType;

    //商品名称
    @Transient
    private String productName;

    //商品ID
    @Transient
    @JsonSerialize(using = ToStringSerializer.class)
    private Long productId;

    //最低价格
    @Transient
    private Long minPrice;

    //最低积分
    @Transient
    private Long minCredit;

    //排序
    @Transient
    private Integer creditSort;


    //点击量
    private Integer clicks;

    //是否需要核销
    private Boolean isWriteOff;



}
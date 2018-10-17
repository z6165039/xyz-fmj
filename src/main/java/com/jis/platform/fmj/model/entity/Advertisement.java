package com.jis.platform.fmj.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.jis.platform.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "enrol_advertisement")
@Data
public class Advertisement extends BaseEntity {

    /**
     * 企业ID
     */
    @Column(name = "enterprise_id")
    @JsonSerialize(
            using = ToStringSerializer.class
    )
    private Long enterpriseId;

    @Column(name = "adv_name")
    private String advName;

    /**
     * 广告位类型code(数据字典)
     */
    @Column(name = "adv_type_code")
    private String advTypeCode;

    /**
     * 广告位类型值(数据字典)
     */
    @Column(name = "adv_type_value")
    private String advTypeValue;

    /**
     * 广告位图片
     */
    @Column(name = "adv_image")
    private String advImage;

    /**
     * 广告位顺序
     */
    @Column(name = "adv_sort")
    private Integer advSort;

    /**
     * 广告位跳转类型 1无跳转，2列表，3票务商品，4普通商品
     */
    @Column(name = "adv_go_type")
    private Integer advGoType;

    /**
     * 广告位跳转地址
     */
    @Column(name = "adv_go_url")
    private String advGoUrl;

    /**
     * 是否启用 0禁用，1启用
     */
    @Column(name = "is_locked")
    private Boolean isLocked;

}
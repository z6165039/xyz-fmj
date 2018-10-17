package com.jis.platform.fmj.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.jis.platform.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "enrol_mobile_advertisement")
public class MobileAdvertisement extends BaseEntity {
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

    /**
     * 获取企业ID
     *
     * @return enterprise_id - 企业ID
     */
    public Long getEnterpriseId() {
        return enterpriseId;
    }

    /**
     * 设置企业ID
     *
     * @param enterpriseId 企业ID
     */
    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    /**
     * @return adv_name
     */
    public String getAdvName() {
        return advName;
    }

    /**
     * @param advName
     */
    public void setAdvName(String advName) {
        this.advName = advName;
    }

    /**
     * 获取广告位类型code(数据字典)
     *
     * @return adv_type_code - 广告位类型code(数据字典)
     */
    public String getAdvTypeCode() {
        return advTypeCode;
    }

    /**
     * 设置广告位类型code(数据字典)
     *
     * @param advTypeCode 广告位类型code(数据字典)
     */
    public void setAdvTypeCode(String advTypeCode) {
        this.advTypeCode = advTypeCode;
    }

    /**
     * 获取广告位类型值(数据字典)
     *
     * @return adv_type_value - 广告位类型值(数据字典)
     */
    public String getAdvTypeValue() {
        return advTypeValue;
    }

    /**
     * 设置广告位类型值(数据字典)
     *
     * @param advTypeValue 广告位类型值(数据字典)
     */
    public void setAdvTypeValue(String advTypeValue) {
        this.advTypeValue = advTypeValue;
    }

    /**
     * 获取广告位图片
     *
     * @return adv_image - 广告位图片
     */
    public String getAdvImage() {
        return advImage;
    }

    /**
     * 设置广告位图片
     *
     * @param advImage 广告位图片
     */
    public void setAdvImage(String advImage) {
        this.advImage = advImage;
    }

    /**
     * 获取广告位顺序
     *
     * @return adv_sort - 广告位顺序
     */
    public Integer getAdvSort() {
        return advSort;
    }

    /**
     * 设置广告位顺序
     *
     * @param advSort 广告位顺序
     */
    public void setAdvSort(Integer advSort) {
        this.advSort = advSort;
    }

    /**
     * 获取广告位跳转类型 1无跳转，2列表，3票务商品，4普通商品
     *
     * @return adv_go_type - 广告位跳转类型 1无跳转，2列表，3票务商品，4普通商品
     */
    public Integer getAdvGoType() {
        return advGoType;
    }

    /**
     * 设置广告位跳转类型 1无跳转，2列表，3票务商品，4普通商品
     *
     * @param advGoType 广告位跳转类型 1无跳转，2列表，3票务商品，4普通商品
     */
    public void setAdvGoType(Integer advGoType) {
        this.advGoType = advGoType;
    }

    /**
     * 获取广告位跳转地址
     *
     * @return adv_go_url - 广告位跳转地址
     */
    public String getAdvGoUrl() {
        return advGoUrl;
    }

    /**
     * 设置广告位跳转地址
     *
     * @param advGoUrl 广告位跳转地址
     */
    public void setAdvGoUrl(String advGoUrl) {
        this.advGoUrl = advGoUrl;
    }

    /**
     * 获取是否启用 0禁用，1启用
     *
     * @return is_locked - 是否启用 0禁用，1启用
     */
    public Boolean getIsLocked() {
        return isLocked;
    }

    /**
     * 设置是否启用 0禁用，1启用
     *
     * @param isLocked 是否启用 0禁用，1启用
     */
    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }

}
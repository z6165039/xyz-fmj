package com.jis.platform.fmj.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class EnrolMemberDataMember implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long enterpriseId;

    @JsonSerialize(using = ToStringSerializer.class)
    private String templateId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long activityId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long orderId;

    private String orderNo;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long skuId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long memberId;

    private String name;
    private Integer age;
    private Integer gender;
    private String phone;
    private String cardNo;
    private Date joinDate;
    private String email;
    private String contactName;
    private String contactPhone;

    /**
     * 所需积分
     */
    private Long deductionCredit;

    /**
     * 商品图片
     */
    private String image;

    /**
     * 二维码URL
     */
    private String qrCode;

    /**
     * 二维码验证码
     */
    private String qrCodeVerification;

    /**
     * 订单状态
     */
    private int status;

    /**
     * 核销状态
     */
    private int checkStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 模板名称
     */
    private String templateName;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 活动名称
     */
    private String eventName;

    /**
     * 价格
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long salesPrice;

    private String column1;
    private String column2;
    private String column3;
    private String column4;
    private String column5;
    private String column6;
    private String column7;
    private String column8;
    private String column9;
    private String column10;
    private String column11;
    private String column12;
    private String column13;
    private String column14;
    private String column15;
    private String column16;
    private String column17;
    private String column18;
    private String column19;
    private String column20;
    private String column21;
    private String column22;
    private String column23;
    private String column24;
    private String column25;
    private String column26;
    private String column27;
    private String column28;
    private String column29;
    private String column30;
    private String column31;
    private String column32;
    private String column33;
    private String column34;
    private String column35;
    private String column36;
    private String column37;
    private String column38;
    private String column39;
    private String column40;
    private String column41;
    private String column42;
    private String column43;
    private String column44;
    private String column45;
    private String column46;
    private String column47;
    private String column48;
    private String column49;
    private String column50;




}


package com.jis.platform.fmj.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "enrol_member_data")
@Data
public class EnrolMemberDataOrder  implements Serializable {

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

    @JsonSerialize(using = ToStringSerializer.class)
    private Long salesPrice;

    private String salesPriceStr;
}

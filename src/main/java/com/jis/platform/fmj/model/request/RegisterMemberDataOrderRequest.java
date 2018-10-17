package com.jis.platform.fmj.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RegisterMemberDataOrderRequest {

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "会员名称")
    private String memberName;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "购买方式")
    private String paymentMethod;

    @ApiModelProperty(value = "类型")
    private Integer type;

    @ApiModelProperty(value = "开始时间")
    private String startDate;

    @ApiModelProperty(value = "结束时间")
    private String endDate;

    @ApiModelProperty(value = "渠道")
    private String channel;

    @ApiModelProperty(value = "取票方式")
    private String ticketDelivery;

    @ApiModelProperty(value = "企业ID")
    private Long enterpriseId;

    @ApiModelProperty(value = "活动ID")
    private Long eventId;

}

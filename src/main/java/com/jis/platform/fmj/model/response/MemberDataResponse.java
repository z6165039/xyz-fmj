package com.jis.platform.fmj.model.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@Data
public class MemberDataResponse {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String orderNo;
    private Date createTime;
    private String qrCode;
    private Integer checkStatus;
    private String productName;
    private String eventName;
    private Long salesPrice;
    private Long deductionCredit;
    private Long rewardCredit;
    private String specificationDatas;

}

package com.jis.platform.fmj.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "enrol_member_data")
@Data
public class EnrolMemberData implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 企业ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long enterpriseId;

    /**
     * 模板ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long templateId;

    /**
     * 活动ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long activityId;

    /**
     * 订单ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long orderId;

    /**
     * 订单号
     */
    private String orderNo;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long skuId;

    /**
     * 会员ID
     */
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
     * 1：报名成功     2：失败
     */
    private int status;

    /**
     * 核销状态
     */
    private int checkStatus;

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
    private Date createTime;
    private Date updateTime;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getEnterpriseId() {
//        return enterpriseId;
//    }
//
//    public void setEnterpriseId(Long enterpriseId) {
//        this.enterpriseId = enterpriseId;
//    }
//
//    public String getTemplateId() {
//        return templateId;
//    }
//
//    public void setTemplateId(String templateId) {
//        this.templateId = templateId;
//    }
//
//    public Long getActivityId() {
//        return activityId;
//    }
//
//    public void setActivityId(Long activityId) {
//        this.activityId = activityId;
//    }
//
//    public Long getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(Long orderId) {
//        this.orderId = orderId;
//    }
//
//    public String getOrderNo() {
//        return orderNo;
//    }
//
//    public void setOrderNo(String orderNo) {
//        this.orderNo = orderNo;
//    }
//
//    public Long getSkuId() {
//        return skuId;
//    }
//
//    public void setSkuId(Long skuId) {
//        this.skuId = skuId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public Long getGender() {
//        return gender;
//    }
//
//    public void setGender(Long gender) {
//        this.gender = gender;
//    }
//
//
//    public String getCardNo() {
//        return cardNo;
//    }
//
//    public void setCardNo(String cardNo) {
//        this.cardNo = cardNo;
//    }
//
//    public Date getJoinDate() {
//        return joinDate;
//    }
//
//    public void setJoinDate(Date joinDate) {
//        this.joinDate = joinDate;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getContactName() {
//        return contactName;
//    }
//
//    public void setContactName(String contactName) {
//        this.contactName = contactName;
//    }
//
//    public String getContactPhone() {
//        return contactPhone;
//    }
//
//    public void setContactPhone(String contactPhone) {
//        this.contactPhone = contactPhone;
//    }
//
//    public int getStatus() {
//        return status;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }
//
//    public String getColumn1() {
//        return column1;
//    }
//
//    public void setColumn1(String column1) {
//        this.column1 = column1;
//    }
//
//    public String getColumn2() {
//        return column2;
//    }
//
//    public void setColumn2(String column2) {
//        this.column2 = column2;
//    }
//
//    public String getColumn3() {
//        return column3;
//    }
//
//    public void setColumn3(String column3) {
//        this.column3 = column3;
//    }
//
//    public String getColumn4() {
//        return column4;
//    }
//
//    public void setColumn4(String column4) {
//        this.column4 = column4;
//    }
//
//    public String getColumn5() {
//        return column5;
//    }
//
//    public void setColumn5(String column5) {
//        this.column5 = column5;
//    }
//
//    public String getColumn6() {
//        return column6;
//    }
//
//    public void setColumn6(String column6) {
//        this.column6 = column6;
//    }
//
//    public String getColumn7() {
//        return column7;
//    }
//
//    public void setColumn7(String column7) {
//        this.column7 = column7;
//    }
//
//    public String getColumn8() {
//        return column8;
//    }
//
//    public void setColumn8(String column8) {
//        this.column8 = column8;
//    }
//
//    public String getColumn9() {
//        return column9;
//    }
//
//    public void setColumn9(String column9) {
//        this.column9 = column9;
//    }
//
//    public String getColumn10() {
//        return column10;
//    }
//
//    public void setColumn10(String column10) {
//        this.column10 = column10;
//    }
//
//    public String getColumn11() {
//        return column11;
//    }
//
//    public void setColumn11(String column11) {
//        this.column11 = column11;
//    }
//
//    public String getColumn12() {
//        return column12;
//    }
//
//    public void setColumn12(String column12) {
//        this.column12 = column12;
//    }
//
//    public String getColumn13() {
//        return column13;
//    }
//
//    public void setColumn13(String column13) {
//        this.column13 = column13;
//    }
//
//    public String getColumn14() {
//        return column14;
//    }
//
//    public void setColumn14(String column14) {
//        this.column14 = column14;
//    }
//
//    public String getColumn15() {
//        return column15;
//    }
//
//    public void setColumn15(String column15) {
//        this.column15 = column15;
//    }
//
//    public String getColumn16() {
//        return column16;
//    }
//
//    public void setColumn16(String column16) {
//        this.column16 = column16;
//    }
//
//    public String getColumn17() {
//        return column17;
//    }
//
//    public void setColumn17(String column17) {
//        this.column17 = column17;
//    }
//
//    public String getColumn18() {
//        return column18;
//    }
//
//    public void setColumn18(String column18) {
//        this.column18 = column18;
//    }
//
//    public String getColumn19() {
//        return column19;
//    }
//
//    public void setColumn19(String column19) {
//        this.column19 = column19;
//    }
//
//    public String getColumn20() {
//        return column20;
//    }
//
//    public void setColumn20(String column20) {
//        this.column20 = column20;
//    }
//
//    public String getColumn21() {
//        return column21;
//    }
//
//    public void setColumn21(String column21) {
//        this.column21 = column21;
//    }
//
//    public String getColumn22() {
//        return column22;
//    }
//
//    public void setColumn22(String column22) {
//        this.column22 = column22;
//    }
//
//    public String getColumn23() {
//        return column23;
//    }
//
//    public void setColumn23(String column23) {
//        this.column23 = column23;
//    }
//
//    public String getColumn24() {
//        return column24;
//    }
//
//    public void setColumn24(String column24) {
//        this.column24 = column24;
//    }
//
//    public String getColumn25() {
//        return column25;
//    }
//
//    public void setColumn25(String column25) {
//        this.column25 = column25;
//    }
//
//    public String getColumn26() {
//        return column26;
//    }
//
//    public void setColumn26(String column26) {
//        this.column26 = column26;
//    }
//
//    public String getColumn27() {
//        return column27;
//    }
//
//    public void setColumn27(String column27) {
//        this.column27 = column27;
//    }
//
//    public String getColumn28() {
//        return column28;
//    }
//
//    public void setColumn28(String column28) {
//        this.column28 = column28;
//    }
//
//    public String getColumn29() {
//        return column29;
//    }
//
//    public void setColumn29(String column29) {
//        this.column29 = column29;
//    }
//
//    public String getColumn30() {
//        return column30;
//    }
//
//    public void setColumn30(String column30) {
//        this.column30 = column30;
//    }
//
//    public String getColumn31() {
//        return column31;
//    }
//
//    public void setColumn31(String column31) {
//        this.column31 = column31;
//    }
//
//    public String getColumn32() {
//        return column32;
//    }
//
//    public void setColumn32(String column32) {
//        this.column32 = column32;
//    }
//
//    public String getColumn33() {
//        return column33;
//    }
//
//    public void setColumn33(String column33) {
//        this.column33 = column33;
//    }
//
//    public String getColumn34() {
//        return column34;
//    }
//
//    public void setColumn34(String column34) {
//        this.column34 = column34;
//    }
//
//    public String getColumn35() {
//        return column35;
//    }
//
//    public void setColumn35(String column35) {
//        this.column35 = column35;
//    }
//
//    public String getColumn36() {
//        return column36;
//    }
//
//    public void setColumn36(String column36) {
//        this.column36 = column36;
//    }
//
//    public String getColumn37() {
//        return column37;
//    }
//
//    public void setColumn37(String column37) {
//        this.column37 = column37;
//    }
//
//    public String getColumn38() {
//        return column38;
//    }
//
//    public void setColumn38(String column38) {
//        this.column38 = column38;
//    }
//
//    public String getColumn39() {
//        return column39;
//    }
//
//    public void setColumn39(String column39) {
//        this.column39 = column39;
//    }
//
//    public String getColumn40() {
//        return column40;
//    }
//
//    public void setColumn40(String column40) {
//        this.column40 = column40;
//    }
//
//    public String getColumn41() {
//        return column41;
//    }
//
//    public void setColumn41(String column41) {
//        this.column41 = column41;
//    }
//
//    public String getColumn42() {
//        return column42;
//    }
//
//    public void setColumn42(String column42) {
//        this.column42 = column42;
//    }
//
//    public String getColumn43() {
//        return column43;
//    }
//
//    public void setColumn43(String column43) {
//        this.column43 = column43;
//    }
//
//    public String getColumn44() {
//        return column44;
//    }
//
//    public void setColumn44(String column44) {
//        this.column44 = column44;
//    }
//
//    public String getColumn45() {
//        return column45;
//    }
//
//    public void setColumn45(String column45) {
//        this.column45 = column45;
//    }
//
//    public String getColumn46() {
//        return column46;
//    }
//
//    public void setColumn46(String column46) {
//        this.column46 = column46;
//    }
//
//    public String getColumn47() {
//        return column47;
//    }
//
//    public void setColumn47(String column47) {
//        this.column47 = column47;
//    }
//
//    public String getColumn48() {
//        return column48;
//    }
//
//    public void setColumn48(String column48) {
//        this.column48 = column48;
//    }
//
//    public String getColumn49() {
//        return column49;
//    }
//
//    public void setColumn49(String column49) {
//        this.column49 = column49;
//    }
//
//    public String getColumn50() {
//        return column50;
//    }
//
//    public void setColumn50(String column50) {
//        this.column50 = column50;
//    }
//
//    public Date getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }
//
//    public Date getUpdateTime() {
//        return updateTime;
//    }
//
//    public void setUpdateTime(Date updateTime) {
//        this.updateTime = updateTime;
//    }
}

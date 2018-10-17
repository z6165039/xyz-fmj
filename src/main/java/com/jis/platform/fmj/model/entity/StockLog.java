package com.jis.platform.fmj.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.jis.platform.common.entity.BaseEntity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ent_stock_log")
@Data
public class StockLog extends BaseEntity {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long skuId;

    private Long inAmount;

    private Long outAmount;

    private Long lockNum;

    private Long saleAmout;

    private Long currentStock;

    private String memo;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long employeeId;

    @JSONField(format="yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    @Column(name="int_date")
    protected Date intDate;

    @JSONField(format="yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    @Column(name="out_date")
    protected Date outDate;

    @Transient
    private String employeeName;

    private Integer stockType;

    private String orderNo;
}
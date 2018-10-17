package com.jis.platform.fmj.model.entity;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "enrol_order_error_log")
@Data
public class EnrolOrderErrorLog  implements Serializable {

    private String orderNo;

    private Integer errorCount;

    private String msg;

}
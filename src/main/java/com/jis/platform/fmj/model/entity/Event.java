package com.jis.platform.fmj.model.entity;

import com.jis.platform.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "enrol_event")
@Data
public class Event extends BaseEntity {


    /**
     * 活动名称
     */
    private String name;

    private String intrudution;

    /**
     * 活动须知
     */
    @Column(name = "event_notice")
    private String eventNotice;

    /**
     * 活动开始日期
     */
    @Column(name = "start_date")
    private Date startDate;

    /**
     * 活动结束日期
     */
    @Column(name = "end_date")
    private Date endDate;


    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Column(name = "enterprise_id")
    private Long enterpriseId;

    @Column(name = "event_type")
    private String eventType;

    private String address;

    @Column(name = "is_ticket_warehouse")
    private Boolean isTicketWarehouse;
}
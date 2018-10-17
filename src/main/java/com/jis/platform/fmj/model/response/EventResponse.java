package com.jis.platform.fmj.model.response;

import com.jis.platform.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class EventResponse extends BaseEntity {


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


}
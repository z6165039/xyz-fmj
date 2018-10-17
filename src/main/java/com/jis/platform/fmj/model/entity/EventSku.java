package com.jis.platform.fmj.model.entity;

import lombok.Data;

@Data
public class EventSku {
    private Long skuId;
    private String eventName;
    private String specificationDatas;
    private String specificationValues;
    private Long templateId;
    private String productName;
    private String sheetName;
}

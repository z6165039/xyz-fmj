package com.jis.platform.fmj.model.request;

import lombok.Data;

@Data
public class RegisterSkusCreateRequest {

    private String skuName;

    /**
     * 成本价格
     */
    private Long costPrice;

    /**
     * 所需价格
     */
    private Long givePoint;

    /**
     * 所需积分
     */
    private Long needPoint;

    /**
     * 赠送积分
     */
    private Long salePrice;

    /**
     * 库存
     */
    private Long stock;

}

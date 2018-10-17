package com.jis.platform.fmj.model.request;

import com.jis.platform.fmj.model.entity.ProductNormal;
import com.jis.platform.fmj.model.entity.ProductNormalSku;
import lombok.Data;

import java.util.ArrayList;

@Data
public class RegisterNormalVo {

    /** 商品信息 */
    public ProductNormal productNormal;

    /** 商品sku信息 */
    public ArrayList<ProductNormalSku> productNormalSkuList;

    /** 商品标签 */
//    ArrayList<ProductTag> productTagList;

}
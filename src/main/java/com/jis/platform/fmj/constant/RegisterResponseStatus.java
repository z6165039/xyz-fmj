package com.jis.platform.fmj.constant;

import com.jis.platform.common.exception.ResponseStatus;

public class RegisterResponseStatus extends ResponseStatus {


    //62开头为企业异常
    public static final ResponseStatus MODIFY_EXCEPTION = new RegisterResponseStatus(62001,"更新异常!");
    public static final ResponseStatus GETTING_DATA_EXCEPTION = new RegisterResponseStatus(62002,"获取数据异常!");
    public static final ResponseStatus PARAMETER_ERROR = new RegisterResponseStatus(50002,"参数错误：%s！");

    //63开头为商品异常
    public static final ResponseStatus DATE_ERROR = new RegisterResponseStatus(63002,"不在报名时间段！");
    public static final ResponseStatus STOCK_ERROR = new RegisterResponseStatus(63003,"名额不足！");
    public static final ResponseStatus USER_ERROR = new RegisterResponseStatus(63003,"用户报名数据已存在！");

    //64为俱乐部异常

    //65后端异常

    private RegisterResponseStatus(int code, String reason) {
        super(code, reason);
    }

    public static final ResponseStatus NOT_FOUND = new RegisterResponseStatus(50001, "%s not found!");
    public static final ResponseStatus REQUIRED_PARAM = new RegisterResponseStatus(5003, "需要参数%s");

    //62开头为企业异常
    public static final ResponseStatus STOCK_MODIFY_EXCEPTION = new RegisterResponseStatus(62001, "%s失败,请重新再试!");
    public static final ResponseStatus PARAMETER_EXCEPTION = new RegisterResponseStatus(62004, "参数异常[%s]!");
    public static final ResponseStatus USER_ENTERPRISE_NOT_FOUND = new RegisterResponseStatus(62005, "用户[%s]所属企业未找到!");
    //63开头为商品异常
    public static final ResponseStatus PRODUCT_NO_SKU = new RegisterResponseStatus(63021, "商品[%s]无SKU,无法上架");

    public static final ResponseStatus LOCK_STOCK_ERROR = new RegisterResponseStatus(63041, "sku存在锁定数量,无法修改");
    public static final ResponseStatus PRODUCT_NOT_FOUND_BY_ID = new RegisterResponseStatus(63043, "根据ID[%s]未找到商品");
    public static final ResponseStatus ADV_NOT_FOUND_BY_ID = new RegisterResponseStatus(63044, "根据ID[%s]未找到广告");

    //64为俱乐部异常

    //65后端异常

    //66会员异常
    public static final ResponseStatus NULL_PARAM = new RegisterResponseStatus(66001, "未获取到用户信息!");

    //67消息类异常
    public static final ResponseStatus SENDER_NOT_FOUND = new RegisterResponseStatus(67001, "类型[%s]的发送者未找到");

    //70票务商品下单异常
    public static final ResponseStatus TICKET_NOT_FOUND = new RegisterResponseStatus(70001, "该商品不存在");
    public static final ResponseStatus TICKET_NOT_VALID = new RegisterResponseStatus(70002, "该商品已下架");
    public static final ResponseStatus TICKET_NOT_SALES = new RegisterResponseStatus(70003, "该商品不可售");
    public static final ResponseStatus TICKET_NOT_ENOUGH_STOCK = new RegisterResponseStatus(70004, "该商品库存不足");
    public static final ResponseStatus PRODUCT_ERROR_LIMIT = new RegisterResponseStatus(70006, "购买数量不得超出限购数量");
    public static final ResponseStatus PRODUCT_MEM_LIMIT = new RegisterResponseStatus(70007, "购买数量不得超出账户限购数量");


    public static final ResponseStatus FIELD_REQUIRED = new RegisterResponseStatus(50003, "%s 不能为空");
    public static final ResponseStatus VALUE_INVALID = new RegisterResponseStatus(50005, "%s无效");

    //订单
    public static final ResponseStatus FIELD_MATE = new RegisterResponseStatus(60001, "%s匹配错误");
    public static final ResponseStatus NOT_ENOUGH = new RegisterResponseStatus(60002, "%s不足");
    public static final ResponseStatus PAY_FAIL = new RegisterResponseStatus(60003, "支付失败");
    public static final ResponseStatus PAY_WAIT = new RegisterResponseStatus(60004, "确定订单,请等待");
    public static final ResponseStatus PAY_ORDER_NO_ERROR = new RegisterResponseStatus(60005, "订单号不能为空");
    public static final ResponseStatus PAY_ORDER_CLOSE = new RegisterResponseStatus(60006, "订单已取消");

}

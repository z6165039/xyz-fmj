package com.jis.platform.fmj.constant;

/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-06-17 14:41
 */
public class Constant {

    public static int OK_REQUEST_CODE = 200;

    public static int PW_ENCORDER_SALT = 12;
    /**根节点*/
    public final static Long ROOT = 0l;
    /** 状态:有效 */
    public static final String STATUS_TRUE = "1";
    /** 状态:无效 */
    public static final String STATUS_FALSE = "0";

    /** 状态:有效 */
    public static final Integer LOCKED_TRUE = 1;
    /** 状态:无效 */
    public static final Integer LOCKED_FALSE = 0;

    /** 逗号 */
    public static final String COMMA = ",";
    /** 随机码 */
    public static final Integer PWD_WAY_RANDOM = 1;
    /** 身份证 */
    public static final Integer PWD_WAY_IDCARD = 2;
    /** 比较用0 */
    public static final Integer COMPARETO_ZERO = 0;

    /** 正序 **/
    public static final Integer ORDER_BY_ASC = 1;
    /** 反序 **/
    public static final Integer ORDER_BY_DESC = 2;

    public static final String ENTERPRISE_ID  = "enterpriseId";

    /** 检票口 **/
    public static final Integer SHOW_TYPE_ONE = 1;

    /** 入口 **/
    public static final Integer SHOW_TYPE_TWO = 2;

    /** 站台 **/
    public static final Integer SHOW_TYPE_THREE = 3;

    /** 活动状态 0:未开始 **/
    public static final Integer EVENT_STATUS_ZORE = 0;
    /** 活动状态 1:进行中 **/
    public static final Integer EVENT_STATUS_ONE = 1;
    /** 活动状态 2:已结束 **/
    public static final Integer EVENT_STATUS_TWO = 2;

    /**  返回成功  **/
    public static final int RES_SUCCESS_CODE = 200;

    public static int BAD_REQUEST_CODE = 400;

    public static String BAD_REQUEST_REASON = "错误请求";

    /** 三方库存座位选中  **/
    public static final Integer EXTERNAL_STOCK_SEAT_STATUS_ZORE = 0;

    /** 三方库存座位已预订  **/
    public static final Integer EXTERNAL_STOCK_SEAT_STATUS_ONE = 1;

    /** 三方库存座位已使用  **/
    public static final Integer EXTERNAL_STOCK_SEAT_STATUS_TWO = 2;

    /** 三方库存座位可售  **/
    public static final Integer EXTERNAL_STOCK_SEAT_STATUS_EIGHTEEN = 18;


    /** 订单状态 (1-待支付、2-待审核 、3-已支付、4-已审核、5-拒绝、6-已取消、7－已完成) **/
    public static final Integer ORDER_STATUS_ONE = 1;
    public static final Integer ORDER_STATUS_TWO = 2;
    public static final Integer ORDER_STATUS_THREE = 3;
    public static final Integer ORDER_STATUS_FOUR = 4;
    public static final Integer ORDER_STATUS_FIVE = 5;
    public static final Integer ORDER_STATUS_SIX = 6;
    public static final Integer ORDER_STATUS_SEVEN = 7;

    /** 物流状态(1 - 待发货、2 - 已发货).  **/
    public static final Integer SHIPPING_STATUS_ZERO = 0;
    public static final Integer SHIPPING_STATUS_ONE = 1;
    public static final Integer SHIPPING_STATUS_TWO = 2;

    /** 订单类型. (1-  票务、2 - 普通商品、3 - G码、 4 - 积分兑换) **/
    public static final Integer ORDER_TYPE_ONE = 1;

    public static final Integer ORDER_TYPE_TWO = 2;

    public static final Integer ORDER_TYPE_THREE = 3;

    public static final Integer ORDER_TYPE_FOUR = 4;

    public static final String JSON_CONTCATS = "contcats";
    public static final String JSON_SPECIFICATION = "specification";

    public static final String BRACES_LEFT = "{";
    public static final String BRACES_RIGHT = "}";
    public static final String COLON = ":";
    public static final String BRACKET_LEFT = "[";
    public static final String BRACKET_RIGHT = "]";
    public static final String DOUBLE_QUOTES = "\"";

    /** 订单创建是过期时间为15分钟 **/
    public static final Integer EXPIRE_DATE_TIME = 15;

    /** 取票方式'WINDOWTICKET 窗口取票','LOGISTICS 物流','DOORTICKET 上门取票','ETICKET 电子票' **/
    public static final String TICKET_DELIVERY_WINDOWTICKET = "WINDOWTICKET";
    public static final String TICKET_DELIVERY_LOGISTICS = "LOGISTICS";
    public static final String TICKET_DELIVERY_DOORTICKET = "DOORTICKET";
    public static final String TICKET_DELIVERY_ETICKET = "ETICKET";

    /** 发票类型 **/
    public static final String INVOICE_TYPE_ENT_KEY = "ENT";
    public static final String INVOICE_TYPE_ENT_VALUE = "企业";
    public static final String INVOICE_TYPE_PERSON_KEY = "PERSON";
    public static final String INVOICE_TYPE_PERSON_VALUE = "个人";

    /**  上门取票地址 **/
    public static final String MESSAGE_ADDRESS_VISIT = "message_address_visit";
    /** 窗口自取地址 **/
    public static final String MESSAGE_ADDRESS_WINDOW = "message_address_window";

    /** 逗号 */
    public static final String SPACE = " ";

    public static final String SET_METHOD = "set";
    public static final String GET_METHOD = "get";

    public static final String EVENT_SHEET_NAME = "活动报名表格.xlsx";
}

package com.jis.platform.fmj.sfexpress;

import com.jis.platform.common.context.BaseContextHandler;
import com.jis.platform.fmj.component.EnterpriseInstace;
import com.jis.platform.fmj.constant.Constant;

public class ContextUtils {


    public static Long getEnterpriseId() {
        return Long.valueOf(String.valueOf(BaseContextHandler.get(Constant.ENTERPRISE_ID)));
    }


    public static Long getMemberId() {
        return EnterpriseInstace.getCurrentUserId();
    }


    public static String getMemberName() {
        return String.valueOf(BaseContextHandler.getName());
    }





}
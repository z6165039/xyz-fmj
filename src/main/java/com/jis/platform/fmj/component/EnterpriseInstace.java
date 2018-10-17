package com.jis.platform.fmj.component;

import com.jis.platform.common.context.BaseContextHandler;
import com.jis.platform.fmj.model.common.Enterprise;

import java.util.List;
import java.util.Vector;

public class EnterpriseInstace {


    public static final EnterpriseInstace INSTACE = new EnterpriseInstace();

    private EnterpriseInstace(){}

    private  List<Enterprise> data = new Vector<>();

    public synchronized Long getEnterpriseId(Long userId){
//        if(data.size() == 0){
//            return enterpriseId(userId);
//        }
        for(Enterprise en : data){
            if(en.getUserId().longValue() == userId.longValue()){
                return en.getEnterpriseId();
            }
        }
//        return enterpriseId(userId);
        return null;
    }
    public synchronized Long getEnterpriseId(){
//        return 10000L;//test

        Long userId = getCurrentUserId();
        return getEnterpriseId(userId);
    }

    public  void setEnterpriseId(Long enterpriseId, Long userId){
        Enterprise en = new Enterprise();
        en.setEnterpriseId(enterpriseId);
        en.setUserId(userId);
        data.add(en);
    }

    public static Long getCurrentUserId(){
        String str = BaseContextHandler.getUserID();
        if(org.apache.commons.lang3.StringUtils.isBlank(str)){
            return 0L;
        }
        return Long.valueOf(str);
    }
}

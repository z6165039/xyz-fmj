package com.jis.platform.fmj.sfexpress;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.jis.platform.fmj.model.request.RegisterTemplateFieldRelCreateRequest;
import com.jis.platform.fmj.model.response.FieldCheckResponse;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class FormaterUtils {
    /**
     * 性格值
     */
    public static Integer getSexValue(String value){
        if("男".equals(value)){
            return 0;
        }else if("女".equals(value)){
            return 1;
        }
        return 2;
    }

    public static  List<FieldCheckResponse> getTemplate(String template){
        return request2FieldCheckResponse(getTemplateObject(template));
    }

    public static List<RegisterTemplateFieldRelCreateRequest> getTemplateObject(String template){
        return JSONArray.parseObject(template, new TypeReference<ArrayList<RegisterTemplateFieldRelCreateRequest>>() {});
    }

    private static List<FieldCheckResponse> request2FieldCheckResponse(List<RegisterTemplateFieldRelCreateRequest> list){
        List<FieldCheckResponse> fieldList = new ArrayList<>();
        for(RegisterTemplateFieldRelCreateRequest request : list){
            FieldCheckResponse res = new FieldCheckResponse();
            BeanUtils.copyProperties(request,res);
            res.setId(request.getFieldId());
            fieldList.add(res);
        }
        return fieldList;
    }
}

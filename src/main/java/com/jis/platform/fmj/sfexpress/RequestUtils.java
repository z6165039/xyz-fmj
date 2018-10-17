package com.jis.platform.fmj.sfexpress;

import com.jis.platform.common.util.Query;
import com.jis.platform.fmj.component.EnterpriseInstace;
import tk.mybatis.mapper.entity.Example;

import java.util.Iterator;
import java.util.Map;

public class RequestUtils {

    public static void getExample(Example example, Query query){
        if (query.entrySet().size() > 0) {
            // 分类名称
            Example.Criteria criteriaDictName = example.createCriteria();
            criteriaDictName.andEqualTo("enterpriseId", EnterpriseInstace.INSTACE.getEnterpriseId());
            criteriaDictName.andEqualTo("parentId", query.get("parentId"));
            criteriaDictName.andLike("categoryName", "%" + query.get("keyword") + "%");

            // 备注
            Example.Criteria criteriaDictKey = example.createCriteria();
            criteriaDictKey.andEqualTo("enterpriseId", EnterpriseInstace.INSTACE.getEnterpriseId());
            criteriaDictKey.andEqualTo("parentId", query.get("parentId").toString());
            criteriaDictKey.andLike("memo", "%" + query.get("keyword").toString() + "%");
            example.or(criteriaDictKey);
        }
    }

    public static void commonQueryHandler(Example example, Query query){
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            Iterator var5 = query.entrySet().iterator();

            while (var5.hasNext()) {
                Map.Entry<String, Object> entry = (Map.Entry) var5.next();
                criteria.andLike((String) entry.getKey(), "%" + entry.getValue().toString() + "%");
            }
        }
    }

    public static void commonMapHandler(Example example, Map<String, Object> params){
        if (params.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            Iterator var5 = params.entrySet().iterator();

            while (var5.hasNext()) {
                Map.Entry<String, Object> entry = (Map.Entry) var5.next();
                criteria.andLike((String) entry.getKey(), "%" + entry.getValue().toString() + "%");
            }
        }
    }
}

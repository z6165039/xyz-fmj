package com.jis.platform.fmj.sfexpress;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

public class ObjectUtils {

    public static void transMap2Bean(Map<String, Object> map, Object obj) {
        //ConvertUtils.fmj(new DateLocaleConverter(), Date.class);
        ConvertUtils.register(new Converter()
        {


            @SuppressWarnings("rawtypes")
            @Override
            public Object convert(Class arg0, Object arg1)
            {
                if(arg1 == null)
                {
                    return null;
                }
                if(!(arg1 instanceof String))
                {
                    throw new ConversionException("只支持字符串转换 !");
                }
                String str = (String)arg1;
                if(str.trim().equals(""))
                {
                    return null;
                }

                SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                try{
                    return sd.parse(str);
                }
                catch(ParseException e)
                {
                    throw new RuntimeException(e);
                }

            }

        }, java.util.Date.class);
        if (map == null || obj == null) {
            return;
        }
        try {
            BeanUtils.populate(obj, map);
        } catch (Exception e) {
            System.out.println("Map<String,Object>转化Bean异常：" + e);
        }
    }

}

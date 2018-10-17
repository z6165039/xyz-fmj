package com.jis.platform.fmj.sfexpress;

import java.util.HashSet;
import java.util.Set;

public class SetUtils {

    public static Set<String> array2set(String ...ids){
        Set<String> set = new HashSet<>();
        if(ids == null || ids.length == 0){
            return set;
        }

        for(String id : ids){
            set.add(id);
        }
        return set;
    }

    public static Set<Long> array2setLong(String ...ids){
        Set<Long> set = new HashSet<>();
        if(ids == null || ids.length == 0){
            return set;
        }

        for(String id : ids){
            set.add(Long.valueOf(id));
        }
        return set;
    }
}

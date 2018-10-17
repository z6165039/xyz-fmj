package com.jis.platform.fmj.sfexpress;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelData implements Serializable {

    private static final long serialVersionUID = 4444017239100620999L;

    /**
     * 表头
     */
    private List<String> titles;

//    /**
//     * 数据
//     */
//    private List<LinkedHashMap<String,Object>> rows;

    /**
     * 数据
     */
    private Map<String, List<LinkedHashMap<String,Object>>> datas;

    public Map<String, List<LinkedHashMap<String, Object>>> getDatas() {
        return datas;
    }

    public void setDatas(Map<String, List<LinkedHashMap<String, Object>>> datas) {
        this.datas = datas;
    }

//    /**
//     * 页签名称
//     */
//    private String name;

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<LinkedHashMap<String, Object>> getRows() {
//        return rows;
//    }
//
//    public void setRows(List<LinkedHashMap<String, Object>> rows) {
//        this.rows = rows;
//    }
}
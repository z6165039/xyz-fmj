/**
 * 
 */
package com.jis.platform.fmj.sfexpress;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author huming.wang
 * 2016-5-23 下午07:55:34 
 * com.huifu.util.httpClient.JsonUtils
 */
public class JsonUtils {

    /**
     * 通过字符串转换为MAP(以页面传递的参数为key 例如：{"OperId":"13818930251"}" key为OperId )
     * @param jsonStr
     * @return
     */
    public static Map<String, String> readJSON2MapUnderScore(String jsonStr) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = objectMapper.readTree(jsonStr);
        Map<String, String> map = new HashMap<String, String>();
        Entry<String, JsonNode> jsonNode = null;
        for (Iterator<Entry<String, JsonNode>> iterator = node.fields(); iterator.hasNext();) {
            jsonNode = iterator.next();
            map.put(jsonNode.getKey(), jsonNode.getValue().asText());
        }
        return map;
    }

    /**
     * 方法名称:transMapToString
     * 传入参数:map
     * 返回值:String 形如 {username:['chenziwen''www']}
     */
    public static String transMapToString(Map<String, String[]> map){
        Entry entry;
        StringBuffer sb = new StringBuffer();
        for(Iterator iterator = map.entrySet().iterator(); iterator.hasNext();)
        {
            sb.append("{");
            entry = (Entry)iterator.next();
            sb.append(entry.getKey().toString()).append(":[");
            if(null==entry.getValue()){
                sb.append( "''" );
            }else{
                String[] entryVal = (String[]) entry.getValue();
                for(int i=0;i<entryVal.length;i++){
                    sb.append("'").append(entryVal[i]).append("'");
                    if(i != entryVal.length-1){
                        sb.append(",");
                    }
                }
            }
            sb.append( "]}" ).append (iterator.hasNext() ? "," : "");
        }
        return sb.toString();
    }
}

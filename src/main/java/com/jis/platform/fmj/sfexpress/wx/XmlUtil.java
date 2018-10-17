package com.jis.platform.fmj.sfexpress.wx;

import java.util.Map;


public class XmlUtil {
	// 生成XML报文
	
	//下订单接口 服务名称：OrderService 接入编码：统一由顺丰 BSP 系统管理员分配
	public String OrderXML(Map<String,String> consigneeInfos) {
		StringBuffer xmlString = new StringBuffer();

		/**
		 * TODO  参数目前写死
		 */
		String bspcode="0219846576";

		xmlString.append("<?xml version='1.0' encoding='UTF-8'?><Request service='OrderService' lang='zh-CN'><Head>");
		xmlString.append(bspcode);
		xmlString.append("</Head><Body><Order ");
		//Order元素内信息放入
		for(String key : consigneeInfos.keySet()){
			xmlString.append(key+"="+"'"+ consigneeInfos.get(key)+"' ");
		}
		
		xmlString.append("></Order></Body></Request>");
		return xmlString.toString();
	}

	//路由查询接口 服务名称 ：RouteService 接入编码：统一由顺丰 BSP 系统管理员分配
	public String RouteXML(Map<String,String> routeInfos) {
		StringBuffer xmlString = new StringBuffer();

		/**
		 * TODO  参数目前写死
		 */
		String bspcode="0219846576";

		xmlString.append("<?xml version='1.0' encoding='UTF-8'?><Request service='RouteService' lang='zh-CN'><Head>");
		xmlString.append(bspcode);
		xmlString.append("</Head><Body><RouteRequest ");
		//<RouteRequest元素内信息放入
		for(String key : routeInfos.keySet()){
			xmlString.append(key+"="+"'"+ routeInfos.get(key)+"' ");
		}
		
		xmlString.append("/></Body></Request>");
		return xmlString.toString();
	}
	
}

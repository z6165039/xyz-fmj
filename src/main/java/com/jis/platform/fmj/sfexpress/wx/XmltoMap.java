package com.jis.platform.fmj.sfexpress.wx;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class XmltoMap {

	@SuppressWarnings("rawtypes")
	public Map<String, String> OrderResponse(String resultXmlStr)
			throws Exception {

		Map<String, String> resultMap = new HashMap<String, String>();// 存放解析结果

		Document document = DocumentHelper.parseText(resultXmlStr);
		Element root = document.getRootElement();// 根节点

		String resultFlag = "";// Xml响应结果是OK还是ERR
		for (Iterator it = root.elementIterator(); it.hasNext();) {
			Element element = (Element) it.next();
			if ("Head".equals(element.getName())) {//Head节点
				resultFlag = element.getText();
			}// 先取出Head判断成功还是失败

			if ("OK".equals(resultFlag)) {//响应结果：OK
				resultMap.put("status", "OK");
				if ("Body".equals(element.getName())) {
					for (Iterator subit = element.elementIterator(); subit
							.hasNext();) {//迭代Body节点
						Element subelement = (Element) subit.next();

						if ("OrderResponse".equals(subelement.getName())) {
							//迭代OrderResponse节点里的所有元素并放入resultMap
							for (Iterator attrit = subelement
									.attributeIterator(); attrit.hasNext();) {
								Attribute attribute = (Attribute) attrit.next();
								resultMap.put(attribute.getName(),
										attribute.getText());

							}
						}
					}
				}

			} else {//响应结果：ERR
				if ("ERROR".equals(element.getName())) {
					resultMap.put("status", "ERR");
					resultMap.put("msg", element.getText());
				}
			}
		}
		return resultMap;
	}


	@SuppressWarnings("rawtypes")
	public JSONArray sfRoute(String resultXmlStr)
			throws Exception {
		
		JSONArray routeArray = new JSONArray();// 存放解析结果（全部路由信息）

		Document document = DocumentHelper.parseText(resultXmlStr);
		Element root = document.getRootElement();// 根节点
		
		String resultFlag = "";// Xml响应结果是OK还是ERR
		for (Iterator it = root.elementIterator(); it.hasNext();) {
			Element element = (Element) it.next();
			if ("Head".equals(element.getName())) {//Head节点
				resultFlag = element.getText();
			}// 先取出Head判断成功还是失败

			if ("OK".equals(resultFlag)) {//响应结果：OK
				if ("Body".equals(element.getName())) {
					Element subelement = element.element("RouteResponse");
					if (subelement != null) {//无物流信息时无RouteResponse节点
						String mailno = subelement.attributeValue("mailno");
						String orderid = subelement.attributeValue("orderid");
						for (Iterator routeit = subelement.elementIterator(); routeit
								.hasNext();) {// 迭代RouteResponse节点
							Element route = (Element) routeit.next();
							JSONObject routeJSOn=new JSONObject();//存放单条路由信息
							if ("Route".equals(route.getName())) {
								routeJSOn.put("status", "OK");
								routeJSOn.put("mailno", mailno);
								routeJSOn.put("orderid", orderid);
								// 迭代Route节点里的所有元素并放入route
								for (Iterator attrit = route
										.attributeIterator(); attrit.hasNext();) {
									Attribute attribute = (Attribute) attrit
											.next();
									routeJSOn.put(attribute.getName(),
											attribute.getText());

								}
							}
							routeArray.add(routeJSOn);
						}
					}

				}

			} else {//响应结果：ERR
				JSONObject routeJSOn=new JSONObject();//存放单条路由信息
				if ("ERROR".equals(element.getName())) {
					routeJSOn.put("status", "ERR："+element.getText());
				}
				routeArray.add(routeJSOn);
			}
		}
		return routeArray;
	}
	
}

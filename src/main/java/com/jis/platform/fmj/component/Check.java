/**
 * Project Name:jis-platform-fmj
 * File Name:Check.java
 * Package Name:com.jis.platform.fmj.component
 * Date:2018年6月12日下午5:17:39
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.jis.platform.fmj.component;

import com.jis.platform.fmj.model.request.RegisterFieldDetailsValueRequest;
import com.jis.platform.fmj.model.response.FieldCheckResponse;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * ClassName:Check <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年6月12日 下午5:17:39 <br/>
 * @author   zhangpei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class Check {

	private static Class<?> threadClazz = null;
	
	public static String check(List<RegisterFieldDetailsValueRequest> details, List<FieldCheckResponse> fieldList)  {
		try {
			if(null == threadClazz) {
				threadClazz = Class.forName("com.jis.platform.fmj.sfexpress.CheckFieldUtils");
			}
			
			for(RegisterFieldDetailsValueRequest detail : details) {
				for(FieldCheckResponse checkField : fieldList ){
					if(detail.getFieldId().longValue() == checkField.getId().longValue()){
						String value = detail.getFieldValue();
						String result = check(checkField,value);
						if(!StringUtils.isEmpty(result)){
							return result;
						}
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}  
		return null;
	}

	private static String check(FieldCheckResponse checkField, String value)  {
		String methodName = checkField.getCheckName();
		if(StringUtils.isEmpty(methodName)){
			return null;
		}
		String name = checkField.getName();
		int maxLength = checkField.getMaxLength();
		boolean isCheckEmpty= checkField.isCheckEmpty();

		boolean checkEmptyResult = checkEmpty(isCheckEmpty, value);
		if(!checkEmptyResult){
			return name+"不能为空！";
		}

		boolean checkMaxLenResult = checkMaxLen(maxLength, value);
		if(!checkMaxLenResult){
			return name+"超出最大长度(" + maxLength +")！";
		}

		boolean checkMethodResult = checkMethod(methodName, value);
		if(!checkMethodResult){
			return name+"输入不符合规范！";
		}


		return null;
	}


	private static boolean checkMethod(String methodName, String value) {
		if(StringUtils.isEmpty(methodName)) {
			return true;
		}
		try {
			Method method = threadClazz.getMethod(methodName, String.class);
			return (boolean) method.invoke(threadClazz,value);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return true;
	}

	private static boolean checkEmpty(boolean isCheckEmpty, String methodName){
		if(!isCheckEmpty){
			return true;
		}
		return !StringUtils.isEmpty(methodName);
	}

	private static boolean checkMaxLen(int maxLen, String value){
		if(StringUtils.isEmpty(value) || maxLen == 0){
			return true;
		}
		return  value.length() <= maxLen;
	}
}


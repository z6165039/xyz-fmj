/**
 * Copyright 2016 (c) Shanghai TY Technology Co.,Ltd. All Rights Reserved.
 */
package com.jis.platform.fmj.model.common;


/**
 * 
 * @author zp
 * @version 1.0.0
 * 
 */
public enum OrderStatus {

	//成功
	SUCESS(1),
	//失败
	ERROR(2);
	

	private int value;

	OrderStatus(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
	
}

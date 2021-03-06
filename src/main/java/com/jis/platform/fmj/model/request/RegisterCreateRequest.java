/**
 * Project Name:jis-platform-fmj
 * File Name:TemplateCreate.java
 * Package Name:com.jis.platform.fmj.model.request
 * Date:2018年6月8日上午10:35:19
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.jis.platform.fmj.model.request;

import java.util.List;

/**
 * ClassName:TemplateCreate <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年6月8日 上午10:35:19 <br/>
 * 
 * @author zhangpei
 * @version
 * @since JDK 1.8
 * @see
 */
public class RegisterCreateRequest {


	private RegisterInfoCreateRequest product;
	private List<RegisterSkusCreateRequest> skus;

	public RegisterInfoCreateRequest getProduct() {
		return product;
	}

	public void setProduct(RegisterInfoCreateRequest product) {
		this.product = product;
	}

	public List<RegisterSkusCreateRequest> getSkus() {
		return skus;
	}

	public void setSkus(List<RegisterSkusCreateRequest> skus) {
		this.skus = skus;
	}
}

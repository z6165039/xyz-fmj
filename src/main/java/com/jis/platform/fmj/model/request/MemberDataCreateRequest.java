/**
 * Project Name:jis-platform-fmj
 * File Name:MemberDataCreateRequest.java
 * Package Name:com.jis.platform.fmj.model.request
 * Date:2018年6月12日下午2:59:09
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.jis.platform.fmj.model.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.List;

/**
 * ClassName:MemberDataCreateRequest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年6月12日 下午2:59:09 <br/>
 * @author   zhangpei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class MemberDataCreateRequest {


	@JsonSerialize(using = ToStringSerializer.class)
	private Long skuId;

	private List<RegisterFieldDetailsValueRequest> memberDataDetail;

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public List<RegisterFieldDetailsValueRequest> getMemberDataDetail() {
		return memberDataDetail;
	}

	public void setMemberDataDetail(List<RegisterFieldDetailsValueRequest> memberDataDetail) {
		this.memberDataDetail = memberDataDetail;
	}
}


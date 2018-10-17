/**
 * Project Name:jis-platform-fmj
 * File Name:TemplateCreate.java
 * Package Name:com.jis.platform.fmj.model.request
 * Date:2018年6月8日上午10:35:19
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.jis.platform.fmj.model.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName:TemplateCreate <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年6月8日 上午10:35:19 <br/>
 * 
 * @author zhangpei
 * @version 2.0.0
 * @since JDK 1.8
 * @see
 */
@Data
public class TemplateEditRequest implements Serializable {

	@JsonSerialize(using = ToStringSerializer.class )
	private Long id;

	private String name;

	private String title;

	private String comment;

	private List<RegisterTemplateFieldRelEditRequest> datas;

	public List<RegisterTemplateFieldRelEditRequest> getDatas() {
		return datas;
	}

	public void setDatas(List<RegisterTemplateFieldRelEditRequest> datas) {
		this.datas = datas;
	}

}

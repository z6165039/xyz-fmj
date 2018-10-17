/**
 * Project Name:jis-platform-fmj
 * File Name:TemplateResponse.java
 * Package Name:com.jis.platform.fmj.model.response
 * Date:2018年6月12日上午10:54:19
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.jis.platform.fmj.model.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * ClassName:TemplateResponse <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年6月12日 上午10:54:19 <br/>
 * @author   zhangpei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Data
public class TemplateDBQueryResponse {

	@JsonSerialize(using = ToStringSerializer.class)
	private Long eventId;

	private String title;
	private String comment;
	private String name;
	@JsonSerialize(using = ToStringSerializer.class)
	private Long skuId;

	@JsonSerialize(using = ToStringSerializer.class)
	private Long fieldId;

	private Integer  sortNo;
	private Integer  maxLength;
	private String  showName;
	private Long  fieldTypeId;
	private String  fieldArray;

}


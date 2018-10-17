/**
 * Project Name:jis-platform-fmj
 * File Name:FieldCheckResponse.java
 * Package Name:com.jis.platform.fmj.model.response
 * Date:2018年6月15日上午10:18:28
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.jis.platform.fmj.model.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * ClassName:FieldCheckResponse <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年6月15日 上午10:18:28 <br/>
 * @author   zhangpei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Data
public class FieldCheckResponse {

	@JsonSerialize(
			using = ToStringSerializer.class
	)
	private Long id;
	private String name;
	private boolean checkEmpty;
	private String checkName;
	private Integer maxLength;
	private boolean system;

}


/**
 * Project Name:jis-platform-fmj
 * File Name:TemplateResponse.java
 * Package Name:com.jis.platform.fmj.model.response
 * Date:2018年6月12日上午10:54:19
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.jis.platform.fmj.model.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

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
public class TemplateResponse implements Serializable {


	private TemplateBaseInfoResponse templateInfo;

	private List<TemplateFieldsInfoResponse> fields;


}


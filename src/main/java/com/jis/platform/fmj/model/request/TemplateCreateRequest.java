/**
 * Project Name:jis-platform-fmj
 * File Name:TemplateCreate.java
 * Package Name:com.jis.platform.fmj.model.request
 * Date:2018年6月8日上午10:35:19
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.jis.platform.fmj.model.request;

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
 * @version
 * @since JDK 1.8
 * @see
 */
@Data
public class TemplateCreateRequest implements Serializable {

	private String name;

	private String title;

	private String comment;

	private List<RegisterTemplateFieldRelCreateRequest> datas;

}

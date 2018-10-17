/**
 * Project Name:jis-platform-fmj
 * File Name:DataInstace.java
 * Package Name:com.jis.platform.fmj.component
 * Date:2018年6月12日下午5:28:28
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.jis.platform.fmj.component;

import com.jis.platform.fmj.model.entity.EnrolFieldDataRel;

import java.util.List;

/**
 * ClassName:DataInstace <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年6月12日 下午5:28:28 <br/>
 * @author   zhangpei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class DataInstace {

	private DataInstace() {}

	public static final DataInstace INSTACE = new DataInstace();

	private  List<EnrolFieldDataRel> EnrolFieldDataRelData = null;

	public List<EnrolFieldDataRel> getEnrolFieldDataRelData() {
		return EnrolFieldDataRelData;
	}

	public void setEnrolFieldDataRelData(List<EnrolFieldDataRel> enrolFieldDataRelData) {
		EnrolFieldDataRelData = enrolFieldDataRelData;
	}
}


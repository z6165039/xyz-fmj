package com.jis.platform.fmj.mapper;

import com.jis.platform.fmj.model.entity.EnrolTemplate;
import com.jis.platform.fmj.model.response.TemplateDBQueryResponse;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RegisterTemplateMapper extends Mapper<EnrolTemplate>{
	
	List<EnrolTemplate> selectByName(@Param("name")String name, @Param("enterpriseId")Long enterpriseId);

	String selectTemplateInfoBySkuId(@Param("skuId")Long skuId);


	List<TemplateDBQueryResponse>  selectLikeFiled(@Param("enterpriseId")Long enterpriseId, Long id);


	List<String>  selectFieldDataRel(@Param("ids")List<String> ids);

}
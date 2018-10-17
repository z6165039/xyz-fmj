package com.jis.platform.fmj.mapper;

import com.jis.platform.fmj.model.entity.EnrolField;
import com.jis.platform.fmj.model.response.FindListEnrolFieldResponse;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Set;

public interface RegisterFieldMapper extends Mapper<EnrolField>{
    
    List<EnrolField> selectByType(@Param("type") Long type, @Param("enterpriseId") Long enterpriseId);

    List<FindListEnrolFieldResponse> selectByNameAndType(@Param("name") String name, @Param("fieldTypeId") Long fieldTypeId, @Param("enterpriseId") Long enterpriseId);
    
    List<FindListEnrolFieldResponse> selectByIds(@Param("datas") Set<Long> datas);

    void deleteIds(@Param("datas") Set<String> datas);

}
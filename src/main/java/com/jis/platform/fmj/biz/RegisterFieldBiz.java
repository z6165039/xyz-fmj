package com.jis.platform.fmj.biz;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jis.platform.common.biz.BaseBiz;
import com.jis.platform.common.exception.ResponseException;
import com.jis.platform.common.exception.ResponseUtil;
import com.jis.platform.common.msg.TableResultResponse;
import com.jis.platform.common.util.IdWorker;
import com.jis.platform.fmj.component.EnterpriseInstace;
import com.jis.platform.fmj.constant.RegisterResponseStatus;
import com.jis.platform.fmj.mapper.RegisterFieldMapper;
import com.jis.platform.fmj.mapper.RegisterTemplateMapper;
import com.jis.platform.fmj.model.entity.EnrolField;
import com.jis.platform.fmj.model.request.RegisterFieldCreateRequest;
import com.jis.platform.fmj.model.request.RegisterFieldDetailsValueRequest;
import com.jis.platform.fmj.model.request.RegisterFieldEditRequest;
import com.jis.platform.fmj.model.response.FindListEnrolFieldResponse;
import com.jis.platform.fmj.sfexpress.PinyinTool;
import com.jis.platform.fmj.sfexpress.SetUtils;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhangPei
 * @since 2.0.0
 */
@Service
public class RegisterFieldBiz extends BaseBiz<RegisterFieldMapper, EnrolField> {

	@Autowired
	private RegisterFieldMapper registerFieldMapper;

	@Autowired
	private PinyinTool pinyinTool;

	@Autowired
	private RegisterTemplateMapper registerTemplateMapper;

	/**
	 * 新增字段
	 * @param ec
	 * @return
	 */
	public int insert(RegisterFieldCreateRequest ec)  {
		EnrolField ef = new EnrolField();
		BeanUtils.copyProperties(ec, ef);
		Long id = IdWorker.INSTANCE.nextId();
		ef.setId(id);
		ef.setEnterpriseId(EnterpriseInstace.INSTACE.getEnterpriseId());
		String code = getCode(ef.getName()) + id;
		ef.setCode(code);
		return registerFieldMapper.insert(ef);
	}

	/**
	 * 修改字段
	 * @param ec
	 * @return
	 * @throws ResponseException
	 */
	public int update(RegisterFieldEditRequest ec) throws ResponseException{
		EnrolField ef = new EnrolField();
		checkFieldTemplateRel(ec.getId());
		BeanUtils.copyProperties(ec, ef);
		ef.setSystem(false);
		ef.setEnterpriseId(EnterpriseInstace.INSTACE.getEnterpriseId());
		return registerFieldMapper.updateByPrimaryKey(ef);
	}
	
	public List<EnrolField> selectByType(Long type, Long enterpriseId) {
		return registerFieldMapper.selectByType(type,enterpriseId);
	}
	
	/**
	 *  分页获取字段列表
	 * @author zhangpei
	 * @param page
	 * @param limit
	 * @param name
	 * @param fieldTypeId
	 */
	public TableResultResponse<FindListEnrolFieldResponse> selectByNameAndType(int page, int limit, String name, Long fieldTypeId ) {
		Page<Object> result = PageHelper.startPage(page, limit);
		List<FindListEnrolFieldResponse> list = registerFieldMapper.selectByNameAndType(name, fieldTypeId, EnterpriseInstace.INSTACE.getEnterpriseId());
		return new TableResultResponse<>(result.getTotal(), list);
	}

	public void deleteByIds(String ...ids) throws ResponseException{
		registerFieldMapper.deleteIds(SetUtils.array2set(ids));
	}

	public void checkDelete(Long id){
		checkDelete(String.valueOf(id));
	}

	public void checkDelete(String ...ids){
		List<FindListEnrolFieldResponse> list = registerFieldMapper.selectByIds(SetUtils.array2setLong(ids));
		int count = 0;
		for(FindListEnrolFieldResponse resp : list){
			if (resp.getSystem()==null || !resp.getSystem()){
				count++;
			}
		}
		ResponseUtil.check(count == list.size(), RegisterResponseStatus.PARAMETER_ERROR, "系统字段不能删除！");

	}

	/**
	 * 检查字段是否被模板使用
	 * @return
	 */
	public void checkFieldTemplateRel(Long ...ids) throws ResponseException{
//		enrolTemplateMapper.selectLikeFiled();
//		Long size = enrolTemplateFieldRelMapper.selectRelCountByFieldIds(SetUtils.array2set(ids));
//		ResponseUtil.check(size == 0, RegisterResponseStatus.PARAMETER_ERROR, "不能变更，该字段已被模板使用");
	}


	public List<FindListEnrolFieldResponse> selectByIds(List<RegisterFieldDetailsValueRequest> details){
		Set<Long> set = new HashSet<>();
		for(RegisterFieldDetailsValueRequest detail : details) {
			set.add(detail.getFieldId());
		}
		return selectByIds(set);
	}

	/**
	 * selectByIds:(批量id查询字段信息列表).
	 *
	 * @author zhangpei
	 * @param set
	 * @return
	 * @since JDK 1.8
	 */
	public List<FindListEnrolFieldResponse> selectByIds(Set<Long> set){
    	return registerFieldMapper.selectByIds(set);
    }

	/**
	 * 获取code封装
	 * @param name
	 * @return
	 */
	private String getCode(String name){
		try{
			return pinyinTool.toPinYin(name);
		}catch(BadHanyuPinyinOutputFormatCombination e){
			return String.valueOf(name.hashCode());
		}
	}
}
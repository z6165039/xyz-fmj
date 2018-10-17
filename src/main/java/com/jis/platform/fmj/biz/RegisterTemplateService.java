package com.jis.platform.fmj.biz;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jis.platform.common.biz.BaseBiz;
import com.jis.platform.common.msg.TableResultResponse;
import com.jis.platform.common.util.IdWorker;
import com.jis.platform.fmj.component.EnterpriseInstace;
import com.jis.platform.fmj.mapper.RegisterTemplateMapper;
import com.jis.platform.fmj.model.entity.EnrolTemplate;
import com.jis.platform.fmj.model.request.RegisterTemplateFieldRelCreateRequest;
import com.jis.platform.fmj.model.request.TemplateCreateRequest;
import com.jis.platform.fmj.model.request.TemplateEditRequest;
import com.jis.platform.fmj.sfexpress.FormaterUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangPei
 * @version  2.0.0
 */
@Service
public class RegisterTemplateService extends BaseBiz<RegisterTemplateMapper, EnrolTemplate> {

	@Autowired
	private RegisterTemplateMapper registerTemplateMapper;


	/**
	 * 新增模板
	 * @param tcr
	 * @return
	 */
	public int insertTemplate(TemplateCreateRequest tcr) {
		EnrolTemplate et = new EnrolTemplate();
		BeanUtils.copyProperties(tcr, et);
		Long templateId = IdWorker.INSTANCE.nextId();
		et.setId(templateId);
		et.setEnterpriseId(EnterpriseInstace.INSTACE.getEnterpriseId());
		JSONArray jsonObj = (JSONArray) JSON.toJSON(tcr.getDatas());
		et.setTemplate(jsonObj.toJSONString());
		return registerTemplateMapper.insert(et);
	}

	/**
	 * 修改模板
	 * @param editRequest
	 * @return
	 */
	public int updateTemplate(TemplateEditRequest editRequest) {
		EnrolTemplate et = new EnrolTemplate();
		BeanUtils.copyProperties(editRequest, et);
		JSONArray jsonObj = (JSONArray) JSON.toJSON(editRequest.getDatas());
		et.setTemplate(jsonObj.toJSONString());
		et.setEnterpriseId(EnterpriseInstace.INSTACE.getEnterpriseId());
		return  registerTemplateMapper.updateByPrimaryKey(et);
	}

	/**
	 * 模板搜索
	 * @param page
	 * @param limit
	 * @param name
	 * @return
	 */
	public TableResultResponse<EnrolTemplate> selectByName(int page, int limit, String name) {
		Page<Object> result = PageHelper.startPage(page, limit);
		List<EnrolTemplate> list = registerTemplateMapper.selectByName(name, EnterpriseInstace.INSTACE.getEnterpriseId());
		return new TableResultResponse<>(result.getTotal(), list);
	}
	
	/**
	 * 
	 * getTemplateInfo:(获取模板字段信息)
	 *
	 * @author zhangpei
	 * @param skuId
	 * @since JDK 1.8
	 */
	public List<RegisterTemplateFieldRelCreateRequest> getTemplateInfo(Long skuId) {
		String template = registerTemplateMapper.selectTemplateInfoBySkuId(skuId);
		if(StringUtils.isBlank(template)){
			return null;
		}
		return FormaterUtils.getTemplateObject(template);
	}
}
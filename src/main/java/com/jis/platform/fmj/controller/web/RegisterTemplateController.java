package com.jis.platform.fmj.controller.web;

import com.jis.platform.common.exception.ResponseException;
import com.jis.platform.common.exception.ResponseUtil;
import com.jis.platform.common.msg.ObjectRestResponse;
import com.jis.platform.common.msg.TableResultResponse;
import com.jis.platform.fmj.biz.RegisterTemplateService;
import com.jis.platform.fmj.component.EnterpriseInstace;
import com.jis.platform.fmj.constant.RegisterResponseStatus;
import com.jis.platform.fmj.model.entity.EnrolTemplate;
import com.jis.platform.fmj.model.entity.ProductNormalSku;
import com.jis.platform.fmj.model.request.RegisterTemplateFieldRelCreateRequest;
import com.jis.platform.fmj.model.request.RegisterTemplateFieldRelEditRequest;
import com.jis.platform.fmj.model.request.TemplateCreateRequest;
import com.jis.platform.fmj.model.request.TemplateEditRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 报名表单管理
 *
 * @author zhangPei
 * @create 2018-06-04 14:41
 */
@Controller
@RequestMapping("web/enrol/template/")
@Api(description = "报名表单管理", tags = { "template" })
public class RegisterTemplateController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterTemplateController.class);

	@Autowired
	private RegisterTemplateService enrolTemplateService;


	/**
	 * 根据ID获取基本信息和模板下所有字段信息
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "根据ID获取基本信息和模板下所有字段信息", httpMethod = "GET", response = ObjectRestResponse.class)
	public ObjectRestResponse<EnrolTemplate> get(@PathVariable Long id) {
		ObjectRestResponse<EnrolTemplate> res = new ObjectRestResponse<>();
		try {
			EnrolTemplate enrolTemplate = enrolTemplateService.selectById(id);
			res.setCode(HttpStatus.OK.value());
			res.setData(enrolTemplate);
		} catch (ResponseException re) {
			res.setCode(re.getResponseExceptionDetail().getCode());
			res.setMessage(re.getResponseExceptionDetail().getReason());
		}
		return res;
	}

	/**
	 * 获取所有模板信息基本信息
	 * @return ObjectRestResponse<List<EnrolTemplate>>
	 */
	@ResponseBody
	@RequestMapping(value = "all", method = RequestMethod.GET)
	@ApiOperation(value = "获取所有模板信息基本信息", httpMethod = "GET", response = ObjectRestResponse.class)
	public ObjectRestResponse<List<EnrolTemplate>> all() {
		ObjectRestResponse<List<EnrolTemplate>> res = new ObjectRestResponse<>();
		try {
			EnrolTemplate enrolTemplate = new EnrolTemplate();
			enrolTemplate.setEnterpriseId(EnterpriseInstace.INSTACE.getEnterpriseId());
			List<EnrolTemplate> list = enrolTemplateService.selectList(enrolTemplate);
			res.setCode(HttpStatus.OK.value());
			res.setData(list);
		} catch (ResponseException re) {
			res.setCode(re.getResponseExceptionDetail().getCode());
			res.setMessage(re.getResponseExceptionDetail().getReason());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			res.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			res.setMessage(e.getMessage());
		}
		return res;
	}

	/**
	 * 创建模板
	 * @param templateCreateRequest
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "create", method = RequestMethod.PUT)
	@ApiOperation(value = "创建模板", httpMethod = "PUT", response = ObjectRestResponse.class)
	public ObjectRestResponse<Integer> create(@RequestBody TemplateCreateRequest templateCreateRequest) {
		ObjectRestResponse<Integer> res = new ObjectRestResponse<Integer>();
		try {
			insertParmaterCheck(templateCreateRequest);
			int insertResult = enrolTemplateService.insertTemplate(templateCreateRequest);
			ResponseUtil.check(insertResult > 0, RegisterResponseStatus.GETTING_DATA_EXCEPTION);
			res.setCode(HttpStatus.OK.value());
			res.setData(0);
		} catch (ResponseException re) {
			res.setCode(re.getResponseExceptionDetail().getCode());
			res.setMessage(re.getResponseExceptionDetail().getReason());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            res.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            res.setMessage("不允许创建不存在的字段!");
        }
		return res;
	}


	/**
	 * 修改表单模板
	 * @param templateEditRequest
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@ApiOperation(value = "修改表单模板", httpMethod = "POST", response = ObjectRestResponse.class)
	public ObjectRestResponse<Integer> edit(@RequestBody TemplateEditRequest templateEditRequest) {
		ObjectRestResponse<Integer> res = new ObjectRestResponse<Integer>();
		try {
			editParmaterCheck(templateEditRequest);
			int insertResult = enrolTemplateService.updateTemplate(templateEditRequest);
			ResponseUtil.check(insertResult > 0, RegisterResponseStatus.MODIFY_EXCEPTION);
			res.setCode(HttpStatus.OK.value());
			res.setData(0);
		} catch (ResponseException re) {
			res.setCode(re.getResponseExceptionDetail().getCode());
			res.setMessage(re.getResponseExceptionDetail().getReason());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            res.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            res.setMessage("不允许创建不存在的字段!");
        }
		return res;
	}

	/**
	 * 查找字段列表分页
	 * @param limit
	 * @param page
	 * @param name
	 * @return
	 */
    @ResponseBody
    @RequestMapping(value = "findList", method = RequestMethod.GET )
    @ApiOperation(value = "查找字段列表分页", httpMethod = "GET", response = TableResultResponse.class)
    public TableResultResponse<EnrolTemplate> find(
    		@RequestParam(defaultValue = "10") int limit,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(name="name",required=false) String name) {
    	TableResultResponse<EnrolTemplate> result = new TableResultResponse<>();
    	try {
    		return	enrolTemplateService.selectByName(page, limit, name);
    	} catch (ResponseException re) {
    		result.setCode(re.getResponseExceptionDetail().getCode());
    		result.setMessage(re.getResponseExceptionDetail().getReason());
        } catch (Exception e) {
			logger.error(e.getMessage(), e);
            result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            result.setMessage("查询异常!");
        }
    	return result;
    }


	/**
	 * 修改模板时参数检查
	 * @author zhangpei
	 * @param ter
	 * @throws ResponseException
	 * @since JDK 1.8
	 */
	private void editParmaterCheck(TemplateEditRequest ter) throws ResponseException {
		ResponseUtil.check(ter!=null, RegisterResponseStatus.PARAMETER_ERROR, "参数为空");
		ResponseUtil.check(ter.getId()!=null && ter.getId() != 0, RegisterResponseStatus.PARAMETER_ERROR, "模板ID为空");
		TemplateCreateRequest req = new TemplateCreateRequest();
		BeanUtils.copyProperties(ter, req);
		insertParmaterCheck(req);
		checkTempateProductRel(ter.getId());
	}

	/**
	 * 检查表单是否被商品绑定，绑定则无法修改！
	 * @param id
	 * @throws ResponseException
	 */
	private void checkTempateProductRel(Long id)throws ResponseException {
		ProductNormalSku productNormalSku = new ProductNormalSku();
		productNormalSku.setEnterpriseId(EnterpriseInstace.INSTACE.getEnterpriseId());
		productNormalSku.setTemplateId(id);

	}

	/**
	 * 新增模板时参数检查
	 * @author zhangpei
	 * @param tcr
	 * @throws ResponseException
	 * @since JDK 1.8
	 */
	private void insertParmaterCheck(TemplateCreateRequest tcr) throws ResponseException {
		ResponseUtil.check(tcr != null, RegisterResponseStatus.PARAMETER_ERROR, "参数为空");
		ResponseUtil.check(StringUtils.isNotEmpty(tcr.getTitle()), RegisterResponseStatus.PARAMETER_ERROR, "标题不能为空");
		ResponseUtil.check(tcr.getTitle().length() < 20, RegisterResponseStatus.PARAMETER_ERROR, "标题长度不能超过20位");
		ResponseUtil.check(StringUtils.isNotEmpty(tcr.getName()), RegisterResponseStatus.PARAMETER_ERROR, "名称不能为空");
		ResponseUtil.check(tcr.getName().length() < 20, RegisterResponseStatus.PARAMETER_ERROR, "名称长度不能超过20位");
		List<RegisterTemplateFieldRelCreateRequest> list = tcr.getDatas();
		fieldCheck(list);
	}

	/**
	 * 模板中检查是否存在相同的字段
	 * @author zhangpei
	 * @param list
	 * @throws ResponseException
	 * @since JDK 1.8
	 */
	private void fieldCheck(List<?> list) throws ResponseException {
		ResponseUtil.check(list != null && 0!=list.size(), RegisterResponseStatus.PARAMETER_ERROR, "字段信息不能为空");
		//检查是否存在相同的字段
		Set<Long> set = new HashSet<>();
		for(Object obj : list) {
			if(obj instanceof RegisterTemplateFieldRelCreateRequest){
				RegisterTemplateFieldRelCreateRequest rel =  (RegisterTemplateFieldRelCreateRequest)obj;
				set.add(rel.getFieldId());
			}
			if(obj instanceof RegisterTemplateFieldRelEditRequest){
				RegisterTemplateFieldRelCreateRequest rel =  (RegisterTemplateFieldRelCreateRequest)obj;
				set.add(rel.getFieldId());
			}
		}
		ResponseUtil.check(set.size()==list.size(), RegisterResponseStatus.PARAMETER_ERROR, "字段信息不允许重复存在");
	}




}

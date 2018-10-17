package com.jis.platform.fmj.controller.web;

import com.jis.platform.common.exception.ResponseException;
import com.jis.platform.common.exception.ResponseUtil;
import com.jis.platform.common.msg.ObjectRestResponse;
import com.jis.platform.common.msg.TableResultResponse;
import com.jis.platform.fmj.biz.RegisterFieldBiz;
import com.jis.platform.fmj.constant.RegisterResponseStatus;
import com.jis.platform.fmj.model.entity.EnrolField;
import com.jis.platform.fmj.model.request.RegisterFieldCreateRequest;
import com.jis.platform.fmj.model.request.RegisterFieldEditRequest;
import com.jis.platform.fmj.model.response.FindListEnrolFieldResponse;
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

/**
 * 字段管理
 *
 * @author zhangPei
 * @create 2018-06-04 14:41
 */
@Controller
@RequestMapping("web/enrol/field/")
@Api(description = "字段管理", tags = { "field" })
@Log4j
public class RegisterFieldController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterFieldController.class);

	@Autowired
	private RegisterFieldBiz enrolFieldService;

	/**
	 * 根据字段ID，查询明细
	 * @author zhangpei
	 * @param id
	 * @return
	 * @since JDK 1.8
	 */
	@ResponseBody
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "根据字段ID，查询明细", httpMethod = "GET", response = ObjectRestResponse.class)
	public ObjectRestResponse<EnrolField> get(@PathVariable Long id) {
		ObjectRestResponse<EnrolField> res = new ObjectRestResponse<EnrolField>();
		try {
			getParmaterCheck(id);
			EnrolField enrolField = enrolFieldService.selectById(id);
			ResponseUtil.check(enrolField != null, RegisterResponseStatus.GETTING_DATA_EXCEPTION);
			res.setCode(HttpStatus.OK.value());
			res.setData(enrolField);
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
	 * 创建字段
     * @author zhangpei
     * @param ec
     * @return
     * @since JDK 1.8
     */
    @ResponseBody
    @RequestMapping(value = "create", method = RequestMethod.PUT )
    @ApiOperation(value = "创建字段", httpMethod = "PUT", response = ObjectRestResponse.class)
    public ObjectRestResponse<Integer> create(@RequestBody RegisterFieldCreateRequest ec) {
    	ObjectRestResponse<Integer> res = new ObjectRestResponse<Integer>();
    	try {
    		insertParmaterCheck(ec);
    		int insertResult = enrolFieldService.insert(ec);
    		ResponseUtil.check(insertResult > 0, RegisterResponseStatus.GETTING_DATA_EXCEPTION);
    		res.setCode(HttpStatus.OK.value());
    		res.setData(insertResult);
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
     * 修改字段
     * @author zhangpei
     * @param ef
     * @return
     * @since JDK 1.8
     */
    @ResponseBody
    @RequestMapping(value = "edit", method = RequestMethod.POST )
    @ApiOperation(value = "修改字段", httpMethod = "POST", response = ObjectRestResponse.class)
    public ObjectRestResponse<Integer> edit(@RequestBody RegisterFieldEditRequest ef) {
    	ObjectRestResponse<Integer> res = new ObjectRestResponse<Integer>();
    	try {
    		editParmaterCheck(ef);
    		int insertResult = enrolFieldService.update(ef);
    		ResponseUtil.check(insertResult > 0, RegisterResponseStatus.GETTING_DATA_EXCEPTION);
    		res.setCode(HttpStatus.OK.value());
    		res.setData(insertResult);
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
	 * 删除字段
	 * @author zhangpei
	 * @param id
	 * @return
	 * @since JDK 1.8
	 */
	@ResponseBody
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE )
	@ApiOperation(value = "删除字段", httpMethod = "DELETE", response = ObjectRestResponse.class)
	public ObjectRestResponse<Integer> delete(@PathVariable Long id) {
		ObjectRestResponse<Integer> res = new ObjectRestResponse<Integer>();
		try {
			deleteParmaterCheck(id);
			enrolFieldService.checkDelete(id);
			int insertResult = enrolFieldService.deleteById(id);
			ResponseUtil.check(insertResult > 0, RegisterResponseStatus.GETTING_DATA_EXCEPTION);
			res.setCode(HttpStatus.OK.value());
			res.setData(insertResult);
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
	 * 删除字段(批量)
	 * @author zhangpei
	 * @param ids
	 * @return
	 * @since JDK 1.8
	 */
	@ResponseBody
	@RequestMapping(value = "deleteBatch/{ids}", method = RequestMethod.DELETE )
	@ApiOperation(value = "删除字段(批量)", httpMethod = "DELETE", response = ObjectRestResponse.class)
	public ObjectRestResponse<Integer> deleteBatch(@PathVariable("ids") String ids) {
		ObjectRestResponse<Integer> res = new ObjectRestResponse<Integer>();
		try {
			String idsArr[] = ids.split(",");
			enrolFieldService.checkDelete(idsArr);
			enrolFieldService.deleteByIds(idsArr);
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
	 * 查找字段列表分页
     * @author zhangpei
     * @param limit
     * @param page
     * @param name
     * @param fieldTypeId
     * @return
     * @since JDK 1.8
     */
    @ResponseBody
    @RequestMapping(value = "findList", method = RequestMethod.GET )
    @ApiOperation(value = "查找字段列表分页", httpMethod = "GET", response = TableResultResponse.class)
    public TableResultResponse<FindListEnrolFieldResponse> find(
    		@RequestParam(defaultValue = "10") int limit,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(name="name",required=false) String name, 
    		@RequestParam(name="fieldTypeId",required=false) Long fieldTypeId) {
    	TableResultResponse<FindListEnrolFieldResponse> result = new TableResultResponse<>();
    	try {
			result = enrolFieldService.selectByNameAndType(page, limit, name, fieldTypeId);
    	} catch (ResponseException re) {
    		result.setCode(re.getResponseExceptionDetail().getCode());
    		result.setMessage(re.getResponseExceptionDetail().getReason());
        } catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			result.setMessage(e.getMessage());
		}
    	return result;
    }


    /**
	 * 插入参数检查
     * @author zhangpei
     * @param ec
     * @throws ResponseException
     * @since JDK 1.8
     */
    private void insertParmaterCheck(RegisterFieldCreateRequest ec)  throws ResponseException{
		parmaterCheck(ec);
    }

	/**
	 * 通用字段参数检查
	 * @param ec
	 * @throws ResponseException
	 */
	private void parmaterCheck(RegisterFieldCreateRequest ec)  throws ResponseException{
		ResponseUtil.check(ec != null , RegisterResponseStatus.PARAMETER_ERROR, "参数为空！");
		ResponseUtil.check(StringUtils.isNotEmpty(ec.getName()) , RegisterResponseStatus.PARAMETER_ERROR, "名称不能为空！");
		ResponseUtil.check(ec.getName().length()<10 , RegisterResponseStatus.PARAMETER_ERROR, "名称不能超过10个位！");
		ResponseUtil.check(ec.getFieldTypeId()!=null && ec.getFieldTypeId()!=0, RegisterResponseStatus.PARAMETER_ERROR, "字段类型不能为空！");
		if(StringUtils.isNotEmpty(ec.getFieldArray())){
			String arr[] = ec.getFieldArray().split(",");
			String str = "";
			for(String s : arr){
//				ResponseUtil.check(StringUtils.isNotEmpty(s) , RegisterResponseStatus.PARAMETER_ERROR, "字段参数不能有空值！");
				ResponseUtil.check(s.length()<10 , RegisterResponseStatus.PARAMETER_ERROR, "字段参数不能超过10位！");
			    if(StringUtils.isNotEmpty(s)){
                    str+= s+",";
                }
			}
            ec.setFieldArray(str.substring(0,str.length()-1));
		}
		if(StringUtils.isNotEmpty(ec.getComment())){
			ResponseUtil.check(ec.getComment().length()<50 , RegisterResponseStatus.PARAMETER_ERROR, "说明不能超过50位！");
		}
	}

	/**
	 * 修改字段参数检查
	 * @param ef
	 * @throws ResponseException
	 */
	private void editParmaterCheck(RegisterFieldEditRequest ef)  throws ResponseException{
		ResponseUtil.check(ef != null , RegisterResponseStatus.PARAMETER_ERROR, "参数为空！");
		ResponseUtil.check(ef.getId() != null && ef.getId() != 0, RegisterResponseStatus.PARAMETER_ERROR, "ID为空！");
		RegisterFieldCreateRequest request = new RegisterFieldCreateRequest();
		BeanUtils.copyProperties(ef, request);
		parmaterCheck(request);
		ResponseUtil.check(!checkSystemField(ef.getId()), RegisterResponseStatus.PARAMETER_ERROR, "系统字段不允许修改！");
	}

	/**
	 * 检查是否为系统字段
	 * @param id
	 * @return
	 */
	private boolean checkSystemField(Long id){
		EnrolField enrolField = enrolFieldService.selectById(id);
		return enrolField.getSystem() == null ? false : enrolField.getSystem();
	}

	/**
	 * 删除字段参数检查
	 * @param id
	 * @throws ResponseException
	 */
	private void deleteParmaterCheck(Long id)throws ResponseException{
		ResponseUtil.check(id != null && id != 0L , RegisterResponseStatus.PARAMETER_ERROR, "参数为空！");
    }

	/**
	 * 查询字段参数检查
	 * @param id
	 * @throws ResponseException
	 */
	private void getParmaterCheck(Long id)throws ResponseException{
		ResponseUtil.check(id != null && id != 0L , RegisterResponseStatus.PARAMETER_ERROR, "参数为空！");
	}
    
}

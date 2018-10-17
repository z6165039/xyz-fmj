package com.jis.platform.fmj.controller.web;

import com.jis.platform.common.exception.ResponseException;
import com.jis.platform.common.msg.ObjectRestResponse;
import com.jis.platform.fmj.biz.RegisterFieldTypeService;
import com.jis.platform.fmj.model.entity.EnrolFieldType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 字段类型管理
 *
 * @author zhangPei
 * @create 2018-06-04 14:41
 */
@Controller
@RequestMapping("web/enrol/fieldType/")
@Api(description = "字段类型管理", tags = { "fieldType" })
@Log4j
public class RegisterFieldTypeController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterFieldTypeController.class);

	@Autowired
	private RegisterFieldTypeService enrolFieldTypeService;

	/**
	 * 查询所有字段类型
	 * @return  ObjectRestResponse<List<EnrolFieldType>>
	 */
	@ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET )
    @ApiOperation(value = "所有字段类型列表", httpMethod = "GET", response = EnrolFieldType.class)
    public ObjectRestResponse<List<EnrolFieldType>> all() {
    	ObjectRestResponse<List<EnrolFieldType>> res = new ObjectRestResponse<List<EnrolFieldType>>();
    	try {
    		EnrolFieldType entity = new EnrolFieldType();
    		entity.setIsDelete(false);
    		List<EnrolFieldType> list = enrolFieldTypeService.selectList(entity);
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
}

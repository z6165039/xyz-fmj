package com.jis.platform.fmj.exception;

import com.jis.platform.common.exception.auth.TokenErrorException;
import com.jis.platform.common.handler.GlobalExceptionHandler;
import com.jis.platform.common.msg.ObjectRestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author YJ
 */
@ControllerAdvice({"com.jis.platform"})
@ResponseBody
public class CommonExceptionHandler extends GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);


//    @ExceptionHandler({JwtIllegalArgumentException.class,
//            JwtSignatureException.class,
//            JwtTokenExpiredException.class})
//    public BaseResponse authExceptionHandler(HttpServletResponse response, Exception ex) {
//        this.logger.error(ex.getMessage(), ex);
//        response.setStatus(HttpStatus.UNAUTHORIZED.value());
//        return new BaseResponse(HttpStatus.UNAUTHORIZED.value(), ex.getMessage());
//    }

    /**
     * 401 - 用户超时
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({TokenErrorException.class})
    public ObjectRestResponse<Integer> handleTokenErrorException(TokenErrorException e) {
        ObjectRestResponse<Integer> res = new ObjectRestResponse<Integer>();
        res.setMessage(e.getMessage());
        res.setCode(401);
        return res;
    }

    /**
     * 403 - 用户没权限
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(ForbiddenException.class)
    public ObjectRestResponse<Integer> handleForbiddenException(ForbiddenException e) {
        ObjectRestResponse<Integer> res = new ObjectRestResponse<Integer>();
        res.setMessage(e.getMessage());
        res.setCode(403);
        return res;
    }


}

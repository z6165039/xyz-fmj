package com.jis.platform.fmj.exception;

import com.jis.platform.common.constant.CommonConstants;
import com.jis.platform.common.exception.BaseException;

public class ForbiddenException extends BaseException{
    public ForbiddenException(String message, int status)
    {
        super(message, CommonConstants.EX_CLIENT_INVALID_CODE);
    }

}

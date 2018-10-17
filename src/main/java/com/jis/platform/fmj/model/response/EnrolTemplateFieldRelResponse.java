package com.jis.platform.fmj.model.response;

import com.jis.platform.fmj.model.request.RegisterTemplateFieldRelCreateRequest;
import lombok.Data;

@Data
public class EnrolTemplateFieldRelResponse extends RegisterTemplateFieldRelCreateRequest {

    private String filedValue;
}

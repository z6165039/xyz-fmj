package com.jis.platform.fmj.config.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CommonSessionInterceptor extends HandlerInterceptorAdapter {

    public static final String CONTEXT_KEY_USER_NAME = "currentUser";
//    @Autowired
//    private EmployeeApi employeeApi;
//
//    @Autowired
//    private MemberApi memberApi;
//
//
//    public Long getEnterpriseId(Long userId){
//        ObjectRestResponse<EmployeeDto> result = employeeApi.getEmployee(userId);
//        if(result == null){
//            return 0L;
//        }
//        EmployeeDto dto = result.getData();
//        if(dto == null){
//            return 0L;
//        }
//        EnterpriseInstace.INSTACE.setEnterpriseId(dto.getEnterpriseId(),userId);
//        return dto.getEnterpriseId();
//    }
//
//    public Long getMemberEnterpriseId(Long memberId){
//        ObjectRestResponse<MemberDto>  result = memberApi.get(memberId);
//        if(result == null){
//            return 0L;
//        }
//        MemberDto dto = result.getData();
//        if(dto == null){
//            return 0L;
//        }
//        EnterpriseInstace.INSTACE.setEnterpriseId(dto.getEnterpriseId(),memberId);
//        return dto.getEnterpriseId();
//    }
}

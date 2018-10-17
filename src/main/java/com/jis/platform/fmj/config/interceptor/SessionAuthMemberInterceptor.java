package com.jis.platform.fmj.config.interceptor;

import com.jis.platform.common.context.BaseContextHandler;
import com.jis.platform.fmj.model.common.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by ace on 2017/9/10.
 */
public class SessionAuthMemberInterceptor extends CommonSessionInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        Object obj = session.getAttribute(CONTEXT_KEY_USER_NAME);

        if(null != obj){
            UserInfo userInfo = (UserInfo) obj;
            BaseContextHandler.setUsername(userInfo.getUsername());
            BaseContextHandler.setUserID(userInfo.getId());
//            Long enterpriseId = EnterpriseInstace.INSTACE.getEnterpriseId(Long.valueOf(userInfo.getId()));
//            if(enterpriseId == null){
//                enterpriseId = getMemberEnterpriseId(Long.valueOf(userInfo.getId()));
//            }
//            BaseContextHandler.set(Constant.ENTERPRISE_ID,enterpriseId);
        }
        return super.preHandle(request, response, handler);
    }
}

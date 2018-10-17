package com.jis.platform.fmj.config.interceptor;

import com.jis.platform.common.context.BaseContextHandler;
import com.jis.platform.common.exception.auth.UserInvalidException;
import com.jis.platform.fmj.model.common.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by ace on 2017/9/10.
 */
public class SessionAuthRestInterceptor extends CommonSessionInterceptor  {
    private Logger logger = LoggerFactory.getLogger(SessionAuthRestInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object obj = session.getAttribute(CONTEXT_KEY_USER_NAME);
        if (null == obj) {
            logger.error("######### 无效的session ID ########## " + session.getId());
    		throw new UserInvalidException("invalid user");
        }
        
        if(null != obj){
        	 UserInfo userInfo = (UserInfo) obj;
             BaseContextHandler.setUsername(userInfo.getUsername());
             BaseContextHandler.setName(userInfo.getName());
             BaseContextHandler.setUserID(userInfo.getId());
             BaseContextHandler.setAvatar(userInfo.getAvatar());
//             Long enterpriseId = EnterpriseInstace.INSTACE.getEnterpriseId(Long.valueOf(userInfo.getId()));
//             if(enterpriseId == null){
//                 enterpriseId = getEnterpriseId(Long.valueOf(userInfo.getId()));
//             }
//             BaseContextHandler.set(Constant.ENTERPRISE_ID,enterpriseId);
        }

        return super.preHandle(request, response, handler);
    }



    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        BaseContextHandler.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}

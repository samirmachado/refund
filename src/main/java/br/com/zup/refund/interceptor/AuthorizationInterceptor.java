package br.com.zup.refund.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.zup.refund.model.exception.InvalidTokenException;
import br.com.zup.refund.session.Session;

@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private Session session;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        if(isPublicRoute(request.getRequestURI())){
            return true;
        }
        
        String token = request.getHeader("token");
        
        if(StringUtils.isNoneBlank(token)) {
            if(session.checkAuthorization(token)) {
                response.setHeader("token", token);
                return true;
            }
        }
       
        throw new InvalidTokenException();
    }

    private boolean isPublicRoute(String route) {
        if(
           route.equals("/login")) return true;
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
            Object object, ModelAndView model) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object object, Exception arg3) throws Exception {
    }
}

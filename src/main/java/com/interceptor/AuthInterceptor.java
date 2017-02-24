package com.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import java.util.Map;


public class AuthInterceptor implements Interceptor {
    @Override
    public void destroy() {
        System.out.println("后台安全验证销毁");
    }

    @Override
    public void init() {
        System.out.println("后台安全验证");
    }

    @Override
    public String intercept(ActionInvocation a) throws Exception {
        Map<String,Object> session = a.getInvocationContext().getSession();
        String result = Action.LOGIN;
        if(session.get("admin")!=null){
            result = a.invoke();
        }
        return result;
    }
}

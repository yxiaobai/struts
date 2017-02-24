package com.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by 易小白 on 2017/2/24.
 */
public class MyTimer extends AbstractInterceptor {
    @Override
    public void init() {
        System.out.println("初始化构造器");
    }
    @Override
    public void destroy() {
        System.out.println("构造器销毁");
    }
    @Override
    public String intercept(ActionInvocation a) throws Exception {
        System.out.println("拦截器开始");
        String result = a.invoke();
        System.out.println("拦截器结束");
        return result;
    }
}

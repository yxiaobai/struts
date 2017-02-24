# struts
struts 拦截器 及自定义拦截 和 权限验证拦截

struts2-core-2.5.10.jar 文件根中有struts-default.xml 文件
默认配置文件

	<package name="struts-default" abstract="true" strict-method-invocation="true">
		<default-interceptor-ref name="defaultStack"/>
		<default-class-ref class="com.opensymphony.xwork2.ActionSupport" />
		<global-allowed-methods>execute,input,back,cancel,browse,save,delete,list,index</global-allowed-methods>
	</package>

	包名为 name="struts-default"

	默认拦截栈
	    
	    <interceptor-stack name="defaultStack">
                <interceptor-ref name="exception"/>
                <interceptor-ref name="alias"/>
                <interceptor-ref name="servletConfig"/>
                <interceptor-ref name="i18n"/>
                <interceptor-ref name="prepare"/>
                <interceptor-ref name="chain"/>
                <interceptor-ref name="scopedModelDriven"/>
                <interceptor-ref name="modelDriven"/>
                <interceptor-ref name="fileUpload"/>
                <interceptor-ref name="checkbox"/>
                <interceptor-ref name="datetime"/>
                <interceptor-ref name="multiselect"/>
                <interceptor-ref name="staticParams"/>
                <interceptor-ref name="actionMappingParams"/>
                <interceptor-ref name="params"/>
                <interceptor-ref name="conversionError"/>
                <interceptor-ref name="validation">
                    <param name="excludeMethods">input,back,cancel,browse</param>
                </interceptor-ref>
                <interceptor-ref name="workflow">
                    <param name="excludeMethods">input,back,cancel,browse</param>
                </interceptor-ref>
                <interceptor-ref name="debugging"/>
            </interceptor-stack>



不继承struts-default包自己配置拦截器
   <package name="my" namespace="/">
        <interceptors>
	    <!-- setter 封闭表单值 -->
            <interceptor name="aa" class="com.opensymphony.xwork2.interceptor.ParametersInterceptor"/>
	    <!-- 显示action的执行时间 -->
            <interceptor name="timer" class="com.opensymphony.xwork2.interceptor.TimerInterceptor"/>
            <interceptor-stack name="myi">
                <interceptor-ref name="aa"/>
                <interceptor-ref name="timer"/>
            </interceptor-stack>
        </interceptors>
        <action name="mys" class="com.action.UserAction" method="show">
            <interceptor-ref name="myi"/>
        </action>
    </package>


自己编写拦截器  编写类，继承com.opensymphony.xwork2.interceptor.AbstractInterceptor
package com.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by webrx on 2017/2/24 0024 9:24.
 */
public class MyTimer extends AbstractInterceptor {
    @Override
    public void init() {
        System.out.println("MyTimer-初始化");
    }

    @Override
    public void destroy() {
        System.out.println("MyTimer-销毁资源");
    }

    @Override
    public String intercept(ActionInvocation a) throws Exception {
        System.out.println("----拦截器开始-----");
        String result = a.invoke();
        System.out.println("----拦截器结束-----");
        return result;
    }
}


struts.xml 配置包拦截器
    <package name="my" namespace="/">
        <interceptors>
            <interceptor name="aa" class="com.opensymphony.xwork2.interceptor.ParametersInterceptor"/>
            <interceptor name="timer" class="com.opensymphony.xwork2.interceptor.TimerInterceptor"/>
            <interceptor-stack name="myi">
                <interceptor-ref name="aa"/>
                <interceptor-ref name="timer"/>
            </interceptor-stack>
            <interceptor name="myt" class="com.interceptor.MyTimer"/>

            <interceptor-stack name="ttt">
                <interceptor-ref name="timer"/>
                <interceptor-ref name="myt"/>
                <interceptor-ref name="aa"/>
            </interceptor-stack>
        </interceptors>
        <action name="mys" class="com.action.UserAction" method="show">
            <interceptor-ref name="myi"/>
        </action>

        <action name="yy" class="com.action.UserAction" method="yy">
            <!-- 引用的拦截器栈 中有timer 系统拦截器 myt自定义的拦截器-->
            <!--<interceptor-ref name="ttt"/>-->
            <interceptor-ref name="timer"/>
            <interceptor-ref name="myt"/>
            <interceptor-ref name="aa"/>
        </action>
    </package>



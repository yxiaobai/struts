package com.action;

import lombok.Data;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

/**
 * Created by 易小白 on 2017/2/20.
 */
@Data
public class LoginAction {
    private String account;
    private String password;
    public String execute(){
        if ("admin".equalsIgnoreCase(account)&&"123".equalsIgnoreCase(password)){
            HttpSession session = ServletActionContext.getRequest().getSession();
            session.setAttribute("user","admin");
            return "success";  //进入登录成功的视图 fail是视图名

        }else {
            if(account==null || "".equals(account)){
                ServletActionContext.getContext().put("msg","账号必须填写");
            }else if(password==null || "".equals(password)){
                ServletActionContext.getContext().put("msg","密码必须填写");
            }else{
                ServletActionContext.getContext().put("msg","账号和密码不正确");
            }
            return "fail";//进入登录失败的视图 fail是视图名
        }
    }
}

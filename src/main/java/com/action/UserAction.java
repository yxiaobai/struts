package com.action;

import com.opensymphony.xwork2.ActionSupport;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 易小白 on 2017/2/24.
 */
@Log4j2
@Data
public class UserAction extends ActionSupport {
    private String name;
    public void show() throws IOException {
        HttpServletResponse resp = ServletActionContext.getResponse();
        HttpServletRequest req = ServletActionContext.getRequest();
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print("struts --  中文");
        out.print(req.getParameter("name"));
        out.flush();
        out.close();
        log.info("name="+name);
    }
    public void yyy() throws IOException {
        HttpServletResponse resp = ServletActionContext.getResponse();
        HttpServletRequest req = ServletActionContext.getRequest();
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print("自定义拦截器");
        out.print(req.getParameter("name"));
        out.flush();
        out.close();
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(name);
    }
}

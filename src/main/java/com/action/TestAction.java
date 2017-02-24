package com.action;

import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 易小白 on 2017/2/20.
 */
public class TestAction {
    public void execute() throws IOException {
        HttpServletResponse res = ServletActionContext.getResponse();
        res.setCharacterEncoding("utf-8");
        res.setContentType("text/html;charset=utf-8");
        PrintWriter out = res.getWriter();
        out.print("<h1>Struts2.5.10 入门案例</h1>");
        out.flush();
        out.close();

        System.out.println("控制板输出");
    }
}

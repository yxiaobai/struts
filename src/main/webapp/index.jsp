<%@ page pageEncoding="utf-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>struts 入门</title>
</head>
<body>
<%--<a href="hello">hello</a><br>
<a href="test.action">test.action</a><br>
<a href="test">test</a><br>
<a href="test.do">test.do</a><br>
<hr>
<br><br>
<form action="login.action" method="post">
    账户：<input type="text" name="account"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit" value="提交">
</form>

<br><br>
<hr>
<h1>测试</h1>
<s:iterator begin="1" end="10" step="1" var="i">
    <s:property/><br>
</s:iterator>--%>

<a href="show.action?name=jack">show</a><br>
<a href="mys.action?name=jack">mys</a><br>
<a href="yy.action?name=jack">自定义拦截器</a><br>


</body>
</html>

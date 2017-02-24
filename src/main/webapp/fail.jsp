<%@ page pageEncoding="utf-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登陆失败</title>
    <meta http-equiv="refresh" content="15;url=index.jsp" >
</head>
<body>
<h5>登陆失败,5秒后自动跳转页面</h5>
<p>${msg}----${requestScope.msg}</p>
<h5><a href="index.jsp">若跳转失败,请点击....</a></h5>
</body>
</html>

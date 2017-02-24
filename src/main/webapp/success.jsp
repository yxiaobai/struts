<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登陆成功</title>
</head>
<body>
<h1>登陆成功</h1>
<h3>欢迎你：${account}，你的密码是：${password}---session:${user}-${sessionScope.user}</h3>
<h4><%=session.getAttribute("user")%>></h4>
</body>
</html>

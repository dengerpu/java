<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022-02-26
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="anno/requestParam?name=123">RequestParam</a>
        <form action="anno/requestBody" method="post">
            姓名：<input type="text" name="username"/><br/>
            密码：<input type="text" name="password"/><br/>
            <input type="submit" value="提交">
        </form>

    <a href="anno/pathVariable/10">PathVariable</a><br/>
    <a href="anno/requestHeader">PathVariable</a><br/>
    <a href="anno/cookieValue">CookieValue</a><br/>
    <form action="anno/modelAttribute" method="post">
        姓名：<input type="text" name="name"/><br/>
        年龄：<input type="text" name="age"/><br/>
        <input type="submit" value="提交">
    </form>

    <a href="anno/sessionAttributes">存取SessionAttributes</a><br/>
    <a href="anno/getsessionAttributes">得到SessionAttributes</a><br/>
    <a href="anno/deletesessionAttributes">删除SessionAttributes</a><br/>
</body>
</html>

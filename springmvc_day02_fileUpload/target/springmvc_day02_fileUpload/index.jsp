<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022-02-27
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>


</head>
<body>
<h3>传统文件上传</h3>
<form action="file/upload" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload"/><br/>
    <input type="submit" value="上传文件"/>
</form><br/>
<h3>springmvc文件上传</h3>
<form action="file/upload2" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload"/><br/>
    <input type="submit" value="上传文件"/>
</form>

</body>
</html>

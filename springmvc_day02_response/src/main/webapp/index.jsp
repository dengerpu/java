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
    <a href="user/string">testString</a><br/>
    <a href="user/testVoid">testVoid</a><br/>
    <a href="user/testModelAndView">testModelAndView</a><br/>
    <a href="user/testForwardorRedirect">testForwardorRedirect</a><br/>
    <button  id="btn">发送ajax请求</button>
    <script>
        $(function(){
            $("#btn").click(function(){
                //alert("btn");
                $.ajax({
                    //编写json格式，设置属性和值
                    url:'user/testAjax',
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"zhangsan","password":"1234","age":18}',
                    dataType:"json",
                    type:"post",
                    successs:function(data){
                        //data服务器端响应json数据，进行解析
                        console.log(data);
                        alert(data);
                        alert(data.username);
                    }
                })
            })
        })
    </script>
</body>
</html>

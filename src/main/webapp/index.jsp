<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/4/9
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+
            request.getServerPort()+request.getContextPath()+"/";
    int number = 1;
%>
<html>
<head>
    <base href="<%=basePath%>" />
    <title></title>
</head>
<body>
    <form action="HomePage/main.com" method="post" id="index"></form>
    <s:if test="<%=number%> == null">
        <script>
            window.onload = function () {
                document.getElementById("index").submit();
            }
        </script>
    </s:if>
</body>
</html>

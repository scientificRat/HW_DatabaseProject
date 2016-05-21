<%--
  Created by IntelliJ IDEA.
  User: huangzhengyue
  Date: 5/21/16
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="error" class="java.lang.String" scope="session"></jsp:useBean>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>团队成员查询</title>
</head>
<body>
<h1>团队成员查询</h1>
<form action="/query" method="post">
    <input name="data" type="text" />
    <span>查询方式</span>
    <select name="way" >
        <option value="name">姓名</option>
        <option value="id">学号</option>
        <option value="hobby">兴趣</option>
    </select>
    <input type="submit" title="提交"/>
</form>
<div><%
    if(error!=null){
        out.print(error);
    }
    %>
</div>
</body>
</html>
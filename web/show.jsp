<%--
  Created by IntelliJ IDEA.
  User: huangzhengyue
  Date: 5/21/16
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page language="java" import="utility.MemberData,java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>
<jsp:useBean id="memberDatas" class="java.util.ArrayList" scope="session"></jsp:useBean>
<html>
<head>
    <title>查询结果</title>
</head>
<body>
<h1>查询结果</h1>
<%
    if(memberDatas.isEmpty()){%>
    <h2>没有结果</h2>
<%}
else{
%>
    <table>
        <tr>
            <td>学号</td>
            <td>姓名</td>
            <td>出生日期</td>
            <td>爱好</td>
        </tr>
            <%
                Iterator<MemberData> it=memberDatas.iterator();
                while (it.hasNext()){
                    MemberData m=it.next();
                    out.print("<tr>");
                    out.print("<td>");
                    out.print(m.getStuId());
                    out.print("</td>");

                    out.print("<td>");
                    out.print(m.getName());
                    out.print("</td>");

                    out.print("<td>");
                    out.print(m.getBirthday());
                    out.print("</td>");

                    out.print("<td>");
                    out.print(m.getHobies());
                    out.print("</td>");
                    out.print("</tr>");
                }
            %>

    </table>
<%}%>

<a href="index.jsp">重新查询</a>

</body>
</html>



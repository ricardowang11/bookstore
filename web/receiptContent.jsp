<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/27 0027
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username=request.getParameter("username");
%>
<h1><%=username%>:感谢您光临新世纪网上书店</h1>
<a href="catalog.jsp">继续购物</a>

<%@ page import="edu.ncu.ricardowang.myJavaBean.BookDB" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/27 0027
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    BookDB books= (BookDB) getServletConfig().getServletContext().getAttribute("BOOKS");
    out.println(books);
%>

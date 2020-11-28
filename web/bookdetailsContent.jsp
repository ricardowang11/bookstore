<%@ page import="java.sql.*" %>
<%@ page import="edu.ncu.ricardowang.myJavaBean.BookDB" %>
<%@ page import="edu.ncu.ricardowang.myPracticalClass.BookDetails" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/27 0027
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    BookDB books=new BookDB();
    String bookID=request.getParameter("bookID");
    BookDetails bookDetails=books.getBookDetails(bookID);
    int sales;
    float price;
    if (bookDetails!=null){
        out.println(bookDetails);
%>
<br>
<a href="add.jsp?bookID=<%=bookID%>" >加入购物车</a>&nbsp;&nbsp;&nbsp;<a href="catalog.jsp">继续购物</a>
<%
    }else {
    out.println("书号\""+bookID+"\"在数据库中不存在");

%>
<br>
<a href="catalog.jsp">继续购物</a>
<%
    }
%>





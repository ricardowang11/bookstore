<%@ page import="edu.ncu.ricardowang.myJavaBean.BookDB" %>
<%@ page import="edu.ncu.ricardowang.myPracticalClass.BookDetails" %>
<%@ page import="java.util.LinkedHashSet" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/27 0027
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<a href="showcart.jsp">查看购物车</a>&nbsp;&nbsp;&nbsp;<a href="cashier.jsp">付账</a>
<br>
<p style="size: 20px"><b>请选择想购买的书:</b></p>
<%
    BookDB bookDB= new BookDB();
    LinkedHashSet<BookDetails> bookList=bookDB.getBooks();

%>
<table>
    <%
        for (BookDetails book:bookList){
    %>
    <tr align="left">
        <td><a href="bookdetails.jsp?bookID=<%=book.ID%>"><%=book.TITLE%></a> </td>
        <td><%=book.NAME%></td>
        <td><a href="add.jsp?bookID=<%=book.ID%>">加入购物车</a></td>
    </tr>
    <%
        }
    %>
</table>


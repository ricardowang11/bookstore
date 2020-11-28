<%@ page import="edu.ncu.ricardowang.myJavaBean.ShoppingCart" %>
<%@ page import="edu.ncu.ricardowang.myJavaBean.BookDB" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="edu.ncu.ricardowang.myPracticalClass.ShoppingCartItem" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/27 0027
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    BookDB books= (BookDB) getServletConfig().getServletContext().getAttribute("BOOKS");
    ShoppingCart shoppingCart= (ShoppingCart) getServletConfig().getServletContext().getAttribute("SHOPPINGCART");
    Iterator<ShoppingCartItem> iterator=shoppingCart.iterator();
%>
<h1>您的购物车内有<%=shoppingCart.numberOfBooks%></h1>
<table align="center">
    <tr>
        <th>数量</th>
        <th>书名</th>
        <th>价格</th>
        <th></th>
    </tr>

    <%
        while (iterator.hasNext()){
            ShoppingCartItem item=iterator.next();
    %>
    <tr align="left">
    <td><%=item.ammount%></td>
    <td><%=item.TITLE%></td>
    <td><%=item.PRICE%></td>
    <td><a href="delete.jsp?bookID=<%=item.ID%>&removeAll=false">删除</a></td>
    </tr>
    <%
        }
    %>

</table>
<h1>总额(元)<%=shoppingCart.sumOfPrice%></h1>
<a href="catalog.jsp">继续购物</a>&nbsp;&nbsp;&nbsp;<a href="cashier.jsp">付款</a>&nbsp;&nbsp;&nbsp;<a href="delete.jsp?bookID=0&removeAll=true">清空购物车</a>
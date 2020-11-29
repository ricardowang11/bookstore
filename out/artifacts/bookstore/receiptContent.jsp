<%@ page import="edu.ncu.ricardowang.myJavaBean.ShoppingCart" %>
<%@ page import="edu.ncu.ricardowang.myJavaBean.BookDB" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/27 0027
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username=request.getParameter("username");
//    ShoppingCart shoppingCart= (ShoppingCart) getServletConfig().getServletContext().getAttribute("SHOPPINGCART");
    ShoppingCart shoppingCart= (ShoppingCart) session.getAttribute("SHOPPINGCART");
    BookDB bookDB=new BookDB();
    bookDB.buyBooks(shoppingCart);
    //清空购物车
    shoppingCart.clear();
    shoppingCart.sumOfPrice=0;
    shoppingCart.numberOfBooks=0;
//    getServletConfig().getServletContext().setAttribute("SHOPPINGCART",shoppingCart);
    session.setAttribute("SHOPPINGCART",shoppingCart);
%>

<h1><%=username%>:感谢您光临新世纪网上书店</h1>
<a href="catalog.jsp">继续购物</a>

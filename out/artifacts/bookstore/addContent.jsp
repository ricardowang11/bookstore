<%@ page import="edu.ncu.ricardowang.myPracticalClass.BookDetails" %>
<%@ page import="edu.ncu.ricardowang.myJavaBean.BookDB" %>
<%@ page import="edu.ncu.ricardowang.myJavaBean.ShoppingCart" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/27 0027
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String ID=request.getParameter("bookID");
    BookDB books= (BookDB) getServletConfig().getServletContext().getAttribute("BOOKS");
    ShoppingCart shoppingCart= (ShoppingCart) getServletConfig().getServletContext().getAttribute("SHOPPINGCART");

    BookDetails book=books.findBook(ID);
    shoppingCart.add(book);
    getServletConfig().getServletContext().setAttribute("SHOPPINGCART",shoppingCart);
%>
<h1>成功向购物车添加<%=book.TITLE%>一本</h1>
<a href="catalog.jsp">继续购物</a>
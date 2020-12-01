<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/27 0027
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="errorpage.jsp" %>

<jsp:useBean id="books" class="edu.ncu.ricardowang.myJavaBean.BookDB" scope="application"/>
<jsp:useBean id="shoppingCart" class="edu.ncu.ricardowang.myJavaBean.ShoppingCart" scope="session"/>
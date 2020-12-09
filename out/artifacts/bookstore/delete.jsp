<%@ page import="edu.ncu.ricardowang.myJavaBean.BookDB" %>
<%@ page import="edu.ncu.ricardowang.myJavaBean.ShoppingCart" %>
<%@ page import="edu.ncu.ricardowang.myPracticalClass.ShoppingCartItem" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/28 0028
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.jsp"%>
<%
    String flag=request.getParameter("removeAll");
    if (flag.equals("true")){
        shoppingCart.clear();
        shoppingCart.sumOfPrice=0;
        shoppingCart.numberOfBooks=0;
    }else{
        String ID=request.getParameter("bookID");
        ShoppingCartItem item=new ShoppingCartItem(ID);
        for (ShoppingCartItem shoppingCartItem:shoppingCart){
            if (shoppingCartItem.equals(item)){
                shoppingCart.remove(item);
                shoppingCart.sumOfPrice-=shoppingCartItem.PRICE*shoppingCartItem.ammount;
                shoppingCart.numberOfBooks-=shoppingCartItem.ammount;
                break;
            }
        }
    }
    session.setAttribute("SHOPPINGCART",shoppingCart);
%>
<h1>清除成功</h1>
<a href="catalog">继续购物</a>&nbsp;&nbsp;&nbsp;<a href="showcart">查看购物车</a>

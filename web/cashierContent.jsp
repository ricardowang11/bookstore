<%@ page import="edu.ncu.ricardowang.myJavaBean.BookDB" %>
<%@ page import="edu.ncu.ricardowang.myJavaBean.ShoppingCart" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/28 0028
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    BookDB books= (BookDB) session.getAttribute("BOOKS");
//    ShoppingCart shoppingCart= (ShoppingCart) getServletConfig().getServletContext().getAttribute("SHOPPINGCART");
    ShoppingCart shoppingCart= (ShoppingCart) session.getAttribute("SHOPPINGCART");
    float price=shoppingCart.sumOfPrice;
%>
<p align="left">您一共购买了<%=shoppingCart.numberOfBooks%>本书</p>
<p align="left">您应支付的金额为<%=price%></p>
<form action="receipt.jsp">
    <table align="left">
        <tr>
            <td>信用卡用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>信用卡账号</td>
            <td><input type="text" name="account"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="递交"></td>

        </tr>
    </table>
</form>

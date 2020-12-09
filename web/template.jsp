<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/27 0027
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="mm" uri="/mytaglib" %>
<%@page errorPage="errorpage.jsp" %>
<%@include file="screendefinitions.jsp"%>
<html>
<head>
    <title>
        <mm:insert definition="bookstore" parameter="title"/>
    </title>
</head>
<body>
<table width="100%" height="100%" border="0" >
    <tr >
        <td width="100%" height="10%">
            <mm:insert definition="bookstore" parameter="banner"/>
        </td>

    </tr>
    <tr>
        <td width="100%" height="*" align="center">
            <mm:insert definition="bookstore" parameter="body"/>
        </td>
    </tr>
</table>
</body>
</html>

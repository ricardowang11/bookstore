<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/27 0027
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page errorPage="errorpage.jsp" %>

<html>
<head>
    <title><%=titlename%></title>
</head>
<body>
<table width="100%" height="100%" border="0" >
    <tr >
        <td width="100%" height="10%">
            <%@include file="banner.jsp"%>
        </td>

    </tr>
    <tr>
        <td width="100%" height="*" align="center">
            <jsp:include page="<%=bodyfile%>" />
        </td>
    </tr>
</table>
</body>
</html>

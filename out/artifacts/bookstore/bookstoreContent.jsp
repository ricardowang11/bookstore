<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/27 0027
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

%>
<form action="bookdetails.jsp" method="post">
    <table cellspacing="50px">
        <tr>
            <td align="center"><p><a href="catalog.jsp">查看所有书目</a></p></td>
        </tr>
        <tr>
            <td align="center"><p style="size: 20px"><b>请输入查询信息</b></p></td>
        </tr>
        <tr>
            <td align="center">
                <b>书的编号：</b><input type="text" placeholder="如209" size="20" name="bookID">
            </td>
        </tr>
        <tr>
            <td align="center">
                <input type="submit" value="查询">
            </td>
        </tr>
    </table>
</form>

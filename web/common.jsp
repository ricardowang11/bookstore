<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/27 0027
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="edu.ncu.ricardowang.myJavaBean" %>
<%@page import="java.util.Properties" %>
<%@ page import="java.io.UnsupportedEncodingException" %>
<%@ page errorPage="errorpage.jsp" %>
<jsp:useBean id="bookDB" scope="application" class="edu.ncu.ricardowang.myJavaBean.BookDB"/>
<%!
    public String convert(String s){
        try{
            return new String(s.getBytes("ISO-8859-1"),"uTf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
%>
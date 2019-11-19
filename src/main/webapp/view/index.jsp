<%--
  Created by IntelliJ IDEA.
  User: nhile
  Date: 18/11/2019
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<!DOCTYPE html>
<html>
<head>
    <title>Quản lí nhân sự</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/index.css">

</head>
<frameset rows="20%,*" border=0>
    <%if (request.getSession().getAttribute("login") != null){
        System.out.println("vo roi");
    }%>
    <frame name="header" src="fragment/header.jsp" scrolling="no"></frame>
    <frameset cols="15%,*,15%" border=0>
        <frame name="leftBar" src="fragment/leftBar.jsp" noresize></frame>
        <frame name="home" src="fragment/home.jsp" noresize></frame>
        <frame name="rightBar" src="fragment/rightBar.jsp" noresize scrolling="no"></frame>
    </frameset>
</frameset>
</html>

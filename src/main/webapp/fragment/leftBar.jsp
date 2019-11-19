<%--
  Created by IntelliJ IDEA.
  User: nhile
  Date: 19/11/2019
  Time: 07:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>LeftBar</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../css/reset.css">
    <link rel="stylesheet" type="text/css" href="../css/T2.css">

</head>
<body>
<ul>
    <li class="btn"><a href="/fragment/home.jsp" target="home">Trang chủ</a></li>
    <li  class="btn"><a href="${pageContext.request.contextPath}/showEmployees" target="home">Xem thông tin</a></li>
    <li  class="btn"><a href="" target="home">Tìm kiếm</a></li>

</ul>
</body>
</html>

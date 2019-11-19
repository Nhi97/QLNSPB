<%--
  Created by IntelliJ IDEA.
  User: nhile
  Date: 18/11/2019
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE >
<html>
<head>
    <title>Header</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../css/reset.css">
    <link rel="stylesheet" type="text/css" href="../css/T1.css">
</head>
<body>
<img src="../images/icon.png" alt="" class="img_left">
<marquee class="header" scrollamount="17">Chào mừng đến với trang quản lý phòng ban</marquee>
<img src="../images/icon.png" alt="" class="img_right">
<div class="login"   >
    <form action="${pageContext.request.contextPath}/login" method="post">
        <spam>
            <label>Username:</label>
            <input type="text" name="username">
        </spam>

        <spam>
            <label>Password:</label>
            <input type="password" name="password">
        </spam>

        <spam>
            <button type="submit">Login</button>
        </spam>
    </form>

</div>

</body>
</html>

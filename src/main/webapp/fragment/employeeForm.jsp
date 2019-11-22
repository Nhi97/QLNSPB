<%--
  Created by IntelliJ IDEA.
  User: nhile
  Date: 22/11/2019
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<div class="container">

    <h1>Department Form</h1>
    <hr/>

    <div class="row">
        <div class="col-md-4">
            <form action="${pageContext.request.contextPath}/employee" method="POST">

                <%
                    if (request.getAttribute("employee") == null) {
                %>
                <input type="text" name="idnv" placeholder="Enter idnv"/>
                <%
                    }
                %>

                <div class="form-group">
                    <input type="text" class="form-control" name="fullname" placeholder="Enter FullName"
                           value="${employee.fullName}"/>
                </div>


                <div class="form-group">
                    <input type="text" class="form-control" name="idpb" placeholder="Enter IDPB"
                           value="${employee.idPb}"/>
                </div>

                <div class="form-group">
                    <input type="text" class="form-control" name="address" placeholder="Enter Address"
                           value="${employee.address}"/>
                </div>

                <button type="submit" class="btn btn-primary">Save</button>
            </form>
        </div>
    </div>
    <a href="${pageContext.request.contextPath}/employee">Back to List</a>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
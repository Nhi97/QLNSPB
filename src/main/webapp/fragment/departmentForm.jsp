<%@ page import="model.bean.Department" %><%--
  Created by IntelliJ IDEA.
  User: nhile
  Date: 22/11/2019
  Time: 09:59
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

    <h3>Department Form</h3>
    <hr/>

    <div class="row">
        <div class="col-md-4">
            <form action="${pageContext.request.contextPath}/department" method="POST">
                <%
                    if (request.getAttribute("department") == null) {
                %>
                <div class="form-group">
                    <label>IDPB:</label>
                    <input type="text" name="idpb" placeholder="Enter idpb"/>
                </div>

                <%
                } else {
                %>
                <input type = "hidden" name = "idpb" value = "${department.id}"/>
                <%
                    }
                %>

                <div class="form-group">
                    <label>Department Name:</label>
                    <input type="text" class="form-control" name="name" placeholder="Enter Name"
                           value="${department.departmentName}"/>
                </div>

                <div class="form-group">
                    <label>Description:</label>
                    <input type="text" class="form-control" name="description" placeholder="Enter Description"
                           value="${department.description}"/>
                </div>

                <button type="submit" class="btn btn-primary">Save</button>
            </form>
        </div>
    </div>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/department">Back to List</a>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
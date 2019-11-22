<%@ page import="java.util.List" %>
<%@ page import="model.bean.Department" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: nhile
  Date: 21/11/2019
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Department</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../css/reset.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    <%--<link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">--%>
</head>
<body>
<p><%request.getAttribute("NOTIFICATION");%></p>
<p>
    <button class="btn btn-primary" onclick="window.location.href = 'fragment/departmentForm.jsp'">Add Department</button>
</p>
<table width=100% class="table table-striped table-bordered">
    <thead>
    <tr class="thead-dark">
        <th>STT</th>
        <th>IDPB</th>
        <th>DepartmentName</th>
        <th>Description</th>
        <th>ListEmployees</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>

    <tbody>
    <%
        List<Department> departments = (ArrayList) request.getAttribute("departments");

        for (int i = 0; i < departments.size(); i++) {
            Department department = departments.get(i);
    %>

    <tr>
        <td><%= i + 1%></td>
        <td><%=department.getId()%></td>
        <td><%=department.getDepartmentName()%></td>
        <td><%=department.getDescription()%></td>

        <td><a class="btn btn-primary" href="${pageContext.request.contextPath}/department?action=LIST&idpb=<%=department.getId()%>">Show</a></td>

        <td><a class="btn btn-primary"
               href="${pageContext.request.contextPath}/department?action=EDIT&idpb=<%=department.getId()%>">Edit</a>
        </td>

        <td><a class="btn btn-primary"
               href="${pageContext.request.contextPath}/department?action=DELETE&idpb=<%=department.getId()%>">Delete</a>
        </td>

    </tr>

    <%
        }
    %>
    </tbody>

</table>

</body>
</html>

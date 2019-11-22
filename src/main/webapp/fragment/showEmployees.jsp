<%@ page import="model.bean.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 11/19/19
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employee</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../css/reset.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    <%--<link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">--%>
</head>
<body>
<p><%request.getAttribute("NOTIFICATION");%></p>
<p>
    <button class="btn btn-primary" onclick="window.location.href = 'fragment/employeeForm.jsp'">Add Employee</button>
</p>
<table width=100% class="table table-striped table-bordered">
    <thead>
    <tr class="thead-dark">
        <th>STT</th>
        <th>IDNV</th>
        <th>FullName</th>
        <th>IDPB</th>
        <th>Address</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>

    <tbody>
    <%
        List<Employee> employees = (ArrayList) request.getAttribute("employees");

        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
    %>

    <tr>
        <td><%= i + 1%></td>
        <td><%=employee.getId()%></td>
        <td><%=employee.getFullName()%></td>
        <td><%=employee.getIdPb()%></td>
        <td><%=employee.getAddress()%></td>

        <td><a class="btn btn-primary"
               href="${pageContext.request.contextPath}/employee?action=EDIT&idnv=<%=employee.getId()%>">Edit</a>
        </td>

        <td><a class="btn btn-primary"
               href="${pageContext.request.contextPath}/employee?action=DELETE&idnv=<%=employee.getId()%>">Delete</a>
        </td>

    </tr>

    <%
        }
    %>
    </tbody>

</table>

</body>
</html>

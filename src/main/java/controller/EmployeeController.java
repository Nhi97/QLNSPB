package controller;

import model.bean.Employee;
import model.bo.EmployeeBo;
import model.bo.impl.EmployeeBoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/employee")
public class EmployeeController extends HttpServlet {
    private EmployeeBo employeeBo;
    private RequestDispatcher dispatcher = null;

    public EmployeeController() {
        employeeBo = new EmployeeBoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = (String) req.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {

            case "EDIT": {
                getSingleEmployee(req, resp);
                break;
            }
            case "DELETE": {
                deleteDepartment(req, resp);
                break;
            }
            default: {
                getListEmployees(req, resp);
                break;
            }
        }
    }

    public void getSingleEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idnv = req.getParameter("idnv");
        Employee employee = employeeBo.getEmployee(idnv);
        req.setAttribute("employee", employee);
        dispatcher = req.getRequestDispatcher("/fragment/employeeForm.jsp");
        dispatcher.forward(req, resp);
    }

    public void getListEmployees(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Employee> employees = employeeBo.getListEmployees();
        req.setAttribute("employees", employees);
        dispatcher = req.getRequestDispatcher("/fragment/showEmployees.jsp");
        dispatcher.forward(req, resp);
    }

    public void deleteDepartment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idnv = req.getParameter("idnv");
        if (employeeBo.deleteEmployee(idnv) == 1) {
            req.setAttribute("NOTIFICATION", "Employee deleted successfully!!!");
        }
        getListEmployees(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idnv = req.getParameter("idnv");
        Employee employee = new Employee();
        employee.setFullName(req.getParameter("fullname"));
        employee.setIdPb(req.getParameter("idpb"));
        employee.setAddress(req.getParameter("address"));

        if (employee.getId() == null || employee.getId().isEmpty()) {
            employee.setId(idnv);
            if (employeeBo.addEmployee(employee) == 1) {
                req.setAttribute("NOTIFICATION", "Department added successfully!!!");
            }
        } else if(idnv != null || !idnv.isEmpty()){
            employee.setId(idnv);
            System.out.println("edit:" + employee);
            if (employeeBo.editEmployee(employee) == 1) {
                req.setAttribute("NOTIFICATION", "Department edited successfully!!!");
            }
        }
        getListEmployees(req, resp);
    }
}

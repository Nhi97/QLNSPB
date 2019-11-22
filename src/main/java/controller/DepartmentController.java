package controller;

import model.bean.Department;
import model.bean.Employee;
import model.bo.DepartmentBo;
import model.bo.impl.DepartmentBoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/department")
public class DepartmentController extends HttpServlet {
    private DepartmentBo departmentBo;
    private RequestDispatcher dispatcher = null;

    public DepartmentController() {
        departmentBo = new DepartmentBoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = (String) req.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "LIST":
                getListEmployees(req, resp);
                break;

            case "EDIT":
                getSingleDepartment(req, resp);
                break;

            case "DELETE":
                deleteDepartment(req, resp);
                break;

            default:
                getListDepartments(req, resp);
                break;
        }

    }

    public void getListEmployees(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idpb = (String)req.getParameter("idpb");
        List<Employee> employees = departmentBo.getListEmployees(idpb);
        req.setAttribute("employees", employees);
        dispatcher = req.getRequestDispatcher("/fragment/showEmployees.jsp");
        dispatcher.forward(req, resp);
    }

    public void getSingleDepartment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idpb = (String)req.getParameter("idpb");
        Department department = departmentBo.getDepartment(idpb);
        req.setAttribute("department", department);
        dispatcher = req.getRequestDispatcher("/fragment/departmentForm.jsp");
        dispatcher.forward(req, resp);
    }

    public void getListDepartments(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Department> departments = departmentBo.getListDepartments();
        req.setAttribute("departments", departments);
        dispatcher = req.getRequestDispatcher("/fragment/showDepartments.jsp");
        dispatcher.forward(req, resp);

    }

    public void deleteDepartment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idpb = req.getParameter("idpb");
        if (departmentBo.deleteDepartment(idpb) == 1) {
            req.setAttribute("NOTIFICATION", "Department deleted successfully!!!");
        }
        getListDepartments(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idpb = (String)req.getParameter("idpb");
        System.out.println("idpb dopost: " + idpb);
        Department department = new Department();
        department.setDepartmentName(req.getParameter("name"));
        department.setDescription(req.getParameter("description"));

        if (idpb == null || idpb.isEmpty()) {
            department.setId(idpb);
            if (departmentBo.addDepartment(department) == 1) {
                req.setAttribute("NOTIFICATION", "Department added successfully!!!");
            }
        } else if(idpb != null || !idpb.isEmpty()){
            System.out.println("idpb dopost: " + idpb);
            department.setId(idpb);
            if (departmentBo.editDepartment(department) == 1) {
                req.setAttribute("NOTIFICATION", "Department edited successfully!!!");
            }
        }
        getListDepartments(req, resp);
    }

}

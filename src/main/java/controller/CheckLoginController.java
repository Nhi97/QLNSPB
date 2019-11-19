package controller;

import model.bean.User;
import model.dao.UserDao;
import model.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class CheckLoginController extends HttpServlet {
    private UserDao userDao;
    public CheckLoginController(){
        userDao = new UserDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        User user = new User(userName, passWord);
        System.out.println(user);

        if(userDao.checkLogin(user)){
            HttpSession session = request.getSession();
            String login = "true";
            session.setAttribute("login", login);
            System.out.println(session);
        }
        else{

        }
        request.getRequestDispatcher("view/index.jsp").forward(request,response);
    }
}

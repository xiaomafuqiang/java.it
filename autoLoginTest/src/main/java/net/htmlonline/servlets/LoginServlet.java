package net.htmlonline.servlets;

import net.htmlonline.domain.UserBean;
import net.htmlonline.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置编码
        req.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String autoLogin = req.getParameter("autoLogin");
        UserBean userBean = new UserBean();
        userBean.setUsername(username);
        userBean.setPassword(password);

//        try {
//            UserBean login = new UserServiceImpl().login(userBean);
//
//            if (login != null) {
//                req.getRequestDispatcher("/views/home.html").forward(req, resp);
//            } else {
//
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

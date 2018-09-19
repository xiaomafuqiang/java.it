package net.htmlonline.servlets;

import net.htmlonline.domain.UserBean;
import net.htmlonline.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static net.htmlonline.util.Utils.print;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置编码

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String autoLogin = req.getParameter("auto_login");
        UserBean userBean = new UserBean();
        userBean.setUsername(username);
        userBean.setPassword(password);
        print(userBean, autoLogin);

        try {
            UserBean user = new UserServiceImpl().login(userBean);
            if (user != null) {

                if ("on".equalsIgnoreCase(autoLogin)) {
                    Cookie cookie = new Cookie("auto_login", username + "::" + password);
                    cookie.setMaxAge(60 * 60 * 24 * 7);
                    cookie.setPath("/");
                    resp.addCookie(cookie);
                }

                req.getSession().setAttribute("userBean", user);
                resp.sendRedirect("/views/home.html");
            } else {
                req.getRequestDispatcher("/views/login.html").forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

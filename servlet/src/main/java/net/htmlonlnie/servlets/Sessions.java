package net.htmlonlnie.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/session")
public class Sessions extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String par = req.getParameter("noSet");
        HttpSession session;
        if (par != null) {
            session = req.getSession(false);
        } else {
            session = req.getSession();
            session.setMaxInactiveInterval(1); // 默认0 设置1可以删除 or
            // session.invalidate();
        }
        System.out.println(session.getId());

    }


}

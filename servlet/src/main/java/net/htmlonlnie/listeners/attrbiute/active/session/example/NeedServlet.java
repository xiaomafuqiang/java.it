package net.htmlonlnie.listeners.attrbiute.active.session.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@WebServlet("/need")
public class NeedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获得session 不创建
        HttpSession session = req.getSession();
        System.out.println("session --->> " + session);
        Object bean = session.getAttribute("bean");
        if (bean == null) {
            System.out.println("新创建...");
            String value = "sessionName..." + (new Random()).nextInt(100);
            SessionActiveExampleBean sessionActiveExampleBean = new SessionActiveExampleBean();
            sessionActiveExampleBean.setName(value);
            session.setAttribute("bean", sessionActiveExampleBean);
        }
        System.out.println(session.getId() + "----" + session.getAttribute("bean"));
        Date d = new Date(session.getCreationTime());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d));
    }
}

package net.htmlonlnie.runs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/forward")
public class ForwardAndRedirect extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        redirect(resp);
    }

    private void forward(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/v.html").forward(req, resp);
        // req.getRequestDispatcher("views/v.html").include(req, resp);
    }

    private void redirect(HttpServletResponse resp) throws IOException {
        resp.sendRedirect("views/v.html");
    }
}

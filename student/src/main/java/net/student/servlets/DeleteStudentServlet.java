package net.student.servlets;

import net.student.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/delStu")
public class DeleteStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        int id = Integer.parseInt(req.getParameter("id"));

        try {
            int res = new StudentServiceImpl().delStu(id);
            resp.getWriter().write("{\"code\":" + res +"}");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package net.student.servlets;

import net.student.domain.Student;
import net.student.service.impl.StudentServiceImpl;
import net.student.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/update")
public class UpdateStu extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求体编码
        req.setCharacterEncoding("utf-8");

        //设置相应编码
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        Student student = Utils.parseRequstBody(req.getReader(), Student.class);
        System.out.println(student);

        try {
            int res = new StudentServiceImpl().updateStu(student);
            resp.getWriter().write("{\"code\":" + res +"}");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

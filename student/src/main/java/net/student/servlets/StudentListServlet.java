package net.student.servlets;

import com.alibaba.fastjson.JSON;
import net.student.domain.Student;
import net.student.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/students")
public class StudentListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        StudentServiceImpl studentService = new StudentServiceImpl();

        try {
            List<Student> all = studentService.findAll();

            String str = JSON.toJSONString(all);
            System.out.println(str);
            resp.setStatus(200);

            resp.getWriter().write(str);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
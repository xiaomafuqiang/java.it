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

@WebServlet("/findOne")
public class FindOneStu extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        String string = req.getParameter("id");
        int id = new Integer(string);

        try {
            Student oneById = new StudentServiceImpl().findOneById(id);
            resp.getWriter().write(JSON.toJSONString(oneById));
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

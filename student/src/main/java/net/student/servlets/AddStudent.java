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

@WebServlet("/addStu")
public class AddStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求体编码
        req.setCharacterEncoding("utf-8");

        //设置相应编码
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        // 获取参数内容
        String sname = req.getParameter("sname");
        String birthday = req.getParameter("birthday");
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        String hobby = req.getParameter("hobby");
        String info = req.getParameter("info");

        Student student = new Student();
        student.setSname(sname);
        student.setBirthday(Utils.parseDate(birthday));
        student.setGender(gender);
        student.setPhone(phone);
        student.setHobby(hobby);
        student.setInfo(info);

        StudentServiceImpl service = new StudentServiceImpl();
        try {
            resp.getWriter().write(service.insertStu(student));
        } catch (SQLException e) {
            System.out.println("添加异常...");
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

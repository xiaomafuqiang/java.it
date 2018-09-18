package net.student.servlets;

import com.alibaba.fastjson.JSON;
import net.student.dao.impl.StudentDaoImpl;
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
import java.util.logging.Logger;

@WebServlet("/search")
public class SearchStudentServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(StudentDaoImpl.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 根据性别或名字查找
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");


        // para
        String sname = req.getParameter("sname");
        String gender = req.getParameter("gender");
        log.info("sname" + sname);
        log.info("gender" + gender);

        try {
            List<Student> students = new StudentServiceImpl().searchStudent(sname, gender);
            String string = JSON.toJSONString(students);
            log.info("response:::==" + string);
            resp.getWriter().write(string);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

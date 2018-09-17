package net.student.service.impl;

import net.student.dao.impl.StudentDaoImpl;
import net.student.domain.Student;
import net.student.service.StudentService;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDaoImpl studentDao = new StudentDaoImpl();

    @Override
    public List<Student> findAll()  throws SQLException {

        return studentDao.findAll();
    }

    @Override
    public int insertStu(Student student) throws SQLException {
        return studentDao.insertStu(student);
    }
}

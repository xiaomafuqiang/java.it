package net.student.service.impl;

import net.student.dao.impl.StudentDaoImpl;
import net.student.domain.Student;
import net.student.service.StudentService;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> findAll()  throws SQLException {

        StudentDaoImpl studentDao = new StudentDaoImpl();
        return studentDao.findAll();
    }
}

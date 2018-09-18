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

    @Override
    public int delStu(int id) throws SQLException {
        return studentDao.delStu(id);
    }

    @Override
    public Student findOneById(int id) throws SQLException {
        return studentDao.findOneById(id);
    }

    @Override
    public int updateStu(Student student) throws SQLException {
        return studentDao.updateStu(student);
    }

    @Override
    public List<Student> searchStudent(String sname, String gender) throws SQLException {
        return studentDao.searchStudent(sname, gender);
    }
}

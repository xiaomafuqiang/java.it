package net.student.service;

import net.student.domain.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    List<Student> findAll() throws SQLException;

    int insertStu(Student student) throws SQLException;

    int delStu(int id) throws SQLException;

    Student findOneById(int id) throws SQLException;

    int updateStu(Student student) throws SQLException;

    List<Student> searchStudent(String sname, String gender) throws SQLException;
}

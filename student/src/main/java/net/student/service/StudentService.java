package net.student.service;

import net.student.domain.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    List<Student> findAll() throws SQLException;
}

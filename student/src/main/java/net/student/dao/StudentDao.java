package net.student.dao;

import net.student.domain.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * 针对数据库访问
 *
 * */
public interface StudentDao {

    // 查询所有学生 返回 list
    List<Student> findAll () throws SQLException;
}

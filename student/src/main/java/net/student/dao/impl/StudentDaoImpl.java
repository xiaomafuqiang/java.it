package net.student.dao.impl;

import net.student.dao.StudentDao;
import net.student.domain.Student;
import net.student.util.Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> findAll() throws SQLException {

        QueryRunner runner = new QueryRunner(Utils.getDataSource());
        String sql = "select * from stu";

        return runner.query(sql, new BeanListHandler<>(Student.class));
    }
}

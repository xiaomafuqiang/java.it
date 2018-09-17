package net.student.dao.impl;

import net.student.dao.StudentDao;
import net.student.domain.Student;
import net.student.util.Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    QueryRunner runner = new QueryRunner(Utils.getDataSource());


    @Override
    public List<Student> findAll() throws SQLException {

        String sql = "select * from stu";

        return runner.query(sql, new BeanListHandler<>(Student.class));
    }

    @Override
    public int insertStu(Student student) throws SQLException {
        String sname = student.getSname();
        Date birthday = student.getBirthday();

        String birString = birthday.getYear() + "-" + birthday.getMonth() + "-" + birthday.getDate();
        String gender = student.getGender();
        String phone = student.getPhone();
        String hobby = student.getHobby();
        String info = student.getInfo();
        System.out.println(birthday);
        System.out.println("-------");


        String sql = "insert into stu(sname, birthday, gender, phone, hobby, info) values(?,?,?,?,?,?)";
        return runner.update(sql, sname, birString, gender, phone, hobby, info);

    }
}

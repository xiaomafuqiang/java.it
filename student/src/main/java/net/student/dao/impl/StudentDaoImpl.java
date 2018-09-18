package net.student.dao.impl;

import net.student.dao.StudentDao;
import net.student.domain.Student;
import net.student.util.Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class StudentDaoImpl implements StudentDao {
    private QueryRunner runner = new QueryRunner(Utils.getDataSource());
    private static Logger log = Logger.getLogger(StudentDaoImpl.class.getName());


    @Override
    public List<Student> findAll() throws SQLException {

        String sql = "select * from stu";

        return runner.query(sql, new BeanListHandler<>(Student.class));
    }

    @Override
    public int insertStu(Student student) throws SQLException {
        String sname = student.getSname();
        Date birthday = student.getBirthday();

        String birString = 1900 + birthday.getYear() + "-" + birthday.getMonth() + "-" + birthday.getDate();
        String gender = student.getGender();
        String phone = student.getPhone();
        String hobby = student.getHobby();
        hobby = hobby.substring(1, hobby.length() - 1);
        String info = student.getInfo();
        System.out.println("birthday:::: " + birthday);
        System.out.println("bithString::: " + birString);


        String sql = "insert into stu(sname, birthday, gender, phone, hobby, info) values(?,?,?,?,?,?)";
        return runner.update(sql, sname, birString, gender, phone, hobby, info);

    }

    @Override
    public int delStu(int id) throws SQLException {
        String sql = "delete from stu where id=?";
        return runner.update(sql, id);
    }

    @Override
    public Student findOneById(int id) throws SQLException {

        String sql = "select * from stu where id=?";
        return runner.query(sql, new BeanHandler<>(Student.class), id);

    }

    @Override
    public int updateStu(Student student) throws SQLException {
        String sname = student.getSname();
        Date birthday = student.getBirthday();

        String birString = 1900 + birthday.getYear() + "-" + birthday.getMonth() + "-" + birthday.getDate();
        String gender = student.getGender();
        String phone = student.getPhone();
        int id = student.getId();
        String hobby = student.getHobby();
        hobby = hobby.substring(1, hobby.length() - 1);
        String info = student.getInfo();
        System.out.println("birthday:::: " + birthday);
        System.out.println("bithString::: " + birString);

        // sname, birthday, gender, phone, hobby, info
        String sql = "update stu set sname=?, birthday=?, gender=?, phone=?, hobby=?, info=? where id=?";
        return runner.update(sql, sname, birthday, gender, phone, hobby, info, id);

    }

    @Override
    public List<Student> searchStudent(String sname, String gender) throws SQLException {
        String sql = " select * from stu where 1=1 ";
        List<String> list = new ArrayList<>();

        if (sname != null && !sname.equals("")) {
            sql += " and sname like ? ";
            list.add("%" + sname + "%");
        }
        if (gender != null && !gender.equals("")) {
            sql += " and gender=? ";
            list.add(gender);
        }
        log.info("sql:::== " + sql);

        return runner.query(sql, new BeanListHandler<>(Student.class), list.toArray());

    }
}

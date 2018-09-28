package net.htmlonline.domain.Multiple.test;

import net.htmlonline.domain.Multiple.Grade;
import net.htmlonline.domain.Multiple.Student;
import net.htmlonline.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;


public class OneToManyTest {


    @Test
    public void testAdd() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Grade grade = new Grade("五（一）班", "五年级一班");
        Student stu1 = new Student("张三", "男");
        Student stu2 = new Student("李四", "女");

        grade.getStudents().add(stu1);
        grade.getStudents().add(stu2);

        stu1.setGrade(grade);

        session.save(stu1);
        session.save(stu2);
        session.save(grade);

        transaction.commit();
        session.close();
    }

}
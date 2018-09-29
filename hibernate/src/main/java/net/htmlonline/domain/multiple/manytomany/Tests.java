package net.htmlonline.domain.multiple.manytomany;

import net.htmlonline.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

public class Tests {
    @Test
    public void run() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        // 创建用户两个
        User user1 = new User();
        user1.setUser_name("中阿");
        User user2 = new User();

        // 创建3角色
        Role role1 = new Role();
        role1.setRole_name("aaa");
        Role role2 = new Role();
        role2.setRole_name("aaa");
        Role role3 = new Role();
        role3.setRole_name("aaa");

        // 设置双向关系
        user1.getRoles().add(role1);
        user1.getRoles().add(role2);
        user2.getRoles().add(role2);
        user2.getRoles().add(role3);
        role1.getUsers().add(user1);
        role2.getUsers().add(user1);
        role2.getUsers().add(user2);
        role3.getUsers().add(user2);

        // 保存
        // 默认 会保存失败 报错  Duplicate entry '4-3' for key 'PRIMARY'
        // 因为是有中间表 两次创建外键 :: 需要一方放弃外检 权利 <set inverse=true/>
        // cascade="save-update, delete" 才能保存一方,级联操作
        // session.save(user1);
        // session.save(user2);
        session.save(role1);
        session.save(role2);
        session.save(role3);


        transaction.commit();

    }
    @Test
    public void run2() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Role role = session.get(Role.class, 8L);
        System.out.println("::::::: " + role);
        // cascade="save-update, delete" 才能保存一方,级联操作
        session.delete(role);

        transaction.commit();
    }

    @Test
    public void run3() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        // 更改关联

        // 获取用户1
        User user = session.get(User.class, 10L);
        System.out.println(user);
        // 获取角色2
        Role role = session.get(Role.class, 10L);
        System.out.println(role);

        // ** 操作数据库就是操作对象 内容 ** ##
        // 多选一个角色
        // user.getRoles().add(role);
        // 删除一个角色
        // user.getRoles().remove(role);
        // 更改一个角色
        // user.getRoles().remove(role2);
        // user.getRoles().add(role3);

        transaction.commit();
    }
}

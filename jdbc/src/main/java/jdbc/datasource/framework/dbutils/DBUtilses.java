package jdbc.datasource.framework.dbutils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import jdbc.datasource.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static jdbc.util.Utils.getResultList;
import static jdbc.util.Utils.getResultOne;
import static jdbc.util.Utils.printMsg;

public class DBUtilses {
    ComboPooledDataSource source = new ComboPooledDataSource();

    QueryRunner runner = new QueryRunner(source);

    @Test
    public void noQuery() throws SQLException {
        // runner.update(sql, ...params); 增加删除修改

        String sql = "delete from user where id=?";
        sql = "insert into user values(?, ?, ?)";
        sql = "update user set username=? where id=?";
        int res = runner.update(sql, "hhhhh", 6);
        printMsg(res);
    }

    @Test
    /**
     * important
     * */
    public void query() throws SQLException {
        // runner.query(sql, ResultSetHandler(){}, ...params); 增加删除修改
        String sql = "select * from user where id=?";
        User user = runner.query(sql, new ResultSetHandler<User>() {

            @Override
            public User handle(ResultSet resultSet) throws SQLException {

                User user = new User();
                Map<Object, Object> resultOne = getResultOne(resultSet);

                user.setId((int) resultOne.get("id"));
                user.setPassword((String) resultOne.get("password"));
                user.setUserName((String) resultOne.get("username"));
                return user;
            }
        }, 6);
        System.out.println(user);

        //  runner.query(sql, new BeanHandler<>(User.class), 6) 一条数据
        User user1 = runner.query(sql, new BeanHandler<>(User.class), 6);
        System.out.println("beanHandler..." + user1);

        //  runner.query(sql, new BeanListHandler<>(User.class))
        List<User> list = runner.query("select * from user", new BeanListHandler<>(User.class));
        System.out.println(list);

    }
}

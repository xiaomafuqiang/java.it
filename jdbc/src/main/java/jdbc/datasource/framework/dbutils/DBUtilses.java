package jdbc.datasource.framework.dbutils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import jdbc.datasource.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static jdbc.util.Utils.getResultOne;
import static jdbc.util.Utils.printMsg;

public class DBUtilses {
    private ComboPooledDataSource source = new ComboPooledDataSource();
    private QueryRunner runner = new QueryRunner(source);
    private String sql = "select * from user where id=?";
    private String sqlAll = "select * from user";

    @Test
    public void noQuery() throws SQLException {
        // runner.update(sql, ...params); 增加删除修改
        sql = "delete from user where id=?";
        sql = "insert into user values(?, ?, ?)";
        sql = "update user set username=? where id=?";
        int res = runner.update(sql, "hhhhh", 6);
        printMsg(res);
    }

    @Test
    /**
     * important
     * */
    // ArrayHandler：把结果集中的第一行数据转成对象数组。
    // ArrayListHandler：把结果集中的每一行数据都转成一个对象数组，再存放到List中。
    // BeanHandler：将结果集中的第一行数据封装到一个对应的JavaBean实例中。
    // BeanListHandler：将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。
    // ColumnListHandler：将结果集中某一列的数据存放到List中。
    // KeyedHandler：将结果集中的每一行数据都封装到一个Map里，然后再根据指定的key把每个Map再存放到一个Map里。
    // MapHandler：将结果集中的第一行数据封装到一个Map里，key是列名，value就是对应的值。
    // MapListHandler：将结果集中的每一行数据都封装到一个Map里，然后再存放到List。
    // ScalarHandler：将结果集中某一条记录的其中某一列的数据存成Object。
    public void query() throws SQLException {


        // runner.query(sql, ResultSetHandler(){}, ...params); 增加删除修改
        defaultImplHandle();

        //  runner.query(sql, new BeanHandler<>(User.class), 6) 一条数据
        //  runner.query(sql, new BeanListHandler<>(User.class)) 多条数据
        beanHandler();

        // arrayHandlers...
        arrayHandler();


        // mapHandler ...
        mapHandler();
    }

    private void mapHandler() throws SQLException {
        Map<String, Object> query = runner.query(sql, new MapHandler(), 3);
        System.out.println(query);

        List<Map<String, Object>> queryAll = runner.query(sqlAll, new MapListHandler());
        System.out.println(queryAll);
    }

    private void arrayHandler() throws SQLException {
        Object[] query = runner.query(sql, new ArrayHandler(), 3);
        System.out.println(Arrays.toString(query));

        List<Object[]> queryAll = runner.query(sqlAll, new ArrayListHandler());
        System.out.println(queryAll);
    }

    private void beanHandler() throws SQLException {
        User user1 = runner.query(sql, new BeanHandler<>(User.class), 6);
        System.out.println("beanHandler..." + user1);

        List<User> list = runner.query(sqlAll, new BeanListHandler<>(User.class));
        System.out.println(list);
    }

    private void defaultImplHandle() throws SQLException {
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
        }, 2);
        System.out.println(user);
    }
}

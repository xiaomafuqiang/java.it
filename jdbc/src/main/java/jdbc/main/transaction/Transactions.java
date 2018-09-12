package jdbc.main.transaction;

import jdbc.main.util.Utils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transactions {

    @Test
    public void test() {
        Connection connection = Utils.getConnection();
        PreparedStatement statement = null;


        try {
            connection.setAutoCommit(false); // 自动提交禁用
            System.out.println(connection.getTransactionIsolation()+";;;;");
            // 隔离级别 // connection.setTransactionIsolation(Connection.TRANSACTION_NONE);
            // Connection.TRANSACTION_NONE // 不支持事务
            // Connection.TRANSACTION_READ_UNCOMMITTED // 在提交前一个事务可以看到另一个事务的变化。这样脏读、不可重复的读和虚读都是允许的。
            // Connection.TRANSACTION_READ_COMMITTED (oracle default) // 读取未提交的数据是不允许的。这个级别仍然允许不可重复的读和虚读产生。
            // Connection.TRANSACTION_REPEATABLE_READ (mysql default) // 事务保证能够再次读取相同的数据而不会失败，但虚读仍然会出现。
            // Connection.TRANSACTION_SERIALIZABLE // 最高的事务级别，它防止脏读、不可重复的读和虚读。


            String sql = "update user set username=?, password=? where id=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "new one");
            statement.setString(2, "123456");
            statement.setInt(3, 4);
            int res = statement.executeUpdate();
            Utils.printMsg(res);

            // 提交后成功
            connection.commit();


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);

            // 提交失败
            try {
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println(e1);
            }

        } finally {
            Utils.close(null, statement, connection);
        }
    }

    @Test
    public void testQuery() {
        Connection connection = Utils.getConnection();

        String sql = "select * from user";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet res = statement.executeQuery();
            Utils.printMsg(res);

            Utils.close(null, statement, connection);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}

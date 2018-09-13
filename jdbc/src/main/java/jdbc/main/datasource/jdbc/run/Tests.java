package jdbc.main.datasource.jdbc.run;

import jdbc.main.datasource.jdbc.util.MyDataSource;
import jdbc.main.util.Utils;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tests {

    private static String url = Utils.getUrl();
    private static String user = Utils.getUser();
    private static String password = Utils.getPassword();
    private static String driverClassName = Utils.getDriverClassName();


    @Test
    public void run() {
        for (int i = 0; i < 19; i++) {
            loopConn();
            System.out.println(i+":::::---");
        }
    }

    private void loopConn() {
        MyDataSource dataSource = new MyDataSource();
        Connection connection = dataSource.getConnection();

        try {

            PreparedStatement statement = connection.prepareStatement("select * from user");
            ResultSet resultSet = statement.executeQuery();
            Utils.printMsg(resultSet);
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        } finally {
            dataSource.addBack(connection);
        }
    }

    private void executeQuery(Connection connection) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("select * from user");
            ResultSet resultSet = statement.executeQuery();
            Utils.printMsg(resultSet);
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        } finally {
            Utils.close(null, statement, connection);
        }
    }


    @Test
    /**
     * BasicDataSource
     * */
    public void test2() {
        BasicDataSource source = new BasicDataSource();
        source.setDriverClassName(driverClassName);
        source.setUrl(url);
        source.setUsername(user);
        source.setPassword(password);

        try {
            Connection conn = source.getConnection();
            executeQuery(conn);
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }

    }
}

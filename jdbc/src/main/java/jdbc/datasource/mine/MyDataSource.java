package jdbc.datasource.mine;

import jdbc.util.Utils;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MyDataSource implements DataSource {
    private List<Connection> list = new ArrayList<>();

    public MyDataSource() {

        for (int i = 0; i < 10; i++) {
            Connection conn = Utils.getConnection();
            list.add(conn);
        }
    }

    public void addBack(Connection connection) {
        list.add(connection);
    }

    @Override
    public Connection getConnection() {
        Connection connection = list.remove(0);


        return connection;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}

class Tests {

    private void run() {
        for (int i = 0; i < 19; i++) {
            loopConn();
            System.out.println(i+":::::---");
        }
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Tests.class.newInstance().run();
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
}

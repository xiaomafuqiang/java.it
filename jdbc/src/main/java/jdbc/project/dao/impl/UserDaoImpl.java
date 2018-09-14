package jdbc.project.dao.impl;

import jdbc.project.dao.UserDao;
import jdbc.util.Utils;
import org.junit.Test;

import java.sql.*;
import java.util.List;
import java.util.Map;

import static jdbc.util.Utils.getResultList;
import static jdbc.util.Utils.printMsg;

public class UserDaoImpl implements UserDao {
    // 1, 获取连接对象
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    private void close() {
        Utils.close(resultSet, statement, connection);
    }

    @Override
    public void findAll() {

        try {
            connection = Utils.getConnection();

            // 2, 创建statement
            statement = connection.createStatement();

            // Sql
            String sql = "select * from user";
            resultSet = statement.executeQuery(sql);

            printMsg(resultSet);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    @Override
    public void login(String name, String password) {
        try {
            connection = Utils.getConnection();
            statement = connection.createStatement();

            String sql = "select count(*) as `count` from user where username='" + name + "' and password='" + password + "'";
            resultSet = statement.executeQuery(sql);
            List<Map<Object, Object>> list = getResultList(resultSet);
            System.out.println(list.get(0).get("count"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           close();
        }
    }

    @Override
    public void loginPrepared(String name, String password) {
        try {
            connection = Utils.getConnection();

            String sql = "select count(*) as `count` from user where username=? and password=?";
            statement = connection.prepareStatement(sql);
            PreparedStatement preparedStatement = (PreparedStatement) statement;

            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();

            List<Map<Object, Object>> list = getResultList(resultSet);
            System.out.println(list.get(0).get("count"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           close();
        }
    }


    @Override
    public void insert(String name, String password) {
        connection = Utils.getConnection();

        String sql = "insert into user values(null , ?, ?)";

        try {
            statement = connection.prepareStatement(sql);
            PreparedStatement preparedStatement = ((PreparedStatement) statement);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            int res = preparedStatement.executeUpdate();
            printMsg(res);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    @Override
    public void delete(int id) {
        connection = Utils.getConnection();

        String sql = "delete from user where id=?";

        try {
            statement = connection.prepareStatement(sql);
            PreparedStatement preparedStatement = ((PreparedStatement) statement);
            preparedStatement.setInt(1, id);

            int res = preparedStatement.executeUpdate();
            printMsg(res);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    @Override
    public void update(String newName, String newPassword, int whichId) {
        connection = Utils.getConnection();
        String sql = "update user set username=?,password=? where id=?";

        try {
            statement = connection.prepareStatement(sql);
            PreparedStatement preparedStatement = ((PreparedStatement) statement);
            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, newPassword);
            preparedStatement.setInt(3, whichId);

            int res = preparedStatement.executeUpdate();
            printMsg(res);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }

    }

    @Test
    public void run() {
        // findAll();
        // login("lisi", "15");
        // loginPrepared("lisi", "11");
        // insert("wangwang", "13");
        // delete(5);
        update("新名字", "19", 2);
    }
}

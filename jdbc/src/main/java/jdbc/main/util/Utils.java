package jdbc.main.util;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class Utils {
    private static String url;
    private static String user;
    private static String password;
    private static String driverClassName;

    public static String getDriverClassName() {
        return driverClassName;
    }

    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    static {
        Properties properties = new Properties();
        InputStream in = Utils.class.getClassLoader().getResourceAsStream("info.properties");

        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        url = properties.getProperty("url");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        driverClassName = "com.mysql.cj.jdbc.Driver";
    }

    static {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public static void close(
            ResultSet resultSet,
            Statement statement,
            Connection connection
    ) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printMsg(int i) {
        String msg = i > 0 ? "成功" : "失败";
        System.out.println(msg);
    }


    public static void printMsg(ResultSet resultSet) {
        if (resultSet == null) {
            return;
        }

        List<Map<Object, Object>> list = getResultList(resultSet);

        System.out.print("\033[42;33;4m" + "resultSet~>" + "\033[0m");
        System.out.print("  ");
        System.out.print("\033[36;4m" + list + "\033[0m");
        System.out.print("\n\n");

    }


    public static List<Map<Object, Object>> getResultList(ResultSet resultSet) {
        if (resultSet == null) {
            return null;
        }

        List<Map<Object, Object>> list = new ArrayList<>();
        try {
            ResultSetMetaData data = resultSet.getMetaData();
            int count = data.getColumnCount();

            while (resultSet.next()) {
                Map<Object, Object> map = new LinkedHashMap<>();
                for (int i = 1; i <= count; i++) {
                    String name = data.getColumnName(i);
                    Object value = resultSet.getObject(i);
                    map.put(name, value);
                }
                list.add(map);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }



    /**
     * play
     * */
    @Test
    public void colorful() {
        System.out.println("\033[30;4m" + "我滴个颜什" + "\033[0m");
        System.out.println("\033[31;4m" + "我滴个颜什" + "\033[0m");
        System.out.println("\033[32;4m" + "我滴个颜什" + "\033[0m");
        System.out.println("\033[33;4m" + "我滴个颜什" + "\033[0m");
        System.out.println("\033[34;4m" + "我滴个颜什" + "\033[0m");
        System.out.println("\033[35;4m" + "我滴个颜什" + "\033[0m");
        System.out.println("\033[36;4m" + "我滴个颜什" + "\033[0m");
        System.out.println("\033[37;4m" + "我滴个颜什" + "\033[0m");
        System.out.println("\033[40;31;4m" + "我滴个颜什" + "\033[0m");
        System.out.println("\033[41;32;4m" + "我滴个颜什" + "\033[0m");
        System.out.println("\033[42;33;4m" + "我滴个颜什" + "\033[0m");
        System.out.println("\033[43;34;4m" + "我滴个颜什" + "\033[0m");
        System.out.println("\033[44;35;4m" + "我滴个颜什" + "\033[0m");
        System.out.println("\033[45;36;4m" + "我滴个颜什" + "\033[0m");
        System.out.println("\033[46;37;4m" + "我滴个颜什" + "\033[0m");
        System.out.println("\033[47;4m" + "我滴个颜什" + "\033[0m");
    }
}
package net.student.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Utils {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");

    public static DataSource getDataSource (){
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}

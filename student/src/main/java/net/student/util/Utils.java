package net.student.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");

    public static DataSource getDataSource (){
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static Date parseDate(String string) {

        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        Date parse = null;
        try {
            parse = format.parse(string);
        } catch (ParseException e) {
            System.out.println("parse 出错了...");
            e.printStackTrace();
        }

        return parse;
    }
}

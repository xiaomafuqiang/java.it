package net.student.util;

import com.alibaba.fastjson.JSON;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
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

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            parse = format.parse(string);
        } catch (ParseException e) {
            System.out.println("parse 出错了...");
            e.printStackTrace();
        }

        return parse;
    }

    public static <T> T parseRequstBody(BufferedReader reader, Class<T> clazz) throws IOException {

        StringBuilder builder = new StringBuilder();
        String s;
        while ((s = reader.readLine()) != null) {
            builder.append(s);
        }
        System.out.println("JSON BODY:::::" + builder);
        return JSON.parseObject(builder.toString(), clazz);
    }
}

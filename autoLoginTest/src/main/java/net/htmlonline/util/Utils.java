package net.htmlonline.util;

import com.alibaba.fastjson.JSON;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.beanutils.Converter;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static void print(Object... args) {
        for (Object o :
                args) {
            System.out.print(o);
        }
        System.out.println();
    }

    public static DataSource getDataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");

        return dataSource;
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

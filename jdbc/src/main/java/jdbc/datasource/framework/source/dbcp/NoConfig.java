package jdbc.datasource.framework.source.dbcp;

import jdbc.util.Utils;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static jdbc.util.Utils.executeQuery;


public class NoConfig {

    @Test
    public void run() {
        BasicDataSource source = new BasicDataSource();
        source.setDriverClassName(Utils.getDriverClassName());
        source.setUrl(Utils.getUrl());
        source.setUsername(Utils.getUser());
        source.setPassword(Utils.getPassword());

        try {
            Connection conn = source.getConnection();
            executeQuery(conn);
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}

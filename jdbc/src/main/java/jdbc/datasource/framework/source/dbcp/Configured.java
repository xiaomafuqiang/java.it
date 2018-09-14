package jdbc.datasource.framework.source.dbcp;

import jdbc.util.Utils;
import org.apache.tomcat.dbcp.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class Configured {
    private DataSource dataSource;

    @Test
    public void run() throws Exception {
        Properties properties = new Properties();
        // InputStream in = new FileInputStream("target/classes/dbcpconfig.properties");
        InputStream in = getClass().getClassLoader().getResourceAsStream("dbcpconfig.properties");

        properties.load(in);
        dataSource = BasicDataSourceFactory.createDataSource(properties);

        // Connection connection = dataSource
        Connection connection = dataSource.getConnection();

        Utils.executeQuery(connection);

    }
}

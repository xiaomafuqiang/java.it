package jdbc.datasource.framework.source.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static jdbc.util.Utils.executeQuery;

public class Configured {

    @Test
    public void run() throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");
        Connection connection = dataSource.getConnection();

        executeQuery(connection);
    }
}

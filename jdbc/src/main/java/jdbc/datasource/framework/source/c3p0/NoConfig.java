package jdbc.datasource.framework.source.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import jdbc.util.Utils;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import static jdbc.util.Utils.executeQuery;

public class NoConfig {

    @Test
    public void run() throws PropertyVetoException, SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(Utils.getDriverClassName());
        dataSource.setJdbcUrl(Utils.getUrl());
        dataSource.setUser(Utils.getUser());
        dataSource.setPassword(Utils.getPassword());

        Connection connection = dataSource.getConnection();
        executeQuery(connection);
    }
}

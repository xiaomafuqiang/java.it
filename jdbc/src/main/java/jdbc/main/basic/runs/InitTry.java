package jdbc.main.basic.runs;

import jdbc.main.basic.util.Utils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InitTry {
    //


    @Test
    public void run() throws SQLException {
        Connection connection = Utils.getConnection();
        Statement statement = connection.createStatement();

        String sql = "select * from ai";
        ResultSet set = statement.executeQuery(sql);

        System.out.println(set);
        while (set.next()) {
            System.out.println(set.getString(1));
            System.out.println(set.getString(2));
            System.out.println(set.getFetchSize());
        }

        Utils.close(set, statement, connection);
    }
}



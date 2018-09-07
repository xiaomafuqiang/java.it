package jdbc.main.basic;

import jdbc.main.util.Utils;
import org.junit.Test;

import java.sql.*;

import static jdbc.main.util.Utils.printMsg;

public class InitTry {

    @Test
    public void run() throws SQLException {
        Connection connection = Utils.getConnection();
        Statement statement = connection.createStatement();

        String sql = "select * from ai";
        ResultSet set = statement.executeQuery(sql); // query

        System.out.println(set.getRow() + "{}{}{}}");
        System.out.println(set);
        while (set.next()) {
            System.out.println(set.getString(1));
            System.out.println(set.getString(1));
            System.out.println(set.getString(2));
            System.out.println(set.getFetchSize());
        }

        sql = "insert into u values(null, 'xiaowang')";
        printMsg(statement.executeUpdate(sql));

        sql = "delete from u where name='xiaoma'";
        printMsg(statement.executeUpdate(sql));

        sql  = "alter table u modify name varchar (255)";
        int i = statement.executeUpdate(sql);
        System.out.println(i);

        Utils.close(set, statement, connection);
    }

}



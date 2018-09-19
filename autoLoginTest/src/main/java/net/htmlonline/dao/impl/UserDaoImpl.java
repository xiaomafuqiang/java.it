package net.htmlonline.dao.impl;

import net.htmlonline.dao.UserDao;
import net.htmlonline.domain.UserBean;
import net.htmlonline.util.Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    QueryRunner runer = new QueryRunner(Utils.getDataSource());

    @Override
    public UserBean login(UserBean userBean) throws SQLException {
        String sql = "select * from user where username=? and password=?";
        UserBean query = runer.query(sql, new BeanHandler<>(UserBean.class), userBean.getUsername(), userBean.getPassword());

        return query;
    }
}

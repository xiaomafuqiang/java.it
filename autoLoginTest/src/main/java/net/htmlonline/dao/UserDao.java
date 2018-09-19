package net.htmlonline.dao;

import net.htmlonline.domain.UserBean;

import java.sql.SQLException;

public interface UserDao {
    UserBean login(UserBean userBean) throws SQLException;
}

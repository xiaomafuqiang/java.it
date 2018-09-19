package net.htmlonline.service;

import net.htmlonline.domain.UserBean;

import java.sql.SQLException;

public interface UserService {
    UserBean login(UserBean userBean) throws SQLException;

}

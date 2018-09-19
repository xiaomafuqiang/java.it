package net.htmlonline.service.impl;

import net.htmlonline.dao.impl.UserDaoImpl;
import net.htmlonline.domain.UserBean;
import net.htmlonline.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private static UserDaoImpl userDao = new UserDaoImpl();
    @Override
    public UserBean login(UserBean userBean) throws SQLException {
        return userDao.login(userBean);
    }
}

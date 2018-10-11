package net.htmlonline.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service("user")
//@Component("user")
public class UserServiceImpl implements UserService {
    // @Value("中国人")
    private String name;

    // @Autowired
    // @Qualifier(value = "userDao")
    @Resource(name = "userDao")
    private UserDaoImpl userDao;

    @PostConstruct
    public void init() {
        System.out.println("userService init...");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("userService destroy...");
    }



    public UserDaoImpl getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public String getName() {
        return name;
    }

    @Value("中国人")
    public void setName(String name) {
        System.out.println(name);
        this.name = name;
    }

    @Override
    public void save() {
        System.out.println("CgDomain saved");
        userDao.save();
    }


}

package net.htmlonline.actions.data.encapsulation;

import com.opensymphony.xwork2.ActionSupport;
import net.htmlonline.domain.User;

import java.util.List;
import java.util.Map;

// 数据封装
public class UserActionPreparedMap extends ActionSupport {

    // 提供User对象
    // 页面上写 user.name user.age;
    private Map<String, User> users;

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    @Override
    public String execute() throws Exception {

        System.out.println(users);
        return NONE;
    }
}

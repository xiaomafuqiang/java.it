package net.htmlonline.actions.data.encapsulation;

import com.opensymphony.xwork2.ActionSupport;
import net.htmlonline.domain.User;

import java.util.List;

// 数据封装
public class UserActionPreparedList extends ActionSupport {

    // 提供User对象
    // 页面上写 user.name user.age;
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String execute() throws Exception {

        System.out.println(users);
        return NONE;
    }
}

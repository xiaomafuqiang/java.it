package net.htmlonline.actions.data.encapsulation;

import com.opensymphony.xwork2.ActionSupport;
import net.htmlonline.domain.User;

// 数据封装
public class UserActionPrepared2 extends ActionSupport {

    // 提供User对象
    // 页面上写 user.name user.age;
    private User user;
    // setter getter

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String execute() throws Exception {

        System.out.println(user);
        return NONE;
    }
}

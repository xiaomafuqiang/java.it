package net.htmlonline.actions.data.encapsulation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.htmlonline.domain.User;

// 数据封装
public class UserActionPrepared3 extends ActionSupport implements ModelDriven<User> {

    // 提供User对象
    private User user = new User();

    @Override
    // 接口方法获取 user
    // 与 二相比 每次只能改变一个model
    public User getModel() {
        return user;
    }

    @Override
    public String execute() throws Exception {

        System.out.println(user);
        return NONE;
    }

}

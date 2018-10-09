package net.htmlonline.actions.data.encapsulation;

import com.opensymphony.xwork2.ActionSupport;

// 数据封装
public class UserActionPrepared1 extends ActionSupport {
    // 私有字段在表单 name
    // 提供getter setter
    // 直接可以获取封装后值
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String execute() throws Exception {

        // 自动根据传来参数封装 调用 setter
        // 再根据数据自定义
        // 不常用
        System.out.println(age);
        System.out.println(name);
        return NONE;
    }
}

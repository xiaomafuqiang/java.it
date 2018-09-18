package net.htmlonlnie.listeners.attrbiute.active.session.example;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

@WebListener
public class SessionActiveExampleBean implements Serializable, HttpSessionActivationListener {
    private static final long serialVersionUID = -8367567842003252055L;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println(this + "保存到硬盘了...");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println(this + "从硬盘读取并活化了...");
    }

    @Override
    public String toString() {
        return "SessionActiveExampleBean [name=" + name + "]---"+super.toString();
    }

}

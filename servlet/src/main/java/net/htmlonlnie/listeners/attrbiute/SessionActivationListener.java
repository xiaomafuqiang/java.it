package net.htmlonlnie.listeners.attrbiute;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

// @WebListener
public class SessionActivationListener implements HttpSessionActivationListener {
    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("session 钝化了...");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("session 活化了...");
    }
}

package net.htmlonlnie.listeners.context;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

// @WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("初始化了...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("销毁了...");
    }
}

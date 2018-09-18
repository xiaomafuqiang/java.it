package net.htmlonlnie.listeners.context;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

// @WebListener
public class RequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("every request event... destroyed...");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("every request event... initialized...");
    }
}

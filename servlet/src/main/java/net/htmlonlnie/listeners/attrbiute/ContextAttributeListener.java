package net.htmlonlnie.listeners.attrbiute;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

// @WebListener
public class ContextAttributeListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        // session.setAttribute("a", "new value");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        // session.removeAttribute("a", "new value");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        // session.setAttribute("a", "another new value");
    }
}

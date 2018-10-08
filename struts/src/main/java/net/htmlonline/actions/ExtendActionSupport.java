package net.htmlonline.actions;

import com.opensymphony.xwork2.ActionSupport;

public class ExtendActionSupport extends ActionSupport {
    @Override
    public String execute() throws Exception {
        System.out.println("action support");
        return null;
    }
}

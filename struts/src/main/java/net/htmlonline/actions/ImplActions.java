package net.htmlonline.actions;

import com.opensymphony.xwork2.Action;

public class ImplActions implements Action {
    @Override
    public String execute() throws Exception {
        System.out.println("impl action called...");
        return null;
    }
}

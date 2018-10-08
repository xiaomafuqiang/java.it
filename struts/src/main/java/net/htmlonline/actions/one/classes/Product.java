package net.htmlonline.actions.one.classes;

import com.opensymphony.xwork2.ActionSupport;

/* 通配符 */
public class Product extends ActionSupport {

    public String execute() {

        System.out.println("default actions... ");
        return NONE;
    }


    public String find() {

        System.out.println("find actions... ");
        return NONE;
    }
    public String update() {

        System.out.println("update actions... ");
        return NONE;
    }
    public String delete() {

        System.out.println("delete actions... ");
        return NONE;
    }
    public String save() {

        System.out.println("save actions... ");
        return NONE;
    }

}

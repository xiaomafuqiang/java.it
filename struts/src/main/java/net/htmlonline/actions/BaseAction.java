package net.htmlonline.actions;

public class BaseAction {

    public String execute() {

        System.out.println("default actions... ");
        return "success";
    }


    public String find() {

        System.out.println("find actions... ");
        return "find";
    }
    public String update() {

        System.out.println("update actions... ");
        return "update";
    }
    public String delete() {

        System.out.println("delete actions... ");
        return "delete";
    }
    public String save() {

        System.out.println("save actions... ");
        return "save";
    }


}

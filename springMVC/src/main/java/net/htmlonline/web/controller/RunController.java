package net.htmlonline.web.controller;

import net.htmlonline.domain.User;
import net.htmlonline.domain.UserListForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class RunController {

    @RequestMapping("/")
    public String hello() {
        System.out.println("first template");

        return "tpl";
    }

    @RequestMapping("/items")
    public ModelAndView model(){
        ModelAndView view = new ModelAndView();


        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        view.addObject("items", list);

        view.setViewName("items");

        return view;

    }


    public final String objPath = "/obj";
    @RequestMapping(objPath)
    @ResponseBody
    public String obj(@RequestParam Map<String, String> obj){

        System.out.println(obj);

        return "hello";
    }


    @RequestMapping("/list")
    @ResponseBody
    public String test(ArrayList<String> list) {
        System.out.println(list);

        return "list";
    }

    @RequestMapping("/list2")
    @ResponseBody
    public String test2(UserListForm userForm) {
        for (User user : userForm.getUsers()) {
            System.out.println(user.getFirstName() + " - " + user.getLastName());
        }

        return "list";
    }


    @RequestMapping(value = "/list2", method = RequestMethod.GET)
    @ResponseBody
    public String testMapping(UserListForm userForm) {
        for (User user : userForm.getUsers()) {
            System.out.println(user.getFirstName() + " - " + user.getLastName());
        }

        return "list";
    }
}

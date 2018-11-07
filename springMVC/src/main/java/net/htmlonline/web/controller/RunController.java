package net.htmlonline.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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


    @RequestMapping("/obj")
    @ResponseBody
    public String obj(Map<String, String> obj){

        System.out.println(obj);

        return "hello";
    }
}

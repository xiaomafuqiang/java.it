package net.htmlonline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class C {

    @RequestMapping("/")
    public String hello() {
        System.out.println("hello world");

        return "in";
    }
}

package net.htmlonline.web.controller;

import net.htmlonline.dao.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PackageImported {

    @Autowired
    AccountMapper accountMapper;

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        System.out.println(accountMapper.selectAccount(16));

        return "[1, 2, 3, 4]";
    }
}

package net.htmlonline.web.controller;

import com.alibaba.fastjson.JSON;
import net.htmlonline.dao.AccountMapper;
import net.htmlonline.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PackageImported {

    @Autowired
    AccountMapper accountMapper;

    @RequestMapping("/")
    @ResponseBody
    public String home(@RequestParam(required = false, defaultValue = "1") Integer id) {
        Account account = accountMapper.selectAccount(id);
        System.out.println(account);

        return "aaa(" + JSON.toJSONString(account) + ")";
    }
}

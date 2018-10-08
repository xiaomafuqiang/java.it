package net.htmlonline.web.action;

import com.alibaba.fastjson.JSONArray;
import com.mysql.cj.xdevapi.JsonArray;
import com.opensymphony.xwork2.ActionSupport;
import net.htmlonline.domain.Customer;
import net.htmlonline.service.CustomerService;
import net.htmlonline.service.impl.CustomerServiceImpl;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CustomerAction extends ActionSupport {

    public String execute() throws Exception {
        System.out.println("execute...");
        return NONE;
    }

    public void find() throws IOException {
        System.out.println("find...");
        CustomerService customerService = new CustomerServiceImpl();
        List<Customer> customers = customerService.find();
        System.out.println(customers);

        String s = JSONArray.toJSONString(customers);
        System.out.println(s);
        PrintWriter writer = ServletActionContext.getResponse().getWriter();
        writer.write(s);

    }
}

package net.htmlonline.bean.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import static net.htmlonline.util.Utils.print;

@WebServlet("/test")
public class BeanServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String characterEncoding = req.getCharacterEncoding();
        print(characterEncoding, "characterEncoding...");

        ABean testBean = new ABean();

        try {
            // 注册转换规则
            ConvertUtils.register(new DateConvert(), Date.class);

            BeanUtils.populate(testBean, req.getParameterMap());
            print(testBean);

        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}


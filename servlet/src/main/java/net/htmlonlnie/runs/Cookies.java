package net.htmlonlnie.runs;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static net.htmlonlnie.util.Utils.getCookieByName;
import static net.htmlonlnie.util.Utils.isSetByName;

@WebServlet("/cookie")
public class Cookies extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        DateFormat dateFormat = new SimpleDateFormat("YYYY年MM月DD日hh时mm分ss秒");

        Cookie times = getCookieByName("times", req.getCookies());
        if (times != null) {
            String t = "";
            t = times.getValue();
            System.out.println(t);
            try {
                Date parse = dateFormat.parse(t);
                System.out.println(parse);

                resp.getWriter().println("欢迎回来,你的时间>" + parse.getHours() + ":" + parse.getMinutes() + ":" + parse.getSeconds());
            } catch (ParseException e) {
                System.out.println(e);
            }
        } else {
            String format = dateFormat.format(new Date());
            System.out.println(format);

            times = new Cookie("times", format);
            times.setMaxAge(20 * 60 * 1000);
            resp.addCookie(times);
            resp.getWriter().println("已经记录");
        }


    }


    private void basic(HttpServletRequest req, HttpServletResponse resp) {
        boolean isSetCookie = isSetByName("wo", req.getCookies());

        if (!isSetCookie) {
            System.out.println("setting...");
            resp.addCookie(new Cookie("woo", "woo"));
        }
        Cookie cookie = new Cookie("some", "some");
        System.out.println(cookie);
    }
}

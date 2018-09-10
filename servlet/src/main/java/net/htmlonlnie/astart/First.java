package net.htmlonlnie.astart;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(value = "/a", loadOnStartup = 2, initParams = {
        @WebInitParam(name = "bb", value = "bbvalue"),
        @WebInitParam(name = "aa", value = "aavalue"),
        @WebInitParam(name = "op", value = "op")
})
public class First extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int i = getServletConfig().getServletContext().hashCode();
        int j = getServletContext().hashCode();
        int k = req.getServletContext().hashCode();
        System.out.println(i + "--" + j + "--" + k);

        ServletConfig config = getServletConfig();
        String s = config.getInitParameter("op");
        System.out.println(s);
        Enumeration<String> strings = config.getInitParameterNames();
        while (strings.hasMoreElements()) {
            System.out.println(strings.nextElement());
        }


        PrintWriter pr = resp.getWriter();
        pr.println("this is first...");
        System.out.println(getServletConfig());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

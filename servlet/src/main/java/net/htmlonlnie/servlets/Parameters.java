package net.htmlonlnie.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;
import java.util.Enumeration;

@WebServlet(value = "/para", initParams = {
        @WebInitParam(name = "a", value = "a-")
})
public class Parameters extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        downloading(resp);

    }

    private void downloading(HttpServletResponse resp) throws IOException {
        resp.setHeader("content-disposition", "attachment;filename=2.jpg");
        ServletContext context = getServletContext();

        // 下面相等getRealPath 根据项目写的目录得到部署目录
        String path = context.getRealPath("/") + "1.jpg";
        String path2 = context.getRealPath("/1.jpg");
        System.out.println(path.equals(path2));

        InputStream in = new FileInputStream(path);
        OutputStream out = resp.getOutputStream();

        byte[] bytes = new byte[1024];
        int len;
        while ((len = in.read(bytes)) != -1) {
            out.write(bytes, 0, len);
        }
        out.flush();
        out.close();
    }
    private void downloading2(HttpServletResponse resp) throws IOException {
        resp.setHeader("content-disposition", "attachment;filename=2.jpg");
        ServletContext context = getServletContext();
        InputStream in = context.getResourceAsStream("1.jpg");
        OutputStream out = resp.getOutputStream();

        byte[] bytes = new byte[1024];
        int len;
        while ((len = in.read(bytes)) != -1) {
            out.write(bytes, 0, len);
        }
        out.flush();
        out.close();
    }

    private void downloading3(HttpServletResponse resp) throws IOException {
        resp.setHeader("content-disposition", "attachment;filename=1.jpg");
        InputStream in = getClass().getClassLoader().getResourceAsStream("1.jpg");
        OutputStream out = resp.getOutputStream();

        byte[] bytes = new byte[1024];
        int len;
        while ((len = in.read(bytes)) != -1) {
            out.write(bytes, 0, len);
        }
        out.flush();
        out.close();
    }

    private void getParas(HttpServletRequest req) {
        Enumeration<String> enumeration = req.getParameterNames();
        while (enumeration.hasMoreElements()) {

            String key = enumeration.nextElement();
            String value = req.getParameter(key);
            System.out.println("get para single" + value);

            String[] strings = req.getParameterValues(key);
            System.out.println("strings + " + Arrays.toString(strings));
        }
    }

    private void redirect(HttpServletResponse resp) {
        resp.setStatus(302);
        resp.setHeader("location", "views/v.html");
    }
}

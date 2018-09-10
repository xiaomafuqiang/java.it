package net.htmlonlnie.runs;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

// file info

// /main/resources/config.properties
@WebServlet("/filepath")
public class ReadFileInProject extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // contextReadPath();
        classLoaderPath();

    }

    // path: / <-
    // -- WEB-INF
    // -- META-INF
    private void contextReadPath() throws IOException {
        ServletContext ctx = getServletContext();
        InputStream in = ctx.getResourceAsStream("WEB-INF/classes/config.properties");
        System.out.println(in.read());
    }


    // path: /WEB-INF/classes <-
    private void classLoaderPath() throws IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream("config.properties");
        System.out.println(in.read());
    }
}

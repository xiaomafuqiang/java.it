package main.net.blogs;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpBrowser {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);

        Socket s = ss.accept();

        // out
        PrintWriter writer = new PrintWriter(s.getOutputStream(), true);
        PrintWriter out = writer;
        writer.println("http/1.1 200 ok");
        writer.println("content-type: text/html;charset=utf-8");
        writer.println("");
        writer.println("<a href=''>text</a>");
        // out.println("HTTP/1.1 200 OK");
        // out.println("Content-Type: text/html;charset=ISO-8859-1");
        // out.println("");
        // out.println("<html><body><font color='red'>hello china</font></body></html>");

        s.close();
    }
}

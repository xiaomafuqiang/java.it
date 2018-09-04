package main.net.blogs;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpBrowser {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        while (true) {
            loopSocket(ss);
        }
    }

    private static void loopSocket(ServerSocket ss) throws IOException {
        Socket s = ss.accept();

        // read
        InputStream in = s.getInputStream();
        // BufferedReader br = new BufferedReader(new InputStreamReader(in));

        System.out.println(s);

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

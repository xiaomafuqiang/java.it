package main.net;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpTests {
    @Test
    public void c() throws IOException {
        Socket s = new Socket(InetAddress.getByName("mark"), 10086);

        // 客户发送内容
        OutputStream stream = s.getOutputStream();
        stream.write("hello client ".getBytes());

        // 客户接受返回内容
        InputStream inputStream = s.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        String res = new String(bytes, 0, len);
        System.out.println("resend::" + res);


        stream.close();
        inputStream.close();
        s.close();
    }

    @Test
    public void s() throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        Socket s;
        while ((s = ss.accept()) != null) {
            // s = ss.accept();

            System.out.println(s.getInetAddress().getHostAddress());

            // 服务获取内容
            InputStream stream = s.getInputStream();
            byte[] bytes = new byte[1024];
            int len = stream.read(bytes);
            String str = new String(bytes, 0, len);
            System.out.println("read::" + str);

            // 服务返回内容
            String upCase = str.toUpperCase();
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            out.println("HTTP/1.1 200 OK"); // ## 浏览器需要获得返回 http 请求头否则认为链接不成功 =================××××××××××××××××××××××××××××××××××××××××××××××
            // out.println("Content-Type: text/html;charset=ISO-8859-1");
            out.println(""); // ## 重要=================××××××××××××××××××××××××××××××××××××××××××××××
            out.println("hello from java socket>");
            // out.flush();

            // out.println("Content-Type: text/html;charset=ISO-8859-1");
            // out.println("");
            // out.println("<html><body><font color='red'>hello china</font></body></html>");

            // stream.close();
            // printWriter.close();
            // close
            s.close();
            // ss.close();
        }
    }

    @Test
    // from blog 量浏览器需要获得返回 http 请求头， 否则认为链接不成功
    // println("")
    public void tomcat() throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        Socket s;
        PrintWriter out;

        while ((s = ss.accept()) != null) {

            InputStream in = s.getInputStream();
            byte[] buf = new byte[1024];
            int len = 0;
            len = in.read(buf);
            String msg = new String(buf, 0, len);
            System.out.println(msg);

            out = new PrintWriter(s.getOutputStream(),true);
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html;charset=ISO-8859-1");
            out.println("");
            out.println("<html><body><font color='red'>hello china</font></body></html>");
            System.out.println("ssssss");
            s.close();
        }

    }
}

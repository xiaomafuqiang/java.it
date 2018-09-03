package main.net;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSocket {
    @Test
    public void client() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("mark"), 10086);
        OutputStream stream = socket.getOutputStream();
        String str = "from tcp coming...";
        stream.write(str.getBytes());
        stream.close();
        socket.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(10086);
        Socket socket = serverSocket.accept();
        InputStream stream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = stream.read(bytes);
        System.out.println(new String(bytes, 0, len));

        stream.close();
        socket.close();
        serverSocket.close();
    }
}

package main.net;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

public class UDPSocket {
    @Test
    public void client() throws IOException {
        DatagramSocket socket = new DatagramSocket(); // 创建数据包socket send(datagramPacket:) close

        String msg = "hello from socket...";
        byte[] bytes = msg.getBytes();
        int len = bytes.length;
        InetAddress address = InetAddress.getByName("mark");
        int port = 8888;

        DatagramPacket dp = new DatagramPacket(bytes, len, address, port);

        socket.send(dp);
        socket.close();
    }

    @Test
    public void server() throws IOException {
        DatagramSocket socket = new DatagramSocket(8888); // socket receive(datagramPacket) {datagramPacket: getData, length}   close
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        while (true) {
            socket.receive(dp);

            byte[] data = dp.getData();
            int len = dp.getLength();

            System.out.println(new String(data, 0, len));
            // socket.close();
        }
    }
}

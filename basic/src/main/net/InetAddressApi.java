package main.net;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressApi {
    @Test
    public void run() throws UnknownHostException {

        // InetAddress address = InetAddress.getByName("mark"); // 通过 name

        InetAddress address = InetAddress.getByName("127.0.0.1"); // 通过 ip

        System.out.println(address);

    }
}

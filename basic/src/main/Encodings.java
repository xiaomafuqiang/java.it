package main;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

// todo all
public class Encodings {
    private String path = "/home/mark/test/";
    @Test
    public void encode() throws FileNotFoundException, UnsupportedEncodingException {
        FileReader f = new FileReader(path + "y");
        System.out.println(f.getEncoding());

        String param = new String("我是小马".getBytes(), StandardCharsets.ISO_8859_1);
        System.out.println(param);

        String name=java.net.URLEncoder.encode(param, StandardCharsets.UTF_8);
        System.out.println(name);
        name=java.net.URLEncoder.encode(name, StandardCharsets.UTF_8);
        System.out.println(name);
        name=java.net.URLDecoder.decode(name, StandardCharsets.UTF_8);
        System.out.println(name);
        name=java.net.URLDecoder.decode(name, StandardCharsets.UTF_8);
        System.out.println(name);
    }
}
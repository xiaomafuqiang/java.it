package main;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

// todo all
public class Encodings {
    private String path = "/home/mark/test/";
    @Test
    public void encode() throws FileNotFoundException {
        FileReader f = new FileReader(path + "y");
        System.out.println(f.getEncoding());
    }
}
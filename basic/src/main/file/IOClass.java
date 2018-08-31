package main.file;

import org.junit.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Arrays;

public class IOClass {
    String path = "/home/mark/test/";
    @Test
    public void copy() throws IOException {
        FileReader fr = new FileReader(path + "y");
        FileWriter fw = new FileWriter(path + "yy");

        // int ch;
        // while ((ch = fr.read()) != -1) {
        //     System.out.println(((char) ch));
        //     fw.write(ch);
        // }

        // int len; // 读取长度
        // char[] chars = new char[1024]; //读取内容缓冲
        // while ((len = fr.read(chars)) != -1) {
        //     fw.write(chars, 0, len);
        // }

        fw.close();
        fr.close();
    }

    @Test
    public void steamCopy() throws IOException {
        FileInputStream fi = new FileInputStream(path + "1.jpg");
        FileOutputStream fo = new FileOutputStream(path + "copy1.jpg");

        int len;
        byte[] bytes = new byte[1024];
        while ((len = fi.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
            fo.write(bytes, 0, len);
        }
        fo.close();
        fi.close();
    }


    @Test
    public void outWriter() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path + "y"));
        // OutputStream out = System.out; // writer(byte[])
        // Writer out = new OutputStreamWriter(System.out); // 字符输入 writer(char[])
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out)); // newLine api


        String line;
        System.out.println("[[["+System.getProperty("line.separator")+"]]]");
        while ((line = br.readLine()) != null) {
            out.write(line);
            out.write(System.getProperty("line.separator"));
            // out.newLine(); // 高效输出换行
        }

        out.close();
        br.close();
    }

    @Test
    public void sysIn() throws IOException{
        InputStream in = System.in;
        Reader reader = new InputStreamReader(in);

        FileWriter fw = new FileWriter(path + "in.txt");

        char[] chars = new char[1024];
        int len;
        while ((len = reader.read(chars)) != -1) {
            fw.write(chars, 0, len);
            fw.flush();
        }

        fw.close();
        reader.close();

    }

    @Test
    public void printStream() throws IOException {
        // PrintWriter printWriter = new PrintWriter(path + "print.txt");
        PrintWriter printWriter = new PrintWriter(new FileWriter(path + "print.txt"), true);
        // println autoRefresh();
        printWriter.println("{66}");

        // printWriter.close();

        BufferedReader br = new BufferedReader(new FileReader(new File(path + "print.txt")));

        String line;
        int lineNo = 0;
        while (true) {
            line = br.readLine();
            if (line == null) {
                break;
            }
            lineNo++;
            if(lineNo <= 16)
                printWriter.println(line + "+"); // 死循环

            System.out.println(line + ":line");
        }
        br.close();
    }
}

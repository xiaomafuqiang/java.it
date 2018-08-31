package main.file;

import main.data.Student;
import main.data.StudentList;
import org.junit.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

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

    @Test
    public void objectOutstream() throws IOException {
        FileOutputStream fos = new FileOutputStream(path + "obj");
        ObjectOutputStream ois = new ObjectOutputStream(fos);

        // 创建序列化多个对象 不好遍历
        Student student1 = new Student("a", 1);
        Student student2 = new Student("b", 2);

        // 可以创建一个集合或者一个对象保存
        StudentList studentList = new StudentList(new ArrayList<>());
        studentList.getArrayList().add(student1);
        studentList.getArrayList().add(student2);

        ois.writeObject(studentList);

        ois.close();
    }
    @Test
    public void objectInputStream() throws IOException, ClassNotFoundException {
        // public static final long serialVersionUID = 1L; // 一定写这个， 否则会因为修改对象而读取失败

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path + "obj"));

        // 读取对象
        // Object o = ois.readObject();
        // System.out.println(o);
        // Object o2 = ois.readObject();
        // System.out.println(o2); // 如过eof末尾就抛出异常
        // while (true) {
        //     try {
        //         Object o = ois.readObject();
        //         System.out.println(o);
        //     } catch (EOFException e) {
        //         System.out.println(e);
        //         break;
        //     } catch (NullPointerException e) {
        //         // do with o
        //         System.out.println(0);
        //     }
        // }

        // 读取list方法
        StudentList studentlist = (StudentList)ois.readObject();
        System.out.println((studentlist.getArrayList()));

        ois.close();
    }


    @Test
    public void properties() {
        Properties prop = new Properties();
        prop.put("1", "555");
        prop.put("2", "444");
        String s = prop.getProperty("1");
        System.out.println(s);
        // prop.entrySet();
        // prop.keySet();
    }
}

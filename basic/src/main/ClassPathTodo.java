package main;

import java.io.File;

public class ClassPathTodo {
    /** get file path todo jsp server*/
    public static void main(String[] args) {
        ClassLoader classLoader = ClassPathTodo.class.getClassLoader();
        System.out.println(System.getProperty("user.dir"));
        System.out.println(ClassPathTodo.class.getResource(""));
        System.out.println(ClassPathTodo.class.getResource("/"));
        System.out.println(ClassLoader.getSystemResource(""));
        System.out.println(new File("").getAbsolutePath());
    }

}

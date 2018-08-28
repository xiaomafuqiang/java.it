package main;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println(i);

        long l = scanner.nextLong();
        System.out.println(l);

        Long res = Long.max(l, i);
        System.out.println(res);
    }

    void diff() {
        System.out.println("---->Test1:");
        Scanner scanner = new Scanner(System.in);
        String nextStr = scanner.next();
        System.out.println("scanner.next()得到：" + nextStr);
        String nextlineStr = scanner.nextLine();
        System.out.println("scanner.nextLine()得到：" + nextlineStr);

        System.out.println("\n---->Test2:");
        String nextlineStr2 = scanner.nextLine();
        System.out.println("scanner.nextLine()得到：" + nextlineStr2);
        String nextStr2 = scanner.next();
        System.out.println("scanner.next()得到：" + nextStr2);
    }
}

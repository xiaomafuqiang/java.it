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
}

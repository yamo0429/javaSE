package jdk.api;

import java.util.Scanner;

public class ScannerTest {
    /**
     * Scanner键盘录入(无法用test演示？？？)
     * switch语句基本用法，jdk1.7以后，String、int、enum都可以
     * switch语句调用方法
     */
    public static void main(String[] args) {
        //创建键盘录入数据的对象
        Scanner sc = new Scanner(System.in);

        while (true){
            //接收数据
            System.out.println("请录入一个字符串：");
            String s = sc.nextLine();

            switch (s){
                case "a":
                    System.out.println("aaaa");
                    add();
                    break;
                case "b":
                    System.out.println("bbbb");
                    break;
                case "c":
                    System.out.println("game over");
                    System.exit(1);
                    break;
                default:
                    System.out.println("you see see u...");
            }
        }

    }

    private static void add() {
        System.out.println("a"+"b");
    }

}

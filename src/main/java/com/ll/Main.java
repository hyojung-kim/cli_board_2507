package com.ll;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inStr = "";

        while (true) {
            System.out.print("입력하세요: ");
            try {
                inStr = sc.nextLine();
                if(inStr.equals("종료")){
                    sc.close();
                }
            } catch (InputMismatchException e) {
                System.out.println("입력해주세요.ㅠㅠ");
                sc.nextLine(); // 버퍼 비우기
            }
        }


    }
}

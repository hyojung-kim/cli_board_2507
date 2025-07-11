package com.ll;

import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==게시판 앱==");
        String inStr;
        StringBuilder sb = new StringBuilder();
        while (true) {
            System.out.print("등록해주세요: ");
            try {
                inStr = sc.nextLine();
                if(inStr.equals("종료")){
                    break;
                }
                else {
                    sb.append(inStr);
                    System.out.println("등록되었습니다");
                }
            } catch (InputMismatchException e) {
                System.out.println("오류");
                sc.nextLine(); // 버퍼 비우기
            }
        }
        System.out.println("등록된 문자열은 : " + sb.toString() );


        sc.close();

    }
}

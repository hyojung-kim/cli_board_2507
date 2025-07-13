package com.ll;

import java.util.InputMismatchException;
import java.util.Scanner;

public class app {
    Scanner sc;

    app() {
        Scanner sc = new Scanner(System.in);
    }
    app(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        //
        System.out.println("==게시판 앱==");
        String inStr="등록";
        int i =1;
        StringBuilder sb = new StringBuilder();
        //ArrayList<String> list = new ArrayList<>();
        while (true) {
            try {
                inStr = sc.nextLine().trim();
                if(inStr.equals("종료")){
                    break;
                }
                else if(inStr.equals("등록") ){
                    System.out.print("제목 등록해주세요: ");
                    inStr = sc.nextLine().trim();
                    sb.append(inStr);
                    System.out.print("내용 등록해주세요: ");
                    inStr = sc.nextLine().trim();
                    sb.append(inStr);
                    System.out.println(i + "번 게시물 등록되었습니다");
                    i++;
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


package com.ll;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class app {
    Scanner sc;
    String inStr="";
    Article article;
    List<Article> aclList = new ArrayList<>();

    app() {
        Scanner sc = new Scanner(System.in);
    }
    app(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("==게시판 앱==");
        int aclIdx = 1;

        while (true) {
            try {
                System.out.println("명령을 입력!)");
                inStr = sc.nextLine().trim();

                if(inStr.equals("종료")){
                    break;
                }
                else if(inStr.equals("등록") ){
                    Article article = new Article();
                    article.setId(aclIdx);
                    System.out.print("제목 등록해주세요: ");
                    article.setSubject(sc.nextLine().trim());
                    System.out.print("내용 등록해주세요: ");
                    article.setContent(sc.nextLine().trim());
                    aclList.add(article);
                    System.out.println(aclIdx + "번 게시물 등록되었습니다");
                    aclIdx++;
                }
                else if(inStr.equals("목록") ){
                    System.out.println("번호/제목/내용");
                    System.out.println("------------");
                    for(Article acl : aclList){
                        System.out.printf("%d / %s / %s\n", acl.getId(), acl.getSubject(), acl.getContent());
                    }






                }

            }
            catch (InputMismatchException e) {
                System.out.println("오류");
                sc.nextLine(); // 버퍼 비우기
            }
        }
        //System.out.println("등록된 문자열은 : " + sb.toString() );

        sc.close();

    }

}


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
        int aclIdx = 0;

        while (true) {
            try {
                System.out.println("명령을 입력!)");
                inStr = sc.nextLine().trim();

                if(inStr.equals("종료")){
                    break;
                }
                else if(inStr.equals("등록") ){
                    Article article = new Article();
                    aclIdx++;
                    article.setId(aclIdx);
                    System.out.print("제목 등록해주세요: ");
                    article.setSubject(sc.nextLine().trim());
                    System.out.print("내용 등록해주세요: ");
                    article.setContent(sc.nextLine().trim());
                    aclList.add(article);
                    System.out.println(aclIdx + "번 게시물 등록되었습니다");

                }
                else if(inStr.equals("목록") ){
                    System.out.println("번호/제목/내용");
                    System.out.println("------------");
//                    for(Article acl : aclList){
//                        System.out.printf("%d / %s / %s\n", acl.getId(), acl.getSubject(), acl.getContent());
//                    }
                    for (int i = aclList.size() - 1; i >= 0; i--) {
                        Article article = aclList.get(i);
                        System.out.printf("%d / %s / %s\n", article.getId(), article.getSubject(), article.getContent());
                    }
                }
                else if(inStr.startsWith("수정") ) {
                    String[] commandList = inStr.split("\\?", 2);
                    String[] paramsStr = commandList[1].split("=", 2);

                    String value = paramsStr[1];
                    int idx = Integer.parseInt(value);

                    Article article = _getFindById(idx);
                    if (article == null) {
                        System.out.printf("%d번 게시물은 존재하지 않습니다.\n", idx);
                    } else {
                        System.out.printf("제목(기존) : %s\n", article.getSubject());
                        System.out.print("제목(수정) : ");
                        String modifySubject = sc.nextLine();
                        article.setSubject(modifySubject);

                        System.out.printf("내용(기존) : %s\n", article.getContent());
                        System.out.print("내용(수정) : ");
                        String modifyContent = sc.nextLine();
                        article.setContent(modifyContent);

                        System.out.printf("%d번 게시물이 수정되었습니다.\n", idx);

                    }
                }
                else if (inStr.startsWith("삭제")) {
                    String[] commandList = inStr.split("\\?", 2);
                    String[] paramsStr = commandList[1].split("=", 2);

                    String value = paramsStr[1];
                    int idx = Integer.parseInt(value);
                    Article article = _getFindById(idx);
                    if (article == null) {
                        System.out.printf("%d번 게시물은 존재하지 않습니다.\n", idx);
                    }
                    else {
                        aclList.remove(article);
                        System.out.printf("%d번 게시물이 삭제되었습니다.\n", idx);
                    }
                }
            }
            catch (InputMismatchException e) {
                System.out.println("오류");
                sc.nextLine(); // 버퍼 비우기
            }
        }


        sc.close();

    }

    private Article _getFindById(int idx) {
        for (Article item : aclList) {
            if (item.getId() == idx) {
                return item;
            }
        }
        return null;
    }

}


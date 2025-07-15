package com.ll;

import com.ll.article.ArticleController;
import com.ll.system.SystemController;
import java.util.InputMismatchException;
import java.util.Scanner;

public class app {
    ArticleController articleCnt;
    SystemController sysCnt;

    app() {
        articleCnt = new ArticleController();
        sysCnt = new SystemController();
    }

    public void run() {
        System.out.println("==게시판 앱==");


        while (true) {
            try {
                String inStr;
                System.out.println("명령을 입력!)");
                inStr = Container.getSc().nextLine().trim();

                if(inStr.equals("종료")){
                    sysCnt.exit();
                    break;
                }
                else if(inStr.equals("등록") ){
                    articleCnt.write();

                }
                else if(inStr.equals("목록") ){
                    articleCnt.list();
                }
                else if(inStr.startsWith("수정") ) {
                    articleCnt.modify(inStr);
                }
                else if (inStr.startsWith("삭제")) {
                    articleCnt.delete(inStr);
                }
            }
            catch (InputMismatchException e) {
                System.out.println("오류");
                Container.getSc().nextLine(); // 버퍼 비우기
            }
        }


        Container.getSc().close();

    }



}


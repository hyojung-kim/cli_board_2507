package com.ll;

import com.ll.article.ArticleController;
import com.ll.db.DBConnection;
import com.ll.system.SystemController;

import java.util.InputMismatchException;

public class app {
    ArticleController articleCnt;
    SystemController sysCnt;

    app() {
        DBConnection.DB_NAME = "proj1";
        DBConnection.DB_PORT = 3306;
        DBConnection.DB_USER = "root";
        DBConnection.DB_PASSWORD = "";


        Container.getDBConnection().connect();



        articleCnt = new ArticleController();
        sysCnt = new SystemController();
    }

    public void run() {
        System.out.println("==게시판 앱==");


        while (true) {
            try {
                System.out.println("명령을 입력!)");
                Request request = new Request(Container.getSc().nextLine().trim());
                if(request.getActionCode().equals("종료")){
                    sysCnt.exit();
                    break;
                }
                else if(request.getActionCode().equals("등록") ){
                    articleCnt.write();

                }
                else if(request.getActionCode().equals("목록") ){
                    articleCnt.list();
                }
                else if(request.getActionCode().startsWith("수정") ) {
                    articleCnt.modify(request);
                }
                else if (request.getActionCode().startsWith("삭제")) {
                    articleCnt.delete(request);
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


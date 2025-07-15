package com.ll.article;

import com.ll.Container;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArticleController {
    int aclIdx = 0;

    List<Article> aclList;
    String inStr;
    public ArticleController(){

        aclList = new ArrayList<>();
        inStr = "";
    }

    public void write() {
        Article article = new Article();
        aclIdx++;
        article.setId(aclIdx);
        System.out.print("제목 등록해주세요: ");
        article.setSubject(Container.getSc().nextLine().trim());
        System.out.print("내용 등록해주세요: ");
        article.setContent(Container.getSc().nextLine().trim());
        aclList.add(article);
        System.out.println(aclIdx + "번 게시물 등록되었습니다");
    }

    public void list() {
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

    public void modify(String inStr) {
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
            String modifySubject = Container.getSc().nextLine();
            article.setSubject(modifySubject);

            System.out.printf("내용(기존) : %s\n", article.getContent());
            System.out.print("내용(수정) : ");
            String modifyContent = Container.getSc().nextLine();
            article.setContent(modifyContent);

            System.out.printf("%d번 게시물이 수정되었습니다.\n", idx);

        }
    }

    public void delete(String inStr) {
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

    private Article _getFindById(int idx) {
        for (Article item : aclList) {
            if (item.getId() == idx) {
                return item;
            }
        }
        return null;
    }
}

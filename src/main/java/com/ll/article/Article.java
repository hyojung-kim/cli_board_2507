package com.ll.article;

public class Article {
    private int id;
    private String subject;
    private String content;

    public Article(){

    }

    public Article(int id, String subject, String content) {
        this.id = id;
        this.subject = subject;
        this.content = content;
    }

    public int getId() {
        return this.id;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getContent() {
        return this.content;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setSubject(String Subject){
        this.subject = Subject;
    }
    public void setContent(String Content){
        this.content = Content;
    }


}

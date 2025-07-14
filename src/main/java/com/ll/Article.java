package com.ll;

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

    int getId() {
        return this.id;
    }

    String getSubject() {
        return this.subject;
    }

    String getContent() {
        return this.content;
    }

    void setId(int id){
        this.id = id;
    }
    void setSubject(String Subject){
        this.subject = Subject;
    }
    void setContent(String Content){
        this.content = Content;
    }


}

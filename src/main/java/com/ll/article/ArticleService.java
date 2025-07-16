package com.ll.article;

import java.util.List;

public class ArticleService {
    int lastId = 1;

    ArticleRepository articleRepository;
    public ArticleService() {
        articleRepository = new ArticleRepository();
    }

    public int create(String subject, String content) {
        return articleRepository.create(subject, content);
    }

    public Article getFindById(int id) {
        return articleRepository.FindById(id);
    }

    public int remove(Article article) {
        return articleRepository.remove(article);
    }

    public void modify(Article article, String modifySubject, String modifyContent) {
        articleRepository.modify(article, modifySubject, modifyContent);
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }
}

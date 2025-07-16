package com.ll.article;

import com.ll.Container;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArticleRepository {

    public int create(String subject, String content) {
        String sql = String.format("insert into article set subject='%s', content='%s'", subject, content);
        return Container.getDBConnection().insert(sql);
    }

    public List<Article> findAll() {
        List<Article> articleList = new ArrayList<>();

        List<Map<String, Object>> rows = Container.getDBConnection().selectRows("select * from article");

        for ( Map<String, Object> row : rows ) {
            Article article = new Article(row);

            articleList.add(article);
        }


        return articleList;
    }

    public Article FindById(int id) {
        List<Article> articleList = this.findAll();
        for (Article item :articleList ) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public int remove(Article article) {
        List<Article> articleList = new ArrayList<>();
        String sql = String.format("DELETE FROM article  WHERE id = %d", article.getId());
        return Container.getDBConnection().delete(sql);
    }

    public void modify(Article article, String modifySubject, String modifyContent) {
        article.setSubject(modifySubject);
        article.setContent(modifyContent);
    }
}

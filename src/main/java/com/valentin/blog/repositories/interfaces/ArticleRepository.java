package com.valentin.blog.repositories.interfaces;

import com.valentin.blog.models.Article;

import java.util.List;

public interface ArticleRepository {
    void save(Article article);
    Article findById(long id);
    List<Article> getAll();
}

package com.valentin.blog.repositories.interfaces;

import com.valentin.blog.entities.Article;

import java.util.List;

public interface ArticleRepository<T extends Article> extends EntityRepository<T> {
    List<Article> findByCategory(String category);
}

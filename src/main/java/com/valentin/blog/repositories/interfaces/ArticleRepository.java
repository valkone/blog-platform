package com.valentin.blog.repositories.interfaces;

import com.valentin.blog.models.Article;

import java.util.List;

public interface ArticleRepository extends EntityRepository {
    List<Article> findByCategory(String category);
}

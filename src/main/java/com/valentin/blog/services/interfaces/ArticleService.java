package com.valentin.blog.services.interfaces;

import com.valentin.blog.dtos.ArticleDTO;
import com.valentin.blog.models.Article;

import java.util.List;

public interface ArticleService {
    void save(Article article);
    ArticleDTO findById(long id);
    List<ArticleDTO> getAll();
    void save(List<Article> articles);
}

package com.valentin.blog;

import java.util.List;

public interface ArticleService {
    void save(Article article);

    ArticleDTO findById(long id);

    List<ArticleDTO> getAll();

    void save(List<Article> articles);
}

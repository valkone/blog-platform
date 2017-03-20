package com.valentin.blog;

import java.util.List;

public interface Repository {
    void save(Article article) throws CannotSaveArticleException;

    Article findById(long id);

    List<Article> getAll();
}

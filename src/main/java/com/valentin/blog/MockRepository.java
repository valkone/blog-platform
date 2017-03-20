package com.valentin.blog;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MockRepository implements Repository {
    private List<Article> articles = new ArrayList<>();

    public void save(Article article) {
        if(article == null)
            throw new CannotSaveArticleException();
        articles.add(article);
    }

    public Article findById(long id) {
        List<Article> foundArticles = articles.stream().filter(a -> a.getId() == id).collect(Collectors.toList());
        return foundArticles.size() > 0 ? foundArticles.get(0) : null;
    }

    @Override
    public List<Article> getAll() {
        return articles;
    }
}

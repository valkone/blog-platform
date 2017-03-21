package com.valentin.blog.repositories.mocks;

import com.valentin.blog.exceptions.CannotSaveArticleException;
import com.valentin.blog.models.Article;
import com.valentin.blog.repositories.interfaces.ArticleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MockArticleRepository implements ArticleRepository {
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
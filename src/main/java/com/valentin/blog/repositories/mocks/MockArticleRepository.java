package com.valentin.blog.repositories.mocks;

import com.valentin.blog.models.Article;
import com.valentin.blog.models.Category;
import com.valentin.blog.repositories.interfaces.ArticleRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MockArticleRepository extends MockEntityRepository<Article> implements ArticleRepository<Article> {

    @Override
    public List<Article> findByCategory(String category) {
        return getAll().stream()
                .filter(a -> containsCategory(a.getCategories(), category))
                .collect(Collectors.toList());
    }

    private boolean containsCategory(List<Category> categories, String category) {
        return categories.stream()
                .filter(c -> c.getText().equals(category)).toArray().length > 0;
    }
}

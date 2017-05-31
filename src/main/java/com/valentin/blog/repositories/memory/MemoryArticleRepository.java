package com.valentin.blog.repositories.memory;

import com.valentin.blog.entities.Article;
import com.valentin.blog.entities.Category;
import com.valentin.blog.repositories.interfaces.ArticleRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MemoryArticleRepository extends MemoryEntityRepository<Article> implements ArticleRepository<Article> {

    @Override
    public List<Article> findByCategory(String category) {
        return getAll().stream()
                .filter(a -> containsCategory(a.getCategories(), category))
                .collect(Collectors.toList());
    }

    private boolean containsCategory(List<Category> categories, String category) {
        return categories.stream()
                .filter(c -> c.getText().equals(category))
                .count() > 0;
    }
}

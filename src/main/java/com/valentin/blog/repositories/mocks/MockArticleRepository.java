package com.valentin.blog.repositories.mocks;

import com.valentin.blog.models.Article;
import com.valentin.blog.repositories.interfaces.ArticleRepository;

import java.util.ArrayList;
import java.util.List;

public class MockArticleRepository extends MockEntityRepository implements ArticleRepository {

    @Override
    public List<Article> findByCategory(String category) {
        List<Article> articlesInCategory = new ArrayList<>();
        getAll().forEach(article -> ((Article)article).getCategories().forEach(c -> {
            if(c.getText().equals(category))
                articlesInCategory.add((Article)article);
        }));
        return articlesInCategory;
    }
}

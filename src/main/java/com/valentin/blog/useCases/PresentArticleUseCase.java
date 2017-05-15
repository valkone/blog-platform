package com.valentin.blog.useCases;

import com.valentin.blog.dtos.ArticleDTO;
import com.valentin.blog.entities.Article;
import com.valentin.blog.repositories.interfaces.ArticleRepository;
import com.valentin.blog.utils.Mapper;

import java.util.List;

public class PresentArticleUseCase {
    private ArticleRepository<Article> repository;

    public PresentArticleUseCase(ArticleRepository<Article> repository) {
        this.repository = repository;
    }

    public List<ArticleDTO> findByCategory(String category) {
        List<Article> articlesInCategory = repository.findByCategory(category);
        return Mapper.articlesToDto(articlesInCategory);
    }
}

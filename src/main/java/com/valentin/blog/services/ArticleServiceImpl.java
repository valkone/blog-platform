package com.valentin.blog.services;

import com.valentin.blog.dtos.ArticleDTO;
import com.valentin.blog.models.Article;
import com.valentin.blog.repositories.interfaces.ArticleRepository;
import com.valentin.blog.repositories.mocks.MockArticleRepository;
import com.valentin.blog.services.interfaces.ArticleService;
import com.valentin.blog.utils.ArticleOperations;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository = new MockArticleRepository();

    public void save(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void save(List<Article> articles) {
        for(Article article : articles)
            save(article);
    }

    public ArticleDTO findById(long id) {
        Article article = articleRepository.findById(id);
        return ArticleOperations.articleToDto(article);
    }

    @Override
    public List<ArticleDTO> getAll() {
        return ArticleOperations.articlesToDto(articleRepository.getAll());
    }
}

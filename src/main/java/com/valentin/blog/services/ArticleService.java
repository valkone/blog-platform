package com.valentin.blog.services;

import com.valentin.blog.dtos.ArticleDTO;
import com.valentin.blog.models.Article;
import com.valentin.blog.models.Entity;
import com.valentin.blog.repositories.interfaces.ArticleRepository;
import com.valentin.blog.utils.Mapper;

import java.util.List;

public class ArticleService extends EntityService {
    private ArticleRepository repository;

    public ArticleService(ArticleRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public void save(Entity entity) {
        if(!(entity instanceof Article))
            // TODO: change to custom exception
            throw new RuntimeException("asd");
        super.save(entity);
    }

    @Override
    public void save(List<Entity> entities) {
        for(Entity entity : entities)
            save(entity);
    }

    public List<ArticleDTO> findByCategory(String category) {
        List<Article> articlesInCategory = repository.findByCategory(category);
        return Mapper.articlesToDto(articlesInCategory);
    }
}

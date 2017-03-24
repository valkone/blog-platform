package com.valentin.blog.services;

import com.valentin.blog.dtos.ArticleDTO;
import com.valentin.blog.models.Article;
import com.valentin.blog.models.Category;
import com.valentin.blog.models.Entity;
import com.valentin.blog.repositories.interfaces.EntityRepository;
import com.valentin.blog.services.interfaces.ArticleService;
import com.valentin.blog.utils.Mapper;

import java.util.ArrayList;
import java.util.List;

public class ArticleServiceImpl extends EntityServiceImpl implements ArticleService {

    public ArticleServiceImpl(EntityRepository repository) {
        super(repository);
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

    @Override
    public List<ArticleDTO> findByCategory(String category) {
        List<Entity> articles = getAll();
        List<Article> articlesInCategory = new ArrayList<>();
        for(Entity article : articles) {
            List<Category> cats = ((Article)article).getCategories();
            for(Category cat : cats) {
                if (cat.getText().equals(category))
                    articlesInCategory.add((Article)article);
            }
        }

        return Mapper.articlesToDto(articlesInCategory);
    }
}

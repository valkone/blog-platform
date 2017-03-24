package com.valentin.blog.utils;

import com.valentin.blog.dtos.ArticleDTO;
import com.valentin.blog.dtos.EntityDTO;
import com.valentin.blog.models.Article;
import com.valentin.blog.models.Entity;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

   public static List<EntityDTO> entitiesToDto(List<Entity> entities) {
        List<EntityDTO> list = new ArrayList<>();
        for(Entity e : entities)
            list.add(entityToDto(e));
        return list;
    }

    private static EntityDTO entityToDto(Entity entity) {
        if(entity == null)
            return null;
        EntityDTO dto = new EntityDTO();
        dto.setId(entity.getId());
        return dto;
    }

    public static List<ArticleDTO> articlesToDto(List<Article> articles) {
        List<ArticleDTO> list = new ArrayList<>();
        for(Article a : articles)
            list.add(articleToDto(a));
        return list;
    }

    private static ArticleDTO articleToDto(Article article) {
        if(article == null)
            return null;
        ArticleDTO dto = new ArticleDTO();
        dto.setId(article.getId());
        return dto;
    }

}

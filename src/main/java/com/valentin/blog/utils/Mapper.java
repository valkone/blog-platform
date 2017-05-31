package com.valentin.blog.utils;

import com.valentin.blog.dtos.ArticleDTO;
import com.valentin.blog.entities.Article;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {
    public static List<ArticleDTO> articlesToDto(List<Article> articles) {
        return articles.stream()
                .map(Mapper::articleToDto)
                .collect(Collectors.toList());
    }

    private static ArticleDTO articleToDto(Article article) {
        if(article == null)
            return null;

        ArticleDTO dto = new ArticleDTO();
        dto.setId(article.getId());
        return dto;
    }
}

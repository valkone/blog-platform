package com.valentin.blog.utils;

import com.valentin.blog.dtos.ArticleDTO;
import com.valentin.blog.models.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleOperations {

    public static List<ArticleDTO> articlesToDto(List<Article> articles) {
        List<ArticleDTO> articlesDto = new ArrayList<>();
        for(Article article : articles)
            articlesDto.add(articleToDto(article));
        return articlesDto;
    }

    public static ArticleDTO articleToDto(Article article) {
        if(article == null)
            return null;
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setId(article.getId());
        return articleDTO;
    }
}

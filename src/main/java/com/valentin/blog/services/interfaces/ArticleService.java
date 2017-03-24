package com.valentin.blog.services.interfaces;

import com.valentin.blog.dtos.ArticleDTO;

import java.util.List;

public interface ArticleService extends EntityService {
    List<ArticleDTO> findByCategory(String category);
}

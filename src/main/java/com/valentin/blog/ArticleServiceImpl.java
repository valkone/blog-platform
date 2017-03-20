package com.valentin.blog;

import java.util.ArrayList;
import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    private Repository repository = new MockRepository();

    public void save(Article article) {
        repository.save(article);
    }

    @Override
    public void save(List<Article> articles) {
        for(Article article : articles)
            save(article);
    }

    public ArticleDTO findById(long id) {
        Article article = repository.findById(id);
        return articleToDto(article);
    }

    @Override
    public List<ArticleDTO> getAll() {
        return articlesToDto(repository.getAll());
    }

    private List<ArticleDTO> articlesToDto(List<Article> articles) {
        List<ArticleDTO> articlesDto = new ArrayList<>();
        for(Article article : articles)
            articlesDto.add(articleToDto(article));
        return articlesDto;
    }

    private ArticleDTO articleToDto(Article article) {
        if(article == null)
            return null;
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setId(article.getId());
        return articleDTO;
    }
}

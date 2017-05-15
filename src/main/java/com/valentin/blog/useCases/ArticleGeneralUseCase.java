package com.valentin.blog.useCases;

import com.valentin.blog.entities.Article;
import com.valentin.blog.repositories.interfaces.EntityRepository;

public class ArticleGeneralUseCase extends EntityGeneralUseCase<Article> {

    public ArticleGeneralUseCase(EntityRepository repository) {
        super(repository);
    }
}

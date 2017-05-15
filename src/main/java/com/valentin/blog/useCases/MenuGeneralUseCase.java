package com.valentin.blog.useCases;

import com.valentin.blog.entities.Menu;
import com.valentin.blog.repositories.interfaces.EntityRepository;

public class MenuGeneralUseCase extends EntityGeneralUseCase<Menu> {

    public MenuGeneralUseCase(EntityRepository repository) {
        super(repository);
    }
}

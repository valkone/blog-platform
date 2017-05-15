package com.valentin.blog.useCases;

import com.valentin.blog.entities.Entity;
import com.valentin.blog.repositories.interfaces.EntityRepository;

import java.util.List;

public class EntityGeneralUseCase<T extends Entity> {
    private EntityRepository<T> repository;

    public EntityGeneralUseCase(EntityRepository<T> repository) {
        this.repository = repository;
    }

    public void save(T entity) {
        repository.save(entity);
    }

    public void save(List<T> entities) {
        for(T entity: entities)
            save(entity);
    }

    public T findById(long id) {
        return repository.findById(id);
    }

    public List<T> getAll() {
        return repository.getAll();
    }

}

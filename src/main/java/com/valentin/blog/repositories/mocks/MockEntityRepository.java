package com.valentin.blog.repositories.mocks;

import com.valentin.blog.exceptions.CannotSaveEntityException;
import com.valentin.blog.models.Entity;
import com.valentin.blog.repositories.interfaces.EntityRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MockEntityRepository<T extends Entity> implements EntityRepository<T> {

    private List<T> entities = new ArrayList<>();

    @Override
    public void save(T entity) {
        if(entity == null)
            throw new CannotSaveEntityException();
        entities.add(entity);
    }

    @Override
    public T findById(long id) {
        List<T> foundEntities = entities.stream()
                .filter(a -> a.getId() == id)
                .collect(Collectors.toList());
        return foundEntities.size() > 0 ? foundEntities.get(0) : null;
    }

    @Override
    public List<T> getAll() {
        return entities;
    }
}

package com.valentin.blog.services.interfaces;

import com.valentin.blog.dtos.EntityDTO;
import com.valentin.blog.models.Entity;

import java.util.List;

public interface EntityService {
    void save(Entity entity);
    EntityDTO findById(long id);
    List<EntityDTO> getAll();
    void save(List<Entity> entities);
}

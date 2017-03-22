package com.valentin.blog.utils;

import com.valentin.blog.dtos.EntityDTO;
import com.valentin.blog.models.Entity;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

   public static List<EntityDTO> entitiesToDto(List<Entity> entities) {
        List<EntityDTO> entitiesDto = new ArrayList<>();
        for(Entity entity : entities)
            entitiesDto.add(entityToDto(entity));
        return entitiesDto;
    }

    public static EntityDTO entityToDto(Entity entity) {
        if(entity == null)
            return null;
        EntityDTO entityDTO = new EntityDTO();
        entityDTO.setId(entity.getId());
        return entityDTO;
    }

}

import com.valentin.blog.dtos.EntityDTO;
import com.valentin.blog.exceptions.CannotSaveEntityException;
import com.valentin.blog.models.Entity;
import com.valentin.blog.repositories.mocks.MockEntityRepository;
import com.valentin.blog.services.EntityServiceImpl;
import com.valentin.blog.services.interfaces.EntityService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class EntityTests {

    private EntityService entityService;
    private Entity entity;

    @Before
    public void setUp() {
        // TODO: should this be outside?
        entityService = new EntityServiceImpl(new MockEntityRepository());
        entity = createTestEntity();
    }

    @Test(expected = CannotSaveEntityException.class)
    public void saveNullEntity_shouldThrowException() {
        entityService.save((Entity) null);
    }

    @Test
    public void saveEntity_shouldNotThrowException() {
        entityService.save(entity);
    }

    @Test
    public void saveEntity_shouldBeFound() {
        entityService.save(entity);
        EntityDTO foundEntity = entityService.findById(entity.getId());
        assertEquals(entity.getId(), foundEntity.getId());
    }

    @Test
    // TODO: should the service return null if the entity is not found?
    public void findEntitiesWithInvalidId_shouldReturnNull() {
        EntityDTO entity = entityService.findById(234234);
        assertEquals(null, entity);
    }

    @Test
    public void getAllEntitiesWithoutAdding_shouldReturnEmptyList() {
        List<EntityDTO> entities = entityService.getAll();
        assertEquals(0, entities.size());
    }

    @Test
    public void getAllEntities_countShouldBeEqualsEntitiesCount() {
        int entitiesCount = 4;
        List<Entity> testEntities = getListOfTestEntities(entitiesCount);
        entityService.save(testEntities);

        List<EntityDTO> foundEntities = entityService.getAll();
        assertEquals(entitiesCount, foundEntities.size());
    }

    @Test
    public void getAllEntities_shouldReturnAllEntities() {
        List<Entity> testEntities = getListOfTestEntities(4);
        entityService.save(testEntities);

        List<EntityDTO> foundEntities = entityService.getAll();
        for(Entity testEntity : testEntities)
            assertTrue(entityFoundInDtoList(testEntity, foundEntities));
    }

    @Test
    public void getAllEntities_shouldNotReturnNotSavedEntities() {
        List<Entity> savedTestEntities = getListOfTestEntities(4);
        List<Entity> notSavedTestEntities = getListOfTestEntities(4);
        entityService.save(savedTestEntities);

        List<EntityDTO> foundEntities = entityService.getAll();
        for(Entity testEntities : notSavedTestEntities)
            assertFalse(entityFoundInDtoList(testEntities, foundEntities));
    }

    private boolean entityFoundInDtoList(Entity entity, List<EntityDTO> list) {
        return list
                .stream()
                .filter(l -> l.getId() == entity.getId())
                .collect(Collectors.toList()).size() > 0;
    }

    private List<Entity> getListOfTestEntities(int entitiesCount) {
        List<Entity> entities = new ArrayList<>();
        for(int i = 0; i < entitiesCount; i++)
            entities.add(createTestEntity());
        return entities;
    }

    private Entity createTestEntity() {
        Entity entity = new Entity();
        entity.setId(UUID.randomUUID().getLeastSignificantBits());
        return entity;
    }
}

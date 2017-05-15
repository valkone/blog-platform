import com.valentin.blog.exceptions.CannotSaveEntityException;
import com.valentin.blog.entities.Entity;
import com.valentin.blog.repositories.mocks.MemoryEntityRepository;
import com.valentin.blog.useCases.EntityGeneralUseCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class EntityGeneralUseCaseTests {

    private EntityGeneralUseCase entityGeneralUseCase;
    private Entity entity;

    @Before
    public void setUp() {
        // TODO: should this be outside?
        entityGeneralUseCase = new EntityGeneralUseCase(new MemoryEntityRepository());
        entity = createTestEntity();
    }

    @Test(expected = CannotSaveEntityException.class)
    public void saveNullEntity_shouldThrowException() {
        entityGeneralUseCase.save((Entity) null);
    }

    @Test
    public void saveEntity_shouldNotThrowException() {
        entityGeneralUseCase.save(entity);
    }

    @Test
    public void saveEntity_shouldBeFound() {
        entityGeneralUseCase.save(entity);
        Entity foundEntity = entityGeneralUseCase.findById(entity.getId());
        assertEquals(entity.getId(), foundEntity.getId());
    }

    @Test
    // TODO: should the service return null if the entity is not found?
    public void findEntitiesWithInvalidId_shouldReturnNull() {
        Entity entity = entityGeneralUseCase.findById(234234);
        assertEquals(null, entity);
    }

    @Test
    public void getAllEntitiesWithoutAdding_shouldReturnEmptyList() {
        List<Entity> entities = entityGeneralUseCase.getAll();
        assertEquals(0, entities.size());
    }

    @Test
    public void getAllEntities_countShouldBeEqualsEntitiesCount() {
        int entitiesCount = 4;
        List<Entity> testEntities = getListOfTestEntities(entitiesCount);
        entityGeneralUseCase.save(testEntities);

        List<Entity> foundEntities = entityGeneralUseCase.getAll();
        assertEquals(entitiesCount, foundEntities.size());
    }

    @Test
    public void getAllEntities_shouldReturnAllEntities() {
        List<Entity> testEntities = getListOfTestEntities(4);
        entityGeneralUseCase.save(testEntities);

        List<Entity> foundEntities = entityGeneralUseCase.getAll();
        for(Entity testEntity : testEntities)
            assertTrue(entityFoundInDtoList(testEntity, foundEntities));
    }

    @Test
    public void getAllEntities_shouldNotReturnNotSavedEntities() {
        List<Entity> savedTestEntities = getListOfTestEntities(4);
        List<Entity> notSavedTestEntities = getListOfTestEntities(4);
        entityGeneralUseCase.save(savedTestEntities);

        List<Entity> foundEntities = entityGeneralUseCase.getAll();
        for(Entity testEntities : notSavedTestEntities)
            assertFalse(entityFoundInDtoList(testEntities, foundEntities));
    }

    private boolean entityFoundInDtoList(Entity entity, List<Entity> list) {
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
        return new Entity(UUID.randomUUID().getLeastSignificantBits());
    }
}

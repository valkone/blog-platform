import com.valentin.blog.entities.Menu;
import com.valentin.blog.repositories.mocks.MemoryMenuRepository;
import com.valentin.blog.useCases.MenuGeneralUseCase;
import com.valentin.blog.useCases.PresentMenuUseCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

public class PresentMenuUseCaseTests {

    private PresentMenuUseCase presentMenuUseCase;
    private MenuGeneralUseCase menuGeneralUseCase;

    @Before
    public void init() {
        MemoryMenuRepository repo = new MemoryMenuRepository();
        this.presentMenuUseCase = new PresentMenuUseCase(repo);
        this.menuGeneralUseCase = new MenuGeneralUseCase(repo);
    }

    @Test
    public void getMenu_shouldBeEmpty() {
        List<Menu> menus = this.presentMenuUseCase.getAll();
        Assert.assertTrue(menus.isEmpty());
    }

    @Test
    public void addMenu_sizeShouldBeOne() {
        this.menuGeneralUseCase.save(generateTestMenu());
        List<Menu> menus = this.presentMenuUseCase.getAll();
        Assert.assertTrue(menus.size() == 1);
    }

    private Menu generateTestMenu() {
        return new Menu(UUID.randomUUID().getLeastSignificantBits())
                .setLink("test_page")
                .setName("Test page");
    }
}

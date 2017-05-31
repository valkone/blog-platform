import com.valentin.blog.dtos.ArticleDTO;
import com.valentin.blog.entities.Article;
import com.valentin.blog.entities.Category;
import com.valentin.blog.repositories.memory.MemoryArticleRepository;
import com.valentin.blog.useCases.ArticleGeneralUseCase;
import com.valentin.blog.useCases.PresentArticleUseCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PresentArticleUseCaseTests {

    private MemoryArticleRepository repo = new MemoryArticleRepository();
    private PresentArticleUseCase articleService = new PresentArticleUseCase(repo);
    private ArticleGeneralUseCase entityGeneralUseCase = new ArticleGeneralUseCase(repo);

    @Test
    public void getArticleByCategory_shouldReturnCorrectArticle() {
        Category category = getTestCategory();
        Article article = getTestArticle()
                .setCategory(category);
        entityGeneralUseCase.save(article);

        List<ArticleDTO> foundArticle = articleService.findByCategory(category.getText());
        Assert.assertFalse(foundArticle.isEmpty());
        Assert.assertEquals(article.getId(), foundArticle.get(0).getId());
    }

    private Category getTestCategory() {
        return new Category()
                .setId(UUID.randomUUID().getLeastSignificantBits())
                .setText("category");
    }

    private Article getTestArticle() {
        return new Article(UUID.randomUUID().getLeastSignificantBits())
                .setData(new Date());
    }
}

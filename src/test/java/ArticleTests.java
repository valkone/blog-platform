import com.valentin.blog.dtos.ArticleDTO;
import com.valentin.blog.models.Article;
import com.valentin.blog.models.Category;
import com.valentin.blog.repositories.mocks.MockArticleRepository;
import com.valentin.blog.repositories.mocks.MockEntityRepository;
import com.valentin.blog.services.ArticleService;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ArticleTests {

    private ArticleService articleService = new ArticleService(new MockArticleRepository());

    @Test
    public void getArticleByCategory_shouldReturnCorrectArticle() {
        Category category = getTestCategory();
        Article article = getTestArticle()
                .setCategory(category);
        articleService.save(article);

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
        return new Article()
                .setData(new Date())
                .setId(1);
    }
}

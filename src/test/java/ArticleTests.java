import com.valentin.blog.dtos.ArticleDTO;
import com.valentin.blog.models.Article;
import com.valentin.blog.models.Category;
import com.valentin.blog.repositories.mocks.MockArticleRepository;
import com.valentin.blog.repositories.mocks.MockEntityRepository;
import com.valentin.blog.services.ArticleService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

public class ArticleTests {

    private ArticleService articleService = new ArticleService(new MockArticleRepository());

    @Test
    public void getArticleByCategory_shouldReturnCorrectArticle() {
        Article article = getTestArticle();
        Category c = new Category();
        c.setId(UUID.randomUUID().getLeastSignificantBits());
        c.setText("category");
        article.setCategory(c);
        articleService.save(article);

        List<ArticleDTO> foundArticle = articleService.findByCategory(c.getText());
        Assert.assertEquals(article.getId(), foundArticle.get(0).getId());
    }

    private Article getTestArticle() {
        Article article = new Article();
        article.setId(UUID.randomUUID().getLeastSignificantBits());
        return article;
    }
}

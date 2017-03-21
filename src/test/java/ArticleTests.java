import com.valentin.blog.dtos.ArticleDTO;
import com.valentin.blog.exceptions.CannotSaveArticleException;
import com.valentin.blog.models.Article;
import com.valentin.blog.services.interfaces.ArticleService;
import com.valentin.blog.services.ArticleServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ArticleTests {

    private ArticleService articleService;
    private Article article;

    @Before
    public void setUp() {
        articleService = new ArticleServiceImpl();
        article = createTestArticle();
    }

    @Test(expected = CannotSaveArticleException.class)
    public void saveNullArticle_shouldThrowException() {
        articleService.save((Article) null);
    }

    @Test
    public void saveArticle_shouldNotThrowException() {
        articleService.save(article);
    }

    @Test
    public void saveArticle_shouldBeAbleToBeFound() {
        articleService.save(article);
        ArticleDTO foundArticle = articleService.findById(article.getId());
        assertEquals(article.getId(), foundArticle.getId());
    }

    @Test
    public void findArticlesWithInvalidId_shouldReturnNull() {
        ArticleDTO article = articleService.findById(234234);
        assertEquals(null, article);
    }

    @Test
    public void getAllArticlesWithoutAdding_shouldReturnEmptyList() {
        List<ArticleDTO> articles = articleService.getAll();
        assertEquals(0, articles.size());
    }

    @Test
    public void getAllArticles_countShouldBeEqualsArticlesCount() {
        int articlesCount = 4;
        List<Article> testArticles = getListOfTestArticles(articlesCount);
        articleService.save(testArticles);

        List<ArticleDTO> foundArticles = articleService.getAll();
        assertEquals(articlesCount, foundArticles.size());
    }

    @Test
    public void getAllArticles_shouldReturnAllArticles() {
        List<Article> testArticles = getListOfTestArticles(4);
        articleService.save(testArticles);

        List<ArticleDTO> foundArticles = articleService.getAll();
        for(Article testArticle : testArticles)
            assertTrue(articleFoundInArticleDtoList(testArticle, foundArticles));
    }

    @Test
    public void getAllArticles_shouldNotReturnNotSavedArticles() {
        List<Article> savedTestArticles = getListOfTestArticles(4);
        List<Article> notSavedTestArticles = getListOfTestArticles(4);
        articleService.save(savedTestArticles);

        List<ArticleDTO> foundArticles = articleService.getAll();
        for(Article testArticle : notSavedTestArticles)
            assertFalse(articleFoundInArticleDtoList(testArticle, foundArticles));
    }

    private boolean articleFoundInArticleDtoList(Article article, List<ArticleDTO> list) {
        return list
                .stream()
                .filter(l -> l.getId() == article.getId())
                .collect(Collectors.toList()).size() > 0;
    }

    private List<Article> getListOfTestArticles(int articlesCount) {
        List<Article> articles = new ArrayList<>();
        for(int i = 0; i < articlesCount; i++)
            articles.add(createTestArticle());
        return articles;
    }

    private Article createTestArticle() {
        Article article = new Article();
        article.setId(UUID.randomUUID().getLeastSignificantBits());
        article.setData(new Date());
        article.setText("Article text");
        article.setTitle("Title");
        return article;
    }
}

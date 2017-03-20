import com.valentin.blog.Article;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class ArticleTests {

    @Test
    public void ableToCreateArticle() {
        Article article = new Article();
    }

    @Test
    public void ableToSetDataToArticle() {
        Article article = new Article();
        article.setText("article text");
        article.setTitle("title");
        article.setData(new Date());

    }
}

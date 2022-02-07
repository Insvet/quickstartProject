import io.github.bonigarcia.wdm.WebDriverManager;
import lesson6.MainPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WikiPageObjectTest {
    WebDriver driver;
    private final static String WIKI_URL = "https://ru.wikipedia.org/";

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void initDriver(){
        driver = new ChromeDriver();
        driver.get(WIKI_URL);

    }
    @Test
    void WikiTest(){
        new MainPage(driver)
                .clickSelectedArticles()
                .clickSelectedArticle("Избранные статьи")
                .clickArticle();

    }

}

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class testWiki {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String WIKI_URL = "https://ru.wikipedia.org/";

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void initDriver(){
        driver = new ChromeDriver();
        actions = new Actions(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(WIKI_URL);
    }
    @Test
    void hoverMenuTest() throws InterruptedException {
        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(By.xpath("//a[.='Избранные статьи']"))).click()
                .build()
                .perform();
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://ru.wikipedia.org/wiki/%D0%92%D0%B8%D0%BA%D0%B8%D" +
                "%BF%D0%B5%D0%B4%D0%B8%D1%8F:%D0%98%D0%B7%D0%B1%D1%80%D0%B0%D0%BD%D0%BD%D1%8B%D0%B5_%D1%81%D1%82%D0%B0%D" +
                "1%82%D1%8C%D0%B8"));
    }
    @AfterEach
    void tearDown(){
        driver.quit();
    }
}

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
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(WIKI_URL);
    }
    @Test
    void hoverMenuTest() throws InterruptedException {
        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(By.xpath("//a[.='Случайная статья']"))).click()
                .build()
                .perform();
        Assertions.assertTrue(driver.getCurrentUrl().contains("Обсуждение_участника"));
    }
    @AfterEach
    void tearDown(){
        driver.quit();
    }
}

package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageArticles extends BasePage{
    public PageArticles(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='Озеро']")
    private WebElement article;

    public PageArticles clickArticle(){
        article.click();
        return this;
    }
}

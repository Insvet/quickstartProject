package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='Избранные статьи']")
    private List<WebElement> menu;

    @Step("Клик в меню 'избранные статьи'")
    public PageArticles clickSelectedArticle(String articles){
        menu.stream().filter(f -> f.getText().contains(articles)).findFirst().get().click();
        return new PageArticles(driver);
    }

    public MainPage clickSelectedArticles() {
        return this;
    }
}

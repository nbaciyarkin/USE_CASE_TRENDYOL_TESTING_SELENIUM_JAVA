package trendyol;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBar extends BasePage{

    By searchBoxLocator = new By.ByClassName("search-box");
    By submitButtonLocator = new By.ByCssSelector(".search-icon");


    public SearchBar(WebDriver driver) {
        super(driver);
    }

    public void search(String text) throws InterruptedException {
        type(searchBoxLocator, text);
        Thread.sleep(5000);
        click(submitButtonLocator);
    }

}

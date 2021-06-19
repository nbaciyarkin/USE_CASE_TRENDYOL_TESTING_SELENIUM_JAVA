package trendyol;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage{


    By addToCartButtonLocator = new By.ByCssSelector(".add-to-bs-tx");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }


    public boolean isOnProductDetailPage() throws InterruptedException {
        Thread.sleep(5);
        return isDisplayed(addToCartButtonLocator);
    }


    public void addToCart() throws InterruptedException {
        click(addToCartButtonLocator);
    }

}

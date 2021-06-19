package trendyol;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {


    By productNameLocator = new By.ByCssSelector(".pb-merchant-group");

    By loginPageButtonLocator = new By.ByCssSelector(".account-user > .link-text");

    By ratifyCart = new By.ByLinkText("Sepeti Onayla");

    By insideOfRatifyButton = new By.ByCssSelector(".Basket_CheckoutButton:nth-child(1)");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkIfProductAdded() {
        return getProducts().size() > 0;
    }

    private List<WebElement> getProducts(){
        return findAll(productNameLocator);
    }

    public void goToLogin() {
        click(loginPageButtonLocator);
    }

    public void goToRatifyCartPage() throws InterruptedException {
        Thread.sleep(5000);
        click(ratifyCart);
        click(insideOfRatifyButton);
    }

}

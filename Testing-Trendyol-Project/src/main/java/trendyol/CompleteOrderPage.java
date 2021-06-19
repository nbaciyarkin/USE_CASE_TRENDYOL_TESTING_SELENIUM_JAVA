package trendyol;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompleteOrderPage extends BasePage {

    By changeButton = new By.ByCssSelector(".addressstep > .edit");

    By generateAddressContainer = new By.ByCssSelector(".multiAddress > .newAddress");


    public CompleteOrderPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnCompleteOrderPage() throws InterruptedException {
        Thread.sleep(7000);
        return isDisplayed(changeButton);
    }

    public void clickAddAddress() throws InterruptedException {
        find(changeButton).click();
        Thread.sleep(2000);
        find(generateAddressContainer).click();
    }

}

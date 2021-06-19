package trendyol;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    SearchBar searchbox;
    By cartCountLocator = new By.ByCssSelector("");
    By cartContainerLocator = new By.ByCssSelector(".account-basket > .link-text");
    //By acceptCookiesLocator = new By.ByCssSelector("span.cookie-policy-accept-button");
    By chooseOpeningGenderLocator = new By.ByCssSelector("span.homepage-popup-gender");
    By sepetioOnayla = new By.ByLinkText("Sepeti Onayla");
    By sliderContainer = new By.ByCssSelector(".circled-slider .slick-next");
    By orderComplete = new By.ByCssSelector(".goPayment:nth-child(6) > .btn");


    public HomePage(WebDriver driver) {
        super(driver);
        searchbox = new SearchBar(driver);
    }

    public SearchBar searchBox() {
        return this.searchbox;
    }


    public void goToCart() throws InterruptedException {
        Thread.sleep(5000);
        click(cartContainerLocator);
    }

    public boolean isCartNumberIncrease() {
        return getCartCount() > 0;
    }

    private int getCartCount(){
        String count = find(cartCountLocator).getText();
        return Integer.parseInt(count);
    }



    /*public void acceptCookies(){
        if (isDisplayed(acceptCookiesLocator)){
            click(acceptCookiesLocator);
        }
    }*/

    public void chooseOpeningGender(){
        if(isDisplayed(chooseOpeningGenderLocator)){
            click(chooseOpeningGenderLocator);
        }
    }

    public boolean isLoginPassed() throws InterruptedException {
        Thread.sleep(3000);
        return isDisplayed(sepetioOnayla);

    }

    public boolean isOnHomePage() throws InterruptedException {
        Thread.sleep(3000);
        return isDisplayed(sliderContainer);
    }

    public void openOrderComplete(){
        find(orderComplete).click();
    }

}

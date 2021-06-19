package trendyol;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    By loginEmailLocator = new By.ById("login-email");
    By loginPasswordLocator = new By.ById("login-password-input");
    By loginPageEnterButton = new By.ByCssSelector(".q-primary > span");
    By errorMessage = new By.ByCssSelector(".message");


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public boolean isOnLoginPage() throws InterruptedException {
        Thread.sleep(5000);
        return isDisplayed(loginPasswordLocator) || isDisplayed(loginEmailLocator);
    }


    public void set_mail_password(String mail, String password) throws InterruptedException {
        find(loginEmailLocator).clear();
        type(loginEmailLocator, mail);
        Thread.sleep(3000);

        find(loginPasswordLocator).clear();
        type(loginPasswordLocator, password);

        Thread.sleep(3000);
        click(loginPageEnterButton);
    }


    public void clear_mail_and_password() throws InterruptedException {
        find(loginEmailLocator).clear();
        find(loginPasswordLocator).clear();

        Thread.sleep(2000);
    }

    public void clear_mail() throws InterruptedException {
       find(loginEmailLocator).clear();
    }

    public void clear_password() throws InterruptedException {
        find(loginPasswordLocator).clear();
    }

    public String error_message(){
        if(isDisplayed(errorMessage)){
            return find(errorMessage).getText();
        }else{
            return "login is satisfactory";
        }
    }

    public boolean isThereError() throws InterruptedException {
        Thread.sleep(1000);
        return isDisplayed(errorMessage);
    }

    public boolean isTheFieldsClear() {
        String email = find(loginEmailLocator).getText();
        String password = find(loginPasswordLocator).getText();
        if(email == "" || password == ""){
            return true;
        }
        else{
            return false;
        }
    }

}

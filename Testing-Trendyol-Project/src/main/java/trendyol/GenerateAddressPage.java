package trendyol;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GenerateAddressPage extends BasePage{

    By saveAddressButton = new By.ByCssSelector(".ty-font-w-semi-bold");

    By nameTextAre = new By.ByCssSelector(".name-group > .ty-display-flex:nth-child(1) > .ty-bg-beige");

    By surnameTextArea = new By.ByCssSelector(".ty-display-flex:nth-child(2) > .ty-bg-beige");

    By phoneNumberTextArea = new By.ByCssSelector(".ty-display-flex:nth-child(2) > .ty-display-flex > .ty-bg-beige");

    By nameOfAddressLine = new By.ByCssSelector(".ty-textarea");

    By addressTittle = new By.ByCssSelector(".ty-display-flex:nth-child(5) > .ty-bg-beige");

    By cityLocator = new By.ByCssSelector(".ty-display-flex:nth-child(2) > .ty-display-flex .ty-arrow");

    By setCityIzmır = new By.ByCssSelector(".ty-select-option:nth-child(3)");

    By districtLocator = new By.ByCssSelector(".ty-display-flex:nth-child(1) > div > .ty-display-flex > .ty-arrow");

    By setDistrictCesme = new By.ByCssSelector(".ty-on > .ty-select-option:nth-child(9)");

    By streetLocator = new By.ByCssSelector(".ty-display-flex:nth-child(3) > .ty-display-flex:nth-child(2) .ty-arrow");

    By setStreetIlıca = new By.ByCssSelector(".ty-on > .ty-select-option:nth-child(2)");


    // Error locator for the new address page
    //By phoneErrorMessage = new By.ByCssSelector(".ty-display-flex:nth-child(3) > .ty-display-flex:nth-child(2) .ty-arrow");

    //By nameErrorMessage = new By.ByCssSelector(".ty-display-flex:nth-child(2) > .ty-display-flex:nth-child(1) > .ty-display-flex > .ty-text:nth-child(1)");

    By nameeeError = new By.ByCssSelector(".ty-display-flex:nth-child(1) > .ty-display-flex:nth-child(1) > .ty-display-flex > .ty-text:nth-child(1)");

    By surnameErr =  new By.ByCssSelector(".ty-display-flex:nth-child(1) > .ty-display-flex:nth-child(2) > .ty-display-flex > .ty-text:nth-child(1)");

    By fuladdresErr =  new By.ByCssSelector(".ty-display-flex:nth-child(4) .ty-color-red");

    By addresstittleErr = new By.ByCssSelector(".ty-display-flex:nth-child(5) .ty-color-red");


    public GenerateAddressPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnGenerateAddressPage(){
        return isDisplayed(saveAddressButton);
    }

    public void clickSaveButton() throws InterruptedException {
        Thread.sleep(3000);
        click(saveAddressButton);
        Thread.sleep(3000);
    }

    public void saveAddress(){
        find(saveAddressButton).click();
    }

    public void setNameTextAre(String name){
        type(nameTextAre,name);
    }

    public void setSurnameTextArea(String name){
        type(surnameTextArea,name);
    }

    public void setPhoneNumberTextArea(String phone) throws InterruptedException {
        Thread.sleep(1000);
        click(phoneNumberTextArea);
        type(phoneNumberTextArea,phone);
        Thread.sleep(1000);
    }

    public void setNameOfAddressLine(String fullAddress){
        type(nameOfAddressLine,fullAddress);
    }

    public void setAddressTittle(String title){
        type(addressTittle,title);
    }


    public void setCityLocatorIzmır() throws InterruptedException {
        click(cityLocator);
        Thread.sleep(2000);
        click(setCityIzmır);
        Thread.sleep(2000);
    }

    public void setDistrictCesme() throws InterruptedException {
        click(districtLocator);
        Thread.sleep(4000);
        click(setDistrictCesme);
        Thread.sleep(1000);
    }

    public void setStreetIlıca() throws InterruptedException {
        Thread.sleep(3000);
        find(streetLocator).click();
        Thread.sleep(5000);
        find(setStreetIlıca).click();
    }

    public boolean isAnyErrorInTheArea() throws InterruptedException {
        Thread.sleep(4000);
      if(isDisplayed(nameeeError) || isDisplayed(surnameErr) || isDisplayed(fuladdresErr) || isDisplayed(addresstittleErr)){
          return true; // error in the are we can check in the gui
      }else{
          return false; // false no error in the use use case
      }
    }

}

package trendyol;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductPage extends BasePage {

    By shippingOptionLocator = new By.ByCssSelector(".sort-fltr-cntnr");
    By productNameLocator = new By.ByCssSelector("span.prdct-desc-cntnr-name");

    Set<String> currentWindowNames = new HashSet<>();


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isHaveProduct() {
        return isDisplayed(shippingOptionLocator);
    }

    public void selectProduct(int i) {
        this.currentWindowNames = driver.getWindowHandles();
        getAllProducts().get(i).click();
        String productDetailTabWindowName = waitForWindow(2000);
        driver.switchTo().window(productDetailTabWindowName);
    }

    private List<WebElement> getAllProducts(){
        return findAll(productNameLocator);
    }


    public String waitForWindow(int timeout) {
      try {
        Thread.sleep(timeout);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      Set<String> whNow = driver.getWindowHandles();
      Set<String> previousWindowNames = this.currentWindowNames;
      if (whNow.size() > previousWindowNames.size()) {
        whNow.removeAll(previousWindowNames);
      }
      return whNow.iterator().next();
    }

}

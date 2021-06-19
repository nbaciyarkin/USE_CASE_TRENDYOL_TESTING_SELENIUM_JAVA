package trendyol;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class ProductTest extends BaseTest {

    HomePage homePage;

    ProductPage productpage ;

    ProductDetailPage productDetailPage ;

    CartPage cartPage;

    LoginPage loginPage;

    CompleteOrderPage completeOrderPage;

    GenerateAddressPage generateAddressPage;

    @BeforeAll
    public void initParameters() {
        homePage = new HomePage(driver);

        //homePage.acceptCookies();


        // Product Page init
        productpage = new ProductPage(driver);

        // Product Detail Page init
        productDetailPage = new ProductDetailPage(driver);

        // Cart Page init
        cartPage = new CartPage(driver);

        // login Page init
        loginPage = new LoginPage(driver);

        // completeOrderPage
        completeOrderPage = new CompleteOrderPage(driver);

        // generateAddressPage
        generateAddressPage = new GenerateAddressPage(driver);
    }

    @Test
    @Order(0)
    public void select_popup() throws InterruptedException {
        homePage.chooseOpeningGender();
    }


    @Test
    @Order(1)
    public void search_product() throws InterruptedException {
        homePage.searchBox().search("drone");
        Assertions.assertTrue(productpage.isHaveProduct(),"not on productList Page");
    }

    @Test
    @Order(2)
    // Boundary analysis value(isIndexInPage)
    public void select_product() throws InterruptedException {
        productpage.selectProduct(1);
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(),"not on productDetailPage");
    }


    @Test
    @Order(3)
    public void insert_item_product_to_cart_and_check_item_is_added() throws InterruptedException {
        productDetailPage.addToCart();
        homePage.goToCart();
        Assertions.assertTrue(cartPage.checkIfProductAdded(),"Product  was not ınsert to cart");
    }

    @Test
    @Order(4)
    public void try_go_complete_order() throws InterruptedException {
        cartPage.goToRatifyCartPage(); // it goes to the login page beacuse we have to  sign in for competing order
        Assertions.assertTrue(loginPage.isOnLoginPage(),"Not in the Login Page");
    }

    @Test
    @Order(5)
    public void unsuccesful_login_with_unregistired_account() throws InterruptedException {
        loginPage.set_mail_password("yarkın.gazibaba@gmail.com","190lassafa");
        Assertions.assertTrue(loginPage.isThereError(),loginPage.error_message());
    }
    @Test
    @Order(6)
    public void unsuccesful_login_without_at_character() throws InterruptedException {
        loginPage.set_mail_password("dndr.idillgmail.com","19070006021idil");
        Assertions.assertTrue(loginPage.isThereError(),loginPage.error_message());
    }

    @Test
    @Order(7)
    public void clear_mail_and_password() throws InterruptedException {
        loginPage.clear_mail();
        loginPage.clear_password();
        loginPage.clear_mail_and_password();
        Assertions.assertTrue(loginPage.isTheFieldsClear(),"fields are not clear");
    }

    @Test
    @Order(8)
    public void succesful_login() throws InterruptedException {
        loginPage.set_mail_password("dndr.idill@gmail.com","19070006021idil");
        Assertions.assertTrue(completeOrderPage.isOnCompleteOrderPage(),"asdasd");
    }


   @Test
    @Order(9)
    public void open_generate_new_address_page() throws InterruptedException {
        completeOrderPage.clickAddAddress();
        Assertions.assertTrue(generateAddressPage.isOnGenerateAddressPage(),"not in generate address frame");
    }


    @Test
    @Order(10)
    public void try_generate_new_address_without_values() throws InterruptedException {
        generateAddressPage.clickSaveButton();
        Assertions.assertTrue(generateAddressPage.isAnyErrorInTheArea(),"no  errors");
    }


    @Test
    @Order(11)
    public void generate_new_address_values() throws InterruptedException {
        generateAddressPage.setNameTextAre("Yarkin");
        generateAddressPage.setSurnameTextArea("Gazi");
        generateAddressPage.setPhoneNumberTextArea("078160689");
        generateAddressPage.setCityLocatorIzmır();
        generateAddressPage.setDistrictCesme();
        generateAddressPage.setStreetIlıca();
        generateAddressPage.setAddressTittle("İş yeri");
        generateAddressPage.setNameOfAddressLine("Gazibaba holding, mobil ekibi binası kat 8 oda no:4 ");
        generateAddressPage.clickSaveButton();
    }

}

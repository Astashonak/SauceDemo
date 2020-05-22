package tests;

import models.User;
import org.testng.annotations.Test;

public class SauceDemoTest extends BaseTest{

    @Test
    public void loginTest(){
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.openPage();
        cartPage.validateNumberOfProducts(1);
        cartPage.validateProductDetails("Sauce Labs Backpack", 1, 29.99);
        checkOutPage.openPage();
        checkOutPage.checkoutYouInformation("Elena", "Astashonak", "110022");
    }

    @Test
    public void placeholder(){
        loginPage.openPage();
        loginPage.placeholderUsername();
        loginPage.placeholderPassword();
    }

    @Test
    public void sortContainerDefaultOption(){
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.defaultOptionSortContainer();
    }

//    System.getProperty("testProp")

//    @Test
//    public void tryMaven(){
//        loginPage.openPage();
//        loginPage.login(System.getProperty("user"), System.getProperty("password"));
//        productsPage.defaultOptionSortContainer();
//    }


    @Test
    public void loginWithLockedUserTest(){
        loginPage
                .openPage();
        loginPage.loginWithLockedUser("locked_out_user", "secret_sauce");
    }

    @Test
    public void sortContainerByPriceLowToHigh(){
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.priceLowToHighOptionSortContainer();
    }

    @Test
    public void loginTestTwo(){
        User user = new User("lfdmger", "sjfweiu");
        loginPageFactory
                .openPage()
                .login(user)
                .addToCart("Sauce Labs Backpack")
//                .addToCart("Sauce Labs Bolt T-Shirt")
                .clickCart()
                .validateProductDetails("Sauce Labs Backpack", 1, 3);
    }
}

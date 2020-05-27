package tests;

import models.User;
import org.testng.annotations.Test;

public class SauceDemoTest extends BaseTest{

    @Test(description = "Тест на проверку количества продуктов и их деталей")
    public void loginTest(){
        steps.openPage();
        steps.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.openPage();
        cartPage.validateNumberOfProducts(1);
        cartPage.validateProductDetails("Sauce Labs Backpack", 1, 29.99);
        checkOutPage.openPage();
        checkOutPage.checkoutYouInformation("Elena", "Astashonak", "110022");
    }

    @Test(description = "Проверка наличия  placeholder при регистрации")
    public void placeholderShouldExist(){
        steps.openPage();
        steps.validatePlaceholderForUserName();
        steps.validatePlaceholderPassword();
    }

    @Test(description = "Проверка Default опции сортировки")
    public void sortContainerDefaultOption(){
        steps.openPage();
        steps.login("standard_user", "secret_sauce");
        productsPage.defaultOptionSortContainer();
    }

//    System.getProperty("testProp")

//    @Test
//    public void tryMaven(){
//        loginPage.openPage();
//        loginPage.login(System.getProperty("user"), System.getProperty("password"));
//        productsPage.defaultOptionSortContainer();
//    }


    @Test(description = "Проверка сообщения об ошибке при регистрации LockedUser")
    public void loginWithLockedUserTest(){
        steps
                .openPage();
        steps.loginWithLockedUser("locked_out_user", "secret_sauce");
    }

    @Test(description = "Проверка сортировка продуктов по 'Price (low to high)'")
    public void sortContainerByPriceLowToHigh(){
        steps.openPage();
        steps.login("standard_user", "secret_sauce");
        productsPage.priceLowToHighOptionSortContainer("lohi");
    }

    @Test(description = "Тест на проверку деталей продукта")
    public void loginTestTwo(){
        User user = new User("standard_user", "secret_sauce");
        loginPageFactory
                .openPage()
                .login(user)
                .addToCart("Sauce Labs Backpack")
                .clickCart()
                .validateProductDetails("Sauce Labs Backpack", 1, 29.99);
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductsPage extends BasePage {

    private static final String ADD_TO_CART_LOCATOR = "//*[text()='%s']/../../..//button";
    private static final By SORT_CONTAINER_LOCATOR = By.cssSelector(".product_sort_container");
    private static final String URL = "https://www.saucedemo.com/inventory.html";

    private String sortOptionByDefault = "az";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(URL);
    }

    public void addToCart(String productName){
        By addToCartXpath = By.xpath(String.format(ADD_TO_CART_LOCATOR, productName));
        driver.findElement(addToCartXpath).click();
    }

    public void defaultOptionSortContainer(){
        String realSortOption = driver.findElement(SORT_CONTAINER_LOCATOR).getAttribute("value");
        Assert.assertEquals(realSortOption, sortOptionByDefault, "Сортировка по default не 'Name (A to Z)'");
    }
}

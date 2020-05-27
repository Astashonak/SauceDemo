package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductsPage extends BasePage {

    private static final String ADD_TO_CART_LOCATOR = "//*[text()='%s']/../../..//button";
    private static final By SORT_CONTAINER = By.cssSelector(".product_sort_container");
    private static final By SORT_CONTAINER_LOW_TO_HIGH_PRICE = By.xpath("//option[text()='Price (low to high)']");
    private static final String URL = "https://www.saucedemo.com/inventory.html";
    private static final String ADD_TO_CART_CSS = ".btn_inventory";
    private static final String CART_CSS = ".shopping_cart_link";

    private String sortOptionByDefault = "az";


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductsPage openPage() {
        driver.get(URL);
       waitForNumberOfElement(By.cssSelector(ADD_TO_CART_CSS), 6);
        return this;
    }

    @Override
    protected ProductsPage isPageOpen() {
        waitForNumberOfElement(By.cssSelector(ADD_TO_CART_CSS), 6);
        return this;
    }


    public ProductsPage addToCart(String productName) {
        waitForNumberOfElement(By.cssSelector(ADD_TO_CART_CSS), 6);
        By addToCartXpath = By.xpath(String.format(ADD_TO_CART_LOCATOR, productName));
        driver.findElement(addToCartXpath).click();
        return this;
    }

    public void defaultOptionSortContainer() {
        String realSortOption = driver.findElement(SORT_CONTAINER).getAttribute("value");
        Assert.assertEquals(realSortOption, sortOptionByDefault, "Сортировка по default не 'Name (A to Z)'");
    }

    public void priceLowToHighOptionSortContainer(String sortOption){
        driver.findElement(SORT_CONTAINER_LOW_TO_HIGH_PRICE).click();
        String newSortOption = driver.findElement(SORT_CONTAINER).getAttribute("value");
        Assert.assertEquals(newSortOption, sortOption, "Сортировка не по 'Price (low to high)'");
    }

    public CartPage clickCart() {
       driver.findElement(By.cssSelector(CART_CSS)).click();
       return new CartPage(driver);
        }
}

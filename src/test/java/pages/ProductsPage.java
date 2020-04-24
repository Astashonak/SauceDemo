package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductsPage extends BasePage {

    private static final String ADD_TO_CART_LOCATOR = "//*[text()='%s']/../../..//button";
    private static final By SORT_CONTAINER = By.cssSelector(".product_sort_container");
    private static final By SORT_CONTAINER_LOW_TO_HIGH_PRICE = By.xpath("//option[text()='Price (low to high)']");
    private static final String URL = "https://www.saucedemo.com/inventory.html";

    private String sortOptionByDefault = "az";
    private String sortOptionLowToHighPrice = "lohi";
    private static final By FIRST_ITEM_AFTER_SORTING = By.xpath("//div[1]/div[@class='pricebar']/div[@class='inventory_item_price']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(URL);
    }

    public void addToCart(String productName) {
        By addToCartXpath = By.xpath(String.format(ADD_TO_CART_LOCATOR, productName));
        driver.findElement(addToCartXpath).click();
    }

    public void defaultOptionSortContainer() {
        String realSortOption = driver.findElement(SORT_CONTAINER).getAttribute("value");
        Assert.assertEquals(realSortOption, sortOptionByDefault, "Сортировка по default не 'Name (A to Z)'");
    }
/*не очень понимаю как проверять что товары отсортированы */
//    public void priceLowToHighOptionSortContainer(){
//        String newSortOption = driver.findElement(SORT_CONTAINER_LOW_TO_HIGH_PRICE).getAttribute("value");
//        Assert.assertEquals(newSortOption, sortOptionLowToHighPrice, "Сортировка не по 'Price (low to high)'");
//   }

    public void priceLowToHighOptionSortContainer(String price){
        driver.findElement(SORT_CONTAINER_LOW_TO_HIGH_PRICE).click();
        String lowPrice = driver.findElement(FIRST_ITEM_AFTER_SORTING).getText();
        Assert.assertEquals(lowPrice, String.valueOf(price),
                "Первый товар не с наименьшей ценой");
    }
}

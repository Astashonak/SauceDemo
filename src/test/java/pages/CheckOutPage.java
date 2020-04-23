package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePage{

    private static final By FIRST_NAME = By.id("first-name");
    private static final By LAST_NAME = By.id("last-name");
    private static final By ZIP_POSTAL_CODE = By.id("postal-code");
    private static final By CONTINUE_BUTTON = By.cssSelector(".btn_primary.cart_button");
    private static final String URL = "https://www.saucedemo.com/checkout-step-one.html";

    public CheckOutPage(WebDriver driver){
        super(driver);
    }

    public void openPage() {
        driver.get(URL);
    }

    public void checkoutYouInformation(String firstName, String lastName, String zipCode){
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(ZIP_POSTAL_CODE).sendKeys(zipCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }
}

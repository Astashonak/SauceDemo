package pages;

import org.openqa.selenium.By;
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

    @Override
    public CheckOutPage openPage() {
        driver.get(URL);
        return this;
    }

    @Override
    protected BasePage isPageOpen() {
        return this;
    }

    public void checkoutYouInformation(String firstName, String lastName, String myStringZipCode){
        int zipCode = Integer.parseInt (myStringZipCode);;
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(ZIP_POSTAL_CODE).sendKeys(String.valueOf(zipCode));
        driver.findElement(CONTINUE_BUTTON).click();
    }
}

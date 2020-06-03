package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class LoginPage extends BasePage {
    private static final By USER_NAME = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.cssSelector(".btn_action");
    private static final String LOGIN_URL = "https://www.saucedemo.com/index.html";
    private static final By ERROR_TEXT = By.cssSelector("h3");
    private String errorMessage = "Epic sadface: Sorry, this user has been locked out.";

    private String usernamePlaceholder = "Username";
    private String passwordPlaceholder = "Password";

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @Override
    public LoginPage openPage(){ driver.get(LOGIN_URL);
        return this;}

    @Override
    protected LoginPage isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        return this;
    }

    public void login(String userName, String password){

        driver.findElement(USER_NAME).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void validatePlaceholderForUserName(){

        String realUsernamePlaceholder = driver.findElement(USER_NAME).getAttribute("placeholder");

        Assert.assertEquals(realUsernamePlaceholder, usernamePlaceholder, "Placeholder username не совпадает");
    }

    public void validatePlaceholderPassword(){
        String realPasswordPlaceholder = driver.findElement(PASSWORD_INPUT).getAttribute("placeholder");
        Assert.assertEquals(realPasswordPlaceholder, passwordPlaceholder, "Placeholder password не совпадает");
    }

    public void loginWithLockedUser(String userName, String password){
        driver.findElement(USER_NAME).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        String realErrorMessage = driver.findElement(ERROR_TEXT).getText();
        Assert.assertEquals(realErrorMessage, errorMessage, "Неверное сообщение об ошибке");
    }
}

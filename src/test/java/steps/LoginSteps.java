package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {
    private LoginPage page;

    public LoginSteps(WebDriver driver){
        page = new LoginPage(driver);
    }

    @Step("Открыть SauceDemo")
    public LoginSteps openPage(){
        page
                .openPage();
        return this;
    }

    @Step("Залогиниться пользователем, используя: '{userName}' и '{password}'")
    public LoginSteps login(String userName, String password){
      page
              .login(userName, password);
      return this;
    }

    @Step("Проверить плэйсхолдер для имени пользователя")
    public LoginSteps validatePlaceholderForUserName(){
        page
                .validatePlaceholderForUserName();
        return this;
    }

    @Step("Проверить плэйсхолдер для пароля")
    public LoginSteps validatePlaceholderPassword(){
        page
                .validatePlaceholderPassword();
        return this;
    }

    @Step("Залогиниться заблоченым пользователем, используя: '{userName}' и '{password}'")
    public LoginSteps loginWithLockedUser(String userName, String password){
        page
                .loginWithLockedUser(userName, password);
        return this;
    }
}

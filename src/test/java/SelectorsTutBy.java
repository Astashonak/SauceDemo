import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SelectorsTutBy {

    @Test
    public void selectorsJobsPage(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://jobs.tut.by/");
        driver.findElement(By.linkText("Помощь"));
        driver.findElement(By.tagName("iframe"));
        driver.findElement(By.partialLinkText("Хочу"));
        driver.findElement( By.xpath("//a[@href='/account/login?backurl=%2F']"));
        driver.findElements(By.xpath("//div[@class='index-useful']/child::div"));
        driver.findElements(By.xpath("//div[@class='work-in-other-cities']/descendant::li"));
        driver.findElements(By.xpath("//div[@class='work-in-other-cities']/descendant-or-self::li"));
        driver.findElements(By.xpath("//*[@type='text']//following::placeholder"));
        driver.findElements(By.xpath("//ul[@class='supernova-footer-menu-additional']//following-sibling::ul"));
        driver.findElements(By.xpath("//li[@class='news-box-item']//parent::a"));
        driver.findElements(By.xpath("//div[@class='index-useful']//preceding::h3"));
        driver.findElements(By.xpath("//div[@class='index-useful']//preceding-sibling::h3"));
        driver.findElements(By.xpath("//span[@class='text-large']/self::span"));
        driver.findElements(By.cssSelector(".text-large"));
        driver.findElements(By.cssSelector(".useful-link .bloko-link"));
        driver.findElements(By.cssSelector("ul.supernova-footer-menu-additional"));
        driver.quit();
    }

    @Test
    public void selectorsMainPage(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tut.by/?utm_source=main_page&utm_medium=main_resource_block&utm_campaign=tutby_links");
        driver.findElement(By.id("animated_mainmenu"));
        driver.findElement(By.name("login_action"));
        driver.findElement(By.className("b-topbar-more"));
        driver.findElements(By.xpath("//ancestor::div[@class='b-topbar']"));
        driver.findElements(By.xpath("//ancestor-or-self::div[@class='w-header']"));
        driver.findElements(By.cssSelector("#animated_mainmenu"));
        driver.quit();
    }
}

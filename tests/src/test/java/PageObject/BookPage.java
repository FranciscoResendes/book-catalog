package PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookPage {
    private static final String URL = "http://localhost:4200/";
    private static final String LOGIN_BUTTON = "//a[contains(text(),'Login')]";
    WebDriver driver;
    WebDriverWait wait;

    public BookPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openUrl() {
        driver.get(URL);
        driver.manage().window().maximize();
    }

    public void goToLoginPage() {
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
    }

    public void enterLoginCredentials(String username, String password) {
        driver.findElement(By.id("loginUsername")).sendKeys(username);
        driver.findElement(By.id("loginPassword")).sendKeys(password);
        driver.findElement(By.id("loginButton")).click();
    }
}

package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
    private static final String URL = "http://localhost:4200/";
    private static final String loginButton = "//a[contains(text(),'Login')]";
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openUrl() {
        driver.get(URL);
        driver.manage().window().maximize();
    }
    
    public void goToLoginPage() {
        driver.findElement(By.xpath(loginButton)).click();
    }

    public void enterLoginCredentials(String username, String password) {
        driver.findElement(By.id("loginUsername")).sendKeys(username);
        driver.findElement(By.id("loginPassword")).sendKeys(password);
        driver.findElement(By.id("loginButton")).click();
    }
}

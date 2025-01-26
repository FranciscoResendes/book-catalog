package PageObject;

import org.openqa.selenium.WebDriver;


public class LoginPage {
    private static final String URL = "http://localhost:4200/";
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openUrl() {
        driver.get(URL);
        driver.manage().window().maximize();
    }
    
}

package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().driverVersion("132.0.6834.111").setup();
        driver = new ChromeDriver();
        return driver;
    }

    public static void closeDriver(WebDriver driver) {
        driver.quit();
    }
    
}

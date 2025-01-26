package StepsDefenition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
    WebDriver driver;


    @Given("I am in the login page")
    public void an_empty_step() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://localhost:4200/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[text()='Login']")).click();
    }

    @When("I fill the username field with {string} and {string}")
    public void another_empty_step(String username, String password) {
        driver.findElement(By.id("loginUsername")).sendKeys(username);
        driver.findElement(By.id("loginPassword")).sendKeys(password);
        driver.findElement(By.id("loginButton")).click();
    }

    @Then("I am Successfully logged in")
    public void yet_another_empty_step() {
        // Implement your step here
    }
}

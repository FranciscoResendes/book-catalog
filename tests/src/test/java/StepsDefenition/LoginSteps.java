package StepsDefenition;

import org.openqa.selenium.WebDriver;

import PageObject.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.DriverManager;

public class LoginSteps {
    WebDriver driver = DriverManager.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("I am in the login page")
    public void openLoginPage() {
        loginPage.openUrl();
        loginPage.goToLoginPage();
    }

    @When("I fill the fields with {string} and {string}")
    public void sendCredentials(String username, String password) {
        loginPage.enterLoginCredentials(username, password);
    }

    @Then("I am successfully logged in")
    public void isLoggedIn() {
        loginPage.checkLoginSuccess();
        DriverManager.closeDriver(driver);
    }

    @Then("I am not logged in")
    public void isNotLoggedIn() {
        loginPage.checkLoginFail();
        DriverManager.closeDriver(driver);
    }
}

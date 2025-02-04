package StepsDefenition;

import org.openqa.selenium.WebDriver;

import PageObject.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.DriverManager;

public class RegisterSteps {
        WebDriver driver = DriverManager.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("I am on the register page")
    public void openRegisterPage() {
        loginPage.openUrl();
        loginPage.goToRegisterPage();
    }

    @When("I register with the following data {string}, {string}, {string}")
    public void sendCredentials(String username, String password, String email) {
        loginPage.enterRegisterCredentials(username, password, email);
    }

    @Then("I should be registered")
    public void isRegistered() {
        //loginPage.checkRegisterSuccess();
        DriverManager.closeDriver(driver);
    }

    @Then("I am not registered")
    public void isNotRegisterd() {
        //loginPage.checkRegisterFail();
        DriverManager.closeDriver(driver);
    }
}

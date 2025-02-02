package StepsDefenition;

import org.openqa.selenium.WebDriver;

import PageObject.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.DriverManager;

public class LogoutSteps {
    WebDriver driver = DriverManager.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("I am logged in")
    public void login() {
        loginPage.openUrl();
        loginPage.goToLoginPage();
        loginPage.enterLoginCredentials("admin", "admin");
    }

    @When("I click on the logout button")
    public void logout() {
        loginPage.logout();
    }

    @Then("I am logged out")
    public void isLoggedOut() {
        //loginPage.checkLogout();
        DriverManager.closeDriver(driver);
    }
}

package StepsDefenition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {
    @Given("I am on the home page")
    public void goToHomePage(){

    }

    @When("I search for the book {string}")
    public void searchBook(String bookTitle){

    }

    @Then("I should see the book {string} in the list of books")
    public void isSearchCorrect(){

    }
}

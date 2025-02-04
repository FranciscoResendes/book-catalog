Feature: Register
    Scenario Outline: Register a new user
        Given I am on the register page
        When I register with the following data "<username>", "<password>", "<email>"
        Then I should be registered

    Examples:
        | username | password | email       |
        | user     | pass     | email       |
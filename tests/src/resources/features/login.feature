Feature: Login with different credentials

  Scenario Outline: Successful login
    Given I am in the login page
    When I fill the fields with "<username>" and "<password>"
    Then I am successfully logged in

    Examples:
      | username | password |
      | admin    | admin    |

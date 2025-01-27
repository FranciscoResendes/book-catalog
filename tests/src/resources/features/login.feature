Feature: Login with diferent credentials

  Scenario: Successful login
    Given I am in the login page
    When I fill the username field with "<username>" and "<password>"
    Then I am Successfully logged in

    Examples:
      | username | password |
      | admin    | admin    |

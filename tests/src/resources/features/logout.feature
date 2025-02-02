  Feature: Logout
  
  Scenario: Logout
    Given I am logged in
    When I click on the logout button
    Then I am logged out
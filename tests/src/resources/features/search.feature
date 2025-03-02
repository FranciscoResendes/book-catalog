Feature: Search bar

  Scenario Outline: Search for a book
    Given I am on the home page
    When I search for the book "<title>"
    Then I should see the book "<title>" in the list of books

  Examples:
    | title             |
    | The Lord of Rings |
    #| The Hobbit        |
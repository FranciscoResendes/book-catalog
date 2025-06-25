Feature: Manage books (Add, remove books and change status)

  Scenario Outline: Add a book
    Given I am logged in
    When I add a book with the title "<title>" and author "<author>"
    Then the book should be added to the list of books

  Examples:
    | title             | author         |
    | The Lord of Rings | J.R.R. Tolkien |
    #| The Hobbit        | J.R.R. Tolkien |

  Scenario Outline: Remove a book
    Given I am logged in
    When I add a book with the title "<title>" and author "<author>"
    And I remove the book
    Then the book should be removed from the list of books

    Examples:
      | title             | author         |
      | The Lord of Rings | J.R.R. Tolkien |
    #| The Hobbit        | J.R.R. Tolkien |

  Scenario Outline: Change status of a book
    Given I am logged in
    When I add a book with the title "<title>" and author "<author>"
    And I change the "<status>" of the book previously added
    Then the status of the book should be "<status>"

    Examples:
      | title             | author         | status |
      | The Lord of Rings | J.R.R. Tolkien | read   |
    #| The Hobbit        | J.R.R. Tolkien | unread |
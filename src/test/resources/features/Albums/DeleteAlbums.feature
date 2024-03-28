Feature: Delete Albums
  @Project
  Scenario Outline: Delete albums with valid id
    Given Delete albums with valid id <id>
    When Send request delete albums
    Then Status code should be 200
    Examples:
      | id |
      | 1  |
      | 5  |
      | 7  |

  @Project
  Scenario Outline: Delete albums with invalid id
    Given Delete albums with invalid id <id>
    When Send request delete albums
    Then Status code should be 404
    Examples:
      | id    |
      | satu  |
      | $%^&* |
      | #abc# |
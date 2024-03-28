Feature: Delete Posts

  @Project
  Scenario Outline: Delete posts with valid parameter Id
    Given Delete posts with valid parameter Id <id>
    When  Send request get posts
    Then Status code should be 200
    Examples:
      | id |
      | 1  |
      | 2  |

  @Project
  Scenario Outline: Delete posts with invalid parameter Id
    Given Delete posts with invalid parameter Id <id>
    When Send request get posts
    Then Status code should be 404
    Examples:
      | id   |
      | satu |
      | *&   |

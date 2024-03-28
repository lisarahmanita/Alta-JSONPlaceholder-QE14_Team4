Feature: Get Posts

  @Project
  Scenario Outline: Get posts with valid parameter Id
    Given Get posts with valid parameter Id <id>
    When Send request get posts
    Then Status code should be 200
    And validate posts json "GetPostsJsonSchema.json"
    Examples:
      | id |
      | 1  |
      | 2  |

  @Project
  Scenario Outline: Get posts with invalid parameter Id
    Given Get posts with invalid parameter Id <id>
    When Send request get posts
    Then Status code should be 404
    Examples:
      | id   |
      | satu |
      | *&   |
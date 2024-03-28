Feature: Update Posts

  @Project
  Scenario Outline: Update posts with valid Id and Json
    Given Update posts with valid id <id> and valid json "<json>"
    When Send request update posts
    Then Status code should be 200
    And Response body id should <id> and title should "<tittle>"
    And validate posts json "UpdatePostsJsonSchema.json"
    Examples:
      | id | json              | tittle              |
      | 1  | UpdatePosts1.json | magnam facilis aute |
      | 2  | UpdatePosts2.json | magnam facilis aute |

  @Project
  Scenario Outline: Update posts with invalid Id and Json
    Given Update posts with invalid id <id> and invalid json "<json>"
    When Send request update posts
    Then Status code should be 404
    Examples:
      | id | json              |  |
      | *& | UpdatePosts1.json |  |
      | ^% | UpdatePosts2.json |  |
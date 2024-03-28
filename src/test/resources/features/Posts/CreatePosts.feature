Feature: Create Posts

  @Project
  Scenario Outline: Create posts with valid json
    Given Create posts with valid json <json>
    When  Send request create posts
    Then Status code should be 201
    And Response body userId should <userId> and title should "<title>"
    And validate posts json "CreatePostsJsonSchema.json"
    Examples:
      | json              | userId | title               |
      | CreatePosts1.json | 1      | magnam facilis aute |


  @Project
  Scenario Outline: Create posts with invalid json
    Given Create posts with invalid json <json>
    When  Send request create posts
    Then Status code should be 400

    Examples:
      | json              |  |  |
      | CreatePosts1.json |  |  |


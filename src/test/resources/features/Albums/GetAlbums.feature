Feature: Get Albums
  @Project
  Scenario: Get all list albums with valid parameter
    Given Get all list albums with valid parameter
    When Send request get list albums
    Then Status code should be 200
    And Validate json schema "ListAlbumsJsonSchema.json"

  @Project
  Scenario Outline: Get albums with valid parameter id
    Given Get albums with valid parameter id <id>
    When Send request get single albums
    Then Status code should be 200
    And Response body id should <id> and title should "<title>"
    And Validate json schema "SingleAlbumsJsonSchema.json"
    Examples:
      | id | title                            |
      | 1  | quidem molestiae enim            |
      | 2  | sunt qui excepturi placeat culpa |

  @Project
  Scenario Outline: Get albums with invalid parameter id
    Given Get albums with invalid parameter id <id>
    When Send request get single albums
    Then Status code should be 404
    Examples:
      | id   |
      | satu |
      | $@tu |
